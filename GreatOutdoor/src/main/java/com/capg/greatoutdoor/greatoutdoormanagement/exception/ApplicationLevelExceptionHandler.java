package com.capg.greatoutdoor.greatoutdoormanagement.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;



@RestControllerAdvice
public class ApplicationLevelExceptionHandler {
	
	  @ExceptionHandler(value = {HttpStatusCodeException.class}) public
	  ResponseEntity<ErrorInfo> handleNotFound(HttpStatusCodeException excepion,
	  HttpServletRequest request) { ErrorInfo response=new
	  ErrorInfo(LocalDateTime.now(), excepion.getMessage(),
	  request.getRequestURI());
	  
	  return new ResponseEntity<ErrorInfo>(response,excepion.getStatusCode()); }
	
}
