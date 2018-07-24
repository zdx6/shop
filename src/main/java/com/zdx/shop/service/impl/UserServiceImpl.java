package com.zdx.shop.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdx.shop.common.utils.Page;
import com.zdx.shop.dao.OrdersDao;
import com.zdx.shop.dao.ProductDao;
import com.zdx.shop.dao.ShopDao;
import com.zdx.shop.dao.UserDao;
import com.zdx.shop.exception.BuyException;
import com.zdx.shop.exception.LackMoneyException;
import com.zdx.shop.exception.LackProductException;
import com.zdx.shop.po.Orders;
import com.zdx.shop.po.Product;
import com.zdx.shop.po.User;
import com.zdx.shop.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ShopDao shopDao;
	@Autowired
	private OrdersDao ordersDao;

	@Override
	public User login(String usercode, String password) {
		User user = this.userDao.login(usercode, password);
		if (user != null)
			userDao.updateLoginTime(user.getId());
		return user;
	}

	@Override
	public User queryById(int id) {
		return userDao.queryById(id);
	}

	@Override
	public Page<User> queryUserList(String loginName, String nickName,
			String phone, int pageNo, int size) {
		Page<User> page = new Page<>();
		page.setPageNo(pageNo);
		page.setSize(size);
		User user = new User();
		if (StringUtils.isNotBlank(loginName))
			user.setLoginName(loginName);
		if (StringUtils.isNotBlank(nickName))
			user.setLoginName(nickName);
		if (StringUtils.isNotBlank(phone))
			user.setLoginName(phone);
		user.setStart((pageNo - 1) * size);
		user.setSize(size);
		List<User> users = userDao.queryUserList(user);
		page.setRows(users);
		page.setTotal(userDao.selectUserListCount(user));
		return page;
	}

	@Override
	public int signUp(User user) {
		return userDao.insertUser(user);
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Transactional
	@Override
	public int buyProduct(int userId, int productId, int addressId) throws RuntimeException{
		int rows;
		rows = productDao.reduceStock(productId, 1);
		if (rows == 0)
			throw new LackProductException();
		Orders order = new Orders();
		order.setUserId(userId);
		order.setProductId(productId);
		Product product = productDao.queryById(productId);
		Double price = product.getPrice();
		order.setPayment(price);
		rows = userDao.reduceMoney(userId, price);
		if (rows == 0)
			throw new LackMoneyException();
		order.setShopId(product.getShopId());
		order.setAddressId(addressId);
		rows = ordersDao.insertOrder(order);
		if (rows == 0)
			throw new BuyException();
		return rows;
	}

	@Override
	public int increaseMoney(int id, Double num) {
		return userDao.increaseMoney(id, num);
	}

	@Override
	public int deleteUser(int userId) {
		return userDao.deleteUser(userId);
	}

}
