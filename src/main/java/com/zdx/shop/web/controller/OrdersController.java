package com.zdx.shop.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zdx.shop.common.utils.Page;
import com.zdx.shop.po.Orders;
import com.zdx.shop.po.Shop;
import com.zdx.shop.po.User;
import com.zdx.shop.service.OrdersService;

@Controller
public class OrdersController {
	@Autowired
	private OrdersService ordersService;

	@RequestMapping("listOrders.s")
	public String listShopOrders(
			@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(name = "size", defaultValue = "6") Integer size,
			Model model, HttpSession session) {
		Shop shop = (Shop) session.getAttribute("SHOP_SESSION");
		Page<Orders> page = ordersService.queryOrderListByShopId(shop.getId(),
				pageNo, size);
		model.addAttribute("page", page);
		return "shopOrders";
	}
	@RequestMapping("listOrders.u")
	public String listShopProducts(
			@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
			@RequestParam(name = "size", defaultValue = "6") Integer size,
			Model model, HttpSession session) {
		User user = (User) session.getAttribute("USER_SESSION");
		Page<Orders> page = ordersService.queryOrderListByUserId(user.getId(),
				pageNo, size);
		model.addAttribute("page", page);
		return "userOrders";
	}
}
