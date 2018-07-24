package com.zdx.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zdx.shop.po.Message;

public interface MessageDao {
	Message queryById(int id);

	List<Message> queryUserMessageList(@Param("userId") int userId,
			@Param("pageNo") int pageNo, @Param("size") int size);

	int selectUserMessageListCount(int userId);

	List<Message> queryShopMessageList(@Param("shopId")int shopId, @Param("pageNo") int pageNo,
			@Param("size") int size);

	int selectShopMessageListCount(int shopId);

	int insertMessage(Message message);
}
