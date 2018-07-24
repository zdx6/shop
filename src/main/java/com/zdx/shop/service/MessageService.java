package com.zdx.shop.service;

import com.zdx.shop.common.utils.Page;
import com.zdx.shop.po.Message;

public interface MessageService {
	Message queryById(int id);

	Page<Message> queryUserMessageList(Integer  userId, Integer pageNo, Integer size);

	Page<Message> queryShopMessageList(Integer  shopId, Integer pageNo, Integer size);
}
