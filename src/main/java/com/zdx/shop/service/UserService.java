package com.zdx.shop.service;

import com.zdx.shop.common.utils.Page;
import com.zdx.shop.po.User;

public interface UserService {
	User login(String loginName, String password);

	User queryById(int id);

	Page<User> queryUserList(String loginName, String nickName, String phone,
			int pageNo, int size);

	int signUp(User user);

	int updateUser(User user);

	int buyProduct(int userId, int productId, int addressId) throws RuntimeException;

	int increaseMoney(int id, Double num);

	int deleteUser(int userId);
}
