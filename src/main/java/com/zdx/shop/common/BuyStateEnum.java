package com.zdx.shop.common;

public enum BuyStateEnum {
	SUCCESS(1, "购买成功"),
	FAIL(0,"购买失败"),
	LACK_PRODUCT(-1,"商品不足"),
	LACK_MONEY(-2,"余额不足");	
	
	private int state;
	private String stateInfo;

	private BuyStateEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}

	public int getState() {
		return state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public BuyStateEnum stateOf(int index) {
		for(BuyStateEnum state:values()){
			if(state.getState()==index)
				return state;
		}
		return null;
	}
}
