package com.webaction.exception;

public class WebActionException extends RuntimeException {

	public WebActionException() {
		super();
	}

	public WebActionException(String message, Throwable cause) {
		super(message, cause);
	}

	public WebActionException(String message) {
		super(message);
	}

	public WebActionException(Throwable cause) {
		super(cause);
	}

}
