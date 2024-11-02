package com.cg.medicalapp.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
	@ExceptionHandler(Exception.class)
  public ResponseEntity<ExceptionInformation> exceptionHandler(Exception exception){
      ExceptionInformation info=new ExceptionInformation();
      info.setExceptionMessage(exception.getMessage());
      info.setTimestamp(LocalDateTime.now());
      info.setExceptionCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
      return new ResponseEntity<ExceptionInformation>(info,HttpStatus.INTERNAL_SERVER_ERROR);
  }
  
  @ExceptionHandler(RecordExistsException.class)
  public ResponseEntity<ExceptionInformation> aayurvedaExceptionHandler(RecordExistsException exception){
      ExceptionInformation info=new ExceptionInformation();
      info.setExceptionMessage(exception.getMessage());
      info.setTimestamp(LocalDateTime.now());
      info.setExceptionCode(HttpStatus.BAD_REQUEST.value());
      return new ResponseEntity<ExceptionInformation>(info,HttpStatus.BAD_REQUEST);
  }
  
  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ExceptionInformation> aayurvedaExceptionHandler(UserNotFoundException exception){
      ExceptionInformation info=new ExceptionInformation();
      info.setExceptionMessage(exception.getMessage());
      info.setTimestamp(LocalDateTime.now());
      info.setExceptionCode(HttpStatus.NOT_FOUND.value());
      return new ResponseEntity<ExceptionInformation>(info,HttpStatus.NOT_FOUND);
  }
  
  @ExceptionHandler(RecordNotFoundException.class)
  public ResponseEntity<ExceptionInformation> aayurvedaExceptionHandler(RecordNotFoundException exception){
      ExceptionInformation info=new ExceptionInformation();
      info.setExceptionMessage(exception.getMessage());
      info.setTimestamp(LocalDateTime.now());
      info.setExceptionCode(HttpStatus.NOT_FOUND.value());
      return new ResponseEntity<ExceptionInformation>(info,HttpStatus.NOT_FOUND);
      
  }
  
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ExceptionInformation> exceptionHandler(MethodArgumentNotValidException exception){
      ExceptionInformation info=new ExceptionInformation();
      info.setExceptionMessage("validation failed");
      info.setTimestamp(LocalDateTime.now());
      info.setExceptionCode(HttpStatus.NOT_FOUND.value());
      return new ResponseEntity<ExceptionInformation>(info,HttpStatus.NOT_FOUND);
  }

}
