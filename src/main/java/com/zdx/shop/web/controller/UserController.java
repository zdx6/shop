package com.zdx.shop.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdx.shop.common.BuyStateEnum;
import com.zdx.shop.exception.BuyException;
import com.zdx.shop.exception.LackMoneyException;
import com.zdx.shop.exception.LackProductException;
import com.zdx.shop.po.User;
import com.zdx.shop.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService usv;

	@RequestMapping("buyProduct.u")
	@ResponseBody
	public Map<String, Object> buyProduct(
			@RequestParam("productId") Integer productId,
			@RequestParam("addressId") Integer addressId, HttpSession session) {
		User user = (User) session.getAttribute("USER_SESSION");
		try {
			usv.buyProduct(user.getId(), productId, addressId);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("state", BuyStateEnum.SUCCESS.getState());
			map.put("stateInfo", BuyStateEnum.SUCCESS.getStateInfo());
			return map;
		} catch (LackProductException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("state", BuyStateEnum.LACK_PRODUCT.getState());
			map.put("stateInfo", BuyStateEnum.LACK_PRODUCT.getStateInfo());
			return map;
		} catch (LackMoneyException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("state", BuyStateEnum.LACK_MONEY.getState());
			map.put("stateInfo", BuyStateEnum.LACK_MONEY.getStateInfo());
			return map;
		} catch (BuyException e) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("state", BuyStateEnum.FAIL.getState());
			map.put("stateInfo", BuyStateEnum.FAIL.getStateInfo());
			return map;
		}
	}
}
