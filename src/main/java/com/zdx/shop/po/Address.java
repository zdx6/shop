package com.zdx.shop.po;

import java.util.Date;

public class Address {
	private Integer id;
	private Integer userId;
	private String receiverName;
	private String phone;
	private String address;
	private Date addressCreateTime;
	private Date addressUpdateTime;
	private Integer state;
	private Integer start;
	private Integer size;

	private User user;

	
	public Integer getId() {
		return id;
	}

	public Integer getUserId() {
		return userId;
	}

	public Integer getState() {
		return state;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

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

	public void setState(Integer state) {
		this.state = state;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public Date getAddressCreateTime() {
		return addressCreateTime;
	}

	public void setAddressCreateTime(Date addressCreateTime) {
		this.addressCreateTime = addressCreateTime;
	}

	public Date getAddressUpdateTime() {
		return addressUpdateTime;
	}

	public void setAddressUpdateTime(Date addressUpdateTime) {
		this.addressUpdateTime = addressUpdateTime;
	}


	@Override
	public String toString() {
		return "Address [id=" + id + ", userId=" + userId + ", receiverName="
				+ receiverName + ", phone=" + phone + ", address=" + address
				+ ", addressCreateTime=" + addressCreateTime
				+ ", addressUpdateTime=" + addressUpdateTime + ", state="
				+ state + ", start=" + start + ", size=" + size + ", user="
				+ user + "]";
	}

}
