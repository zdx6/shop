package com.zdx.shop.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zdx.shop.po.Address;
import com.zdx.shop.po.User;
import com.zdx.shop.service.AddressService;

@Controller
public class AddressController {
	@Autowired
	private AddressService addressService;

	@RequestMapping("listAddress.u")
	public String listAddress(HttpSession session, Model model) {
		User user = (User) session.getAttribute("USER_SESSION");
		List<Address> addresses = addressService.queryAddressListByUserId(user
				.getId());
		model.addAttribute("addresses", addresses);
		return "userAddress";
	}

	@RequestMapping("/getAddressById.u")
	@ResponseBody
	public Address getAddressById(HttpSession session,
			@RequestParam("id") Integer id) {
		User user = (User) session.getAttribute("USER_SESSION");
		Address address = addressService.queryById(id);
		System.out.println(address);
		if (user.getId() == address.getUserId()) {
			return address;
		} else {
			return null;
		}
	}

	@RequestMapping("updateAddress.u")
	@ResponseBody
	public String updateAddress(Address address, HttpSession session) {
		User user = (User) session.getAttribute("USER_SESSION");
		if (user.getId() == address.getUserId()) {
			addressService.updateAddress(address);
			return "OK";
		}
		return "fail";
	}

	@RequestMapping("createAddress.u")
	@ResponseBody
	public String createAddress(HttpSession session, Address address) {
		User user = (User) session.getAttribute("USER_SESSION");
		address.setUserId(user.getId());
		int rows = addressService.insertAddress(address);
		if (rows > 0)
			return "OK";
		return "fail";
	}

	@RequestMapping("deleteAddress.u")
	@ResponseBody
	public String deleteAddress(HttpSession session, Integer id) {
		User user = (User) session.getAttribute("USER_SESSION");
		Address address = addressService.queryById(id);
		if (address.getUserId() == user.getId()) {
			addressService.deleteAddress(id);
			return "OK";
		}
		return "fail";
	}

	@RequestMapping("listUserAddress.u")
	@ResponseBody
	public List<Address> listUserAddress(HttpSession session) {
		User user = (User) session.getAttribute("USER_SESSION");
		List<Address> addresses = addressService.queryAddressListByUserId(user
				.getId());
		return addresses;
	}
}
