package com.ayurvedic.web.store.sprint1.exceptions;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
//@AllArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse  {

	private LocalDateTime timeStamp;
	private String errorMessage;
	private List<String> fieldErrors = new ArrayList<String>();
	
	public ErrorResponse(LocalDateTime timeStamp, String errorMessage, List<String> fieldErrors) {
		super();
		this.timeStamp = timeStamp;
		this.errorMessage = errorMessage;
		this.fieldErrors = fieldErrors;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public List<String> getFieldErrors() {
		return fieldErrors;
	}
	
	
}
