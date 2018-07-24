package com.zdx.shop.po;

import java.util.Date;

public class Product {
	private Integer id;
	private Integer shopId;
	private String productName;
	private String detail;
	private Integer type;
	private String img1;
	private String img2;
	private String img3;
	private Double price;
	private Integer stock;
	private Integer state;
	private Date productCreateTime;
	private Date productUpdateTime;

	private Shop shop;
	private Integer start;
	private Integer size;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getImg1() {
		return img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	public String getImg2() {
		return img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	public String getImg3() {
		return img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getProductCreateTime() {
		return productCreateTime;
	}

	public void setProductCreateTime(Date productCreateTime) {
		this.productCreateTime = productCreateTime;
	}

	public Date getProductUpdateTime() {
		return productUpdateTime;
	}

	public void setProductUpdateTime(Date productUpdateTime) {
		this.productUpdateTime = productUpdateTime;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", shopId=" + shopId + ", productName="
				+ productName + ", detail=" + detail + ", type=" + type
				+ ", img1=" + img1 + ", img2=" + img2 + ", img3=" + img3
				+ ", price=" + price + ", stock=" + stock + ", state=" + state
				+ ", productCreateTime=" + productCreateTime
				+ ", productUpdateTime=" + productUpdateTime + ", shop=" + shop
				+ ", start=" + start + ", size=" + size + "]";
	}

}
