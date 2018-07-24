package com.zdx.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdx.shop.common.utils.Page;
import com.zdx.shop.dao.OrdersDao;
import com.zdx.shop.po.Orders;
import com.zdx.shop.service.OrdersService;

@Service
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	private OrdersDao orderDao;

	@Override
	public Orders queryById(int orderId) {
		return orderDao.queryById(orderId);
	}

	@Override
	public int updateSendTime(int orderId) {
		return orderDao.updateSendTime(orderId);
	}

	@Override
	public int updateEndTime(int orderId) {
		return orderDao.updateEndTime(orderId);
	}

	@Override
	public int deleteOrder(int orderId) {
		return orderDao.deleteOrder(orderId);
	}

	@Override
	public Page<Orders> queryOrderListByShopId(int shopId, int pageNo, int size) {
		Page<Orders> page = new Page<>();
		page.setPageNo(pageNo);
		page.setSize(size);
		List<Orders> orders = orderDao.queryOrderListByShopId(shopId,
				(pageNo - 1) * size, size);
		page.setRows(orders);
		page.setTotal(orderDao.selectOrderListByShopIdCount(shopId));
		return page;
	}

	@Override
	public Page<Orders> queryOrderListByUserId(int userId, int pageNo, int size) {
		Page<Orders> page = new Page<>();
		page.setPageNo(pageNo);
		page.setSize(size);
		List<Orders> orders = orderDao.queryOrderListByUserId(userId,
				(pageNo - 1) * size, size);
		page.setRows(orders);
		page.setTotal(orderDao.selectOrderListByUserIdCount(userId));
		return page;
	}

}
