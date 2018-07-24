package com.zdx.shop.exception;

@SuppressWarnings("serial")
public class LackMoneyException extends RuntimeException{

	public LackMoneyException() {
		super();
	}

	public LackMoneyException(String message, Throwable cause) {
		super(message, cause);
	}

	public LackMoneyException(String message) {
		super(message);
	}

}
