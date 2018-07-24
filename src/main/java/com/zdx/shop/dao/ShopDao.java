package com.zdx.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zdx.shop.po.Shop;

public interface ShopDao {
	Shop login(@Param("login_name") String loginName,
			@Param("password") String password);

	int updateLoginTime(int id);

	Shop queryById(int id);

	List<Shop> queryShopList(Shop shop);

	int selectShopListCount(Shop shop);

	int insertShop(Shop shop);

	int updateShop(Shop shop);

	int increaseMoney(@Param("id") int id, @Param("num") Double num);

	int deleteShop(int id);

}
