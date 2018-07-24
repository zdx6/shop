package com.zdx.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdx.shop.common.utils.Page;
import com.zdx.shop.dao.MessageDao;
import com.zdx.shop.po.Message;
import com.zdx.shop.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageDao messageDao;

	@Override
	public Message queryById(int id) {
		return messageDao.queryById(id);
	}

	@Override
	public Page<Message> queryUserMessageList(Integer userId, Integer pageNo,
			Integer size) {
		Page<Message> page = new Page<>();
		page.setPageNo(pageNo);
		page.setSize(size);
		List<Message> messages = messageDao.queryUserMessageList(userId,
				pageNo, size);
		page.setRows(messages);
		page.setTotal(messageDao.selectUserMessageListCount(userId));
		return page;
	}

	@Override
	public Page<Message> queryShopMessageList(Integer shopId, Integer pageNo,
			Integer size) {
		Page<Message> page = new Page<>();
		page.setPageNo(pageNo);
		page.setSize(size);
		List<Message> messages = messageDao.queryShopMessageList(shopId,
				pageNo, size);
		page.setRows(messages);
		page.setTotal(messageDao.selectShopMessageListCount(shopId));
		return page;
	}

}
