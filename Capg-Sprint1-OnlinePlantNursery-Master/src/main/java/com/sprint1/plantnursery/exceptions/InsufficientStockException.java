package com.sprint1.plantnursery.exceptions;

public class InsufficientStockException extends RuntimeException{
	
	public InsufficientStockException() {
		// TODO Auto-generated constructor stub
	}

	public InsufficientStockException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InsufficientStockException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InsufficientStockException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InsufficientStockException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
