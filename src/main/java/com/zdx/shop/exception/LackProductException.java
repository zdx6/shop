package com.zdx.shop.exception;

@SuppressWarnings("serial")
public class LackProductException extends RuntimeException{

	public LackProductException() {
		super();
	}

	public LackProductException(String message, Throwable cause) {
		super(message, cause);
	}

	public LackProductException(String message) {
		super(message);
	}

}
