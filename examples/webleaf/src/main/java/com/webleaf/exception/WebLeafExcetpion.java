package com.webleaf.exception;

public class WebLeafExcetpion extends RuntimeException {

	public WebLeafExcetpion(String message, Throwable cause) {
		super(message, cause);
	}

	public WebLeafExcetpion(String message) {
		super(message);
	}

	public WebLeafExcetpion(Throwable cause) {
		super(cause);
	}

}
