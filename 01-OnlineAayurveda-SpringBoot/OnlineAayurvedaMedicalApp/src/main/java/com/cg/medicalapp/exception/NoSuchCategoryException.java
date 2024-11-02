package com.cg.medicalapp.exception;

public class NoSuchCategoryException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public NoSuchCategoryException(String msg) {
		super(msg);
	}

}
