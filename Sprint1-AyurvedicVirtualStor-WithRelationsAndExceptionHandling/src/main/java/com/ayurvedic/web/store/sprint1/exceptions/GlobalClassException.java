package com.ayurvedic.web.store.sprint1.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalClassException extends ResponseEntityExceptionHandler {
	
	 HttpHeaders header = new HttpHeaders();
	 
	 
	@ExceptionHandler({
					//sMethodArgumentNotValidException.class,
					OrderNotPlacedException.class,
					CartNeverFilledException.class,
					CategoryDoesNotExistException.class,
					CustomerDoesNotExistException.class,
					MedicinerNotFoundexception.class,
					UserDoestNotExistException.class		
					})
	@Nullable	
	public ResponseEntity<Object> handleGlobalException(Exception exception, WebRequest request)throws Exception{
		
		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(),exception.getMessage(), null);
		
		if(exception instanceof OrderNotPlacedException) {
			return handleExceptionInternal(exception, errorResponse, header, HttpStatus.NOT_FOUND, request);
		}
		
		else if(exception instanceof CartNeverFilledException) {
			return handleExceptionInternal(exception, errorResponse, header, HttpStatus.NOT_FOUND, request);
		}
		
		else if(exception instanceof CategoryDoesNotExistException) {
			return handleExceptionInternal(exception, errorResponse, header, HttpStatus.NOT_FOUND, request);
		}
		
		else if(exception instanceof CustomerDoesNotExistException) {
			return handleExceptionInternal(exception, errorResponse, header, HttpStatus.NOT_FOUND, request);
		}
		
		else if(exception instanceof MedicinerNotFoundexception) {
			return handleExceptionInternal(exception, errorResponse, header, HttpStatus.NOT_FOUND, request);
		}
		
		else if(exception instanceof UserDoestNotExistException) {
			return handleExceptionInternal(exception, errorResponse, header, HttpStatus.NOT_FOUND, request);
		}
		
		else {
			throw exception;
		}
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldError = ex.getFieldErrors();
		List<String> errors = new ArrayList<>();
		
		for(FieldError error : fieldError) {
			errors.add(error.getDefaultMessage());
		}
		ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(),"BAD_REQUEST", null);

		return handleExceptionInternal(ex, errorResponse, headers, status, request);
	}
	
	
	
	

}
