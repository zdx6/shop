package com.zdx.shop.exception;

@SuppressWarnings("serial")
public class BuyException extends RuntimeException{

	public BuyException() {
		super();
	}

	public BuyException(String message, Throwable cause) {
		super(message, cause);
	}

	public BuyException(String message) {
		super(message);
	}
	
}
