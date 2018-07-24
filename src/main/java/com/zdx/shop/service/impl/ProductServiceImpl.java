package com.zdx.shop.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdx.shop.common.utils.Page;
import com.zdx.shop.dao.ProductDao;
import com.zdx.shop.po.Product;
import com.zdx.shop.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;

	@Override
	public Product queryById(int id) {
		return productDao.queryById(id);
	}

	@Override
	public Page<Product> queryProductList(String productName, Integer type,
			Integer shopId, int pageNo, int size) {
		Page<Product> page = new Page<>();
		page.setPageNo(pageNo);
		page.setSize(size);
		Product product = new Product();
		if (StringUtils.isNotBlank(productName))
			product.setProductName(productName);
		product.setType(type);
		product.setShopId(shopId);
		product.setStart((pageNo - 1) * size);
		product.setSize(size);
		List<Product> products = productDao.queryProductList(product);
		page.setRows(products);
		page.setTotal(productDao.selectProductListCount(product));
		return page;
	}

	@Override
	public int insertProduct(Product product) {
		return productDao.insertProduct(product);
	}

	@Override
	public int updateProduct(Product product) {
		return productDao.updateProduct(product);
	}

	@Override
	public int updateProductStock(int productId, int num) {
		return productDao.updateProductStock(productId, num);
	}

	@Override
	public int deleteProduct(int productId) {
		return productDao.deleteProduct(productId);
	}
}
