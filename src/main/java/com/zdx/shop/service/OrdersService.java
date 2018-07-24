package com.zdx.shop.service;

import com.zdx.shop.common.utils.Page;
import com.zdx.shop.po.Orders;

public interface OrdersService {
	Orders queryById(int orderId);

	Page<Orders> queryOrderListByShopId(int shopId, int pageNo, int size);

	Page<Orders> queryOrderListByUserId(int userId,int pageNo, int size);

	int updateSendTime(int orderId);

	int updateEndTime(int orderId);

	int deleteOrder(int orderId);
}
