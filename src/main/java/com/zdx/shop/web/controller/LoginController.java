package com.zdx.shop.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zdx.shop.po.Shop;
import com.zdx.shop.po.User;
import com.zdx.shop.service.ShopService;
import com.zdx.shop.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService usv;
	@Autowired
	private ShopService ssv;

	@RequestMapping("/login")
	public String toLogin() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("name") String loginName,
			@RequestParam("psw") String password,
			@RequestParam("type") int type, Model model, HttpSession session) {
		if (type == 0) {
			User user = usv.login(loginName, password);
			if (user == null) {
				model.addAttribute("msg", "账号或密码错误！");
				return "login";
			}
			session.setAttribute("USER_SESSION", user);
			return "redirect:listOrders.u";
		}
		if (type == 1) {
			Shop shop = ssv.login(loginName, password);
			if (shop == null) {
				model.addAttribute("msg", "账号或密码错误！");
				return "login";
			}
			session.setAttribute("SHOP_SESSION", shop);
			return "redirect:listOrders.s";
		}
		return "error";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:login";
	}
}
