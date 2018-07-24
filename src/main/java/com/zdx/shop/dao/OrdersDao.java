package com.zdx.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zdx.shop.po.Orders;

public interface OrdersDao {
	Orders queryById(int orderId);

	List<Orders> queryOrderListByShopId(@Param("shopId") int shopId,
			@Param("start") int start, @Param("size") int size);

	int selectOrderListByShopIdCount(int shopId);

	List<Orders> queryOrderListByUserId(@Param("userId") int userId,
			@Param("start") int start, @Param("size") int size);

	int selectOrderListByUserIdCount(int userId);

	int insertOrder(Orders order);

	int updateSendTime(int orderId);

	int updateEndTime(int orderId);

	int deleteOrder(int orderId);
}
