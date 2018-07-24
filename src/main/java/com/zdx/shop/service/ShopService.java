package com.zdx.shop.service;


import com.zdx.shop.common.utils.Page;
import com.zdx.shop.po.Shop;

public interface ShopService {
	Shop login(String loginName, String password);

	Shop queryById(int id);

	Page<Shop> queryShopList(String loginName, String shopName, int pageNo,
			int size);

	int signUp(Shop shop);

	int updateShop(Shop shop);

	int deleteShop(int id);
}
