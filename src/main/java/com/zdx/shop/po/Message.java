package com.zdx.shop.po;

import java.util.Date;

public class Message {
	private Integer id;
	private Integer userId;
	private Integer shopId;
	private Integer type; // 0=用户》卖家，1=卖家》用户
	private String content;
	private Date sendTime;
	private Integer state;

	private User user;
	private Shop shop;
	private Integer start;
	private Integer size;

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
