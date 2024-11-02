package com.sprint1.plantnursery.exceptions;

/*Controller Class for Seed Controller
Created By : Smita Pradhan 
*/

public class SeedIdNotFoundException extends RuntimeException {

	public SeedIdNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public SeedIdNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public SeedIdNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public SeedIdNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SeedIdNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}