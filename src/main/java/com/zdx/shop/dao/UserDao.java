package com.zdx.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zdx.shop.po.User;

public interface UserDao {
	User login(@Param("login_name") String loginName,
			@Param("password") String password);

	int updateLoginTime(int id);

	User queryById(int id);

	List<User> queryUserList(User user);

	int selectUserListCount(User user);

	int insertUser(User user);

	int updateUser(User user);

	int deleteUser(int userId);

	int reduceMoney(@Param("id") int id, @Param("num") Double num);

	int increaseMoney(@Param("id") int id, @Param("num") Double num);
}
