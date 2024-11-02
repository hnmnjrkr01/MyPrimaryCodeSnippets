package com.cg.medicalapp.exception;


public class RecordExistsException  extends RuntimeException
{
	private static final long serialVersionUID = 1L;
	
	public RecordExistsException(String msg) {
		super(msg);
	}
}

