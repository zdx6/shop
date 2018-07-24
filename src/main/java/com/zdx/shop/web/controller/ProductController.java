package com.zdx.shop.web.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zdx.shop.common.utils.Page;
import com.zdx.shop.po.Product;
import com.zdx.shop.po.Shop;
import com.zdx.shop.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping("listProduct.s")
	public String listShopProduct(
			@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(name = "size", defaultValue = "6") Integer size,
			Model model, HttpSession session) {
		Shop shop = (Shop) session.getAttribute("SHOP_SESSION");
		Page<Product> page = productService.queryProductList(null, null,
				shop.getId(), pageNo, size);
		model.addAttribute("page", page);
		return "shopProduct";
	}

	@RequestMapping("listProduct.u")
	public String listUserProduct(
			@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(name = "size", defaultValue = "6") Integer size,
			Model model, HttpSession session,
			@RequestParam(name = "pname", required = false) String productName) {
		Page<Product> page = productService.queryProductList(productName, null,
				null, pageNo, size);
		model.addAttribute("page", page);
		return "userProduct";
	}

	@RequestMapping(value = "createProduct.s")
	@ResponseBody
	public String createProduct(
			@RequestParam(value = "image1", required = false) MultipartFile image1,
			@RequestParam(value = "image2", required = false) MultipartFile image2,
			@RequestParam(value = "image3", required = false) MultipartFile image3,
			Product product, HttpSession session, HttpServletRequest request)
			throws IOException {
		product.setImg1(uploadProductImg(image1, request, session));
		product.setImg2(uploadProductImg(image2, request, session));
		product.setImg3(uploadProductImg(image3, request, session));
		Shop shop = (Shop) session.getAttribute("SHOP_SESSION");
		product.setShopId(shop.getId());
		int rows = productService.insertProduct(product);
		if (rows > 0)
			return "OK";
		else
			return "fail";
	}

	private String uploadProductImg(MultipartFile file,
			HttpServletRequest request, HttpSession session) throws IOException {
		if (file!=null&&!file.isEmpty()) {
			String path = request.getSession().getServletContext()
					.getRealPath("upload/");
			Shop shop = (Shop) session.getAttribute("SHOP_SESSION");
			int shopId = shop.getId();
			String fileName = file.getOriginalFilename();
			File targetFile = new File(path, shopId + File.separator + fileName);
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			try {
				file.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "upload/" + shopId + File.separator + fileName;
		} else {
			return null;
		}
	}

	@RequestMapping("deleteProduct.s")
	@ResponseBody
	public String deleteProduct(@RequestParam("id") Integer id,
			HttpSession session) {
		int rows = productService.deleteProduct(id);
		if (rows > 0)
			return "OK";
		else
			return "fail";
	}

	@RequestMapping("getProductById.shop")
	// 用.s作后缀会出现bug
	@ResponseBody
	public Product getProductById(@RequestParam("id") int id,
			HttpSession session) {
		Product product = productService.queryById(id);
		product.setShop(null); // 返回的对象里不能有对象属性
		return product;
	}

	@RequestMapping("updateProduct.shop")
	@ResponseBody
	public String updateProduct(
			@RequestParam(value = "image1", required = false) MultipartFile image1,
			@RequestParam(value = "image2", required = false) MultipartFile image2,
			@RequestParam(value = "image3", required = false) MultipartFile image3,
			Product product, HttpSession session,HttpServletRequest request) throws IOException {
		product.setImg1(uploadProductImg(image1, request, session));
		product.setImg2(uploadProductImg(image2, request, session));
		product.setImg3(uploadProductImg(image3, request, session));
		Shop shop = (Shop) session.getAttribute("SHOP_SESSION");
		if (shop.getId() == product.getShopId()) {
			productService.updateProduct(product);
			return "OK";
		}
		return "fail";
	}
}
