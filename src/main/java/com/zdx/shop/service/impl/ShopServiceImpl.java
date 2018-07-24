package com.zdx.shop.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zdx.shop.common.utils.Page;
import com.zdx.shop.dao.ShopDao;
import com.zdx.shop.po.Shop;
import com.zdx.shop.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopDao shopDao;

	@Transactional
	@Override
	public Shop login(String usercode, String password) {
		Shop shop = this.shopDao.login(usercode, password);
		if (shop != null)
			shopDao.updateLoginTime(shop.getId());
		return shop;
	}

	@Override
	public Shop queryById(int id) {
		return shopDao.queryById(id);
	}

	@Override
	public Page<Shop> queryShopList(String loginName, String shopName,
			int pageNo, int size) {
		Page<Shop> page = new Page<>();
		page.setPageNo(pageNo);
		page.setSize(size);
		Shop shop = new Shop();
		if (StringUtils.isNotBlank(loginName))
			shop.setLoginName(loginName);
		if (StringUtils.isNotBlank(shopName))
			shop.setShopName(shopName);
		shop.setStart((pageNo - 1) * size);
		shop.setSize(size);
		List<Shop> users = shopDao.queryShopList(shop);
		page.setRows(users);
		page.setTotal(shopDao.selectShopListCount(shop));
		return page;
	}

	@Override
	public int signUp(Shop shop) {
		return shopDao.insertShop(shop);
	}

	@Override
	public int updateShop(Shop shop) {
		return shopDao.updateShop(shop);
	}

	@Override
	public int deleteShop(int id) {
		return shopDao.deleteShop(id);
	}
}
