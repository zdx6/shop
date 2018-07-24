package com.zdx.shop.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zdx.shop.service.ShopService;

@Controller
public class ShopController {
	@Autowired
	private ShopService shopService;

	@RequestMapping("/home.s")
	public String toHome() {
		return "shopHome";
	}
}
