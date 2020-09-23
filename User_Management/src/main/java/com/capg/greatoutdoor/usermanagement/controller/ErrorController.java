package com.capg.greatoutdoor.usermanagement.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpStatusCodeException;

import com.capg.greatoutdoor.usermanagement.exceptions.ContactNumberAlreadyExistException;
import com.capg.greatoutdoor.usermanagement.exceptions.EmailAlreadyExistException;
import com.capg.greatoutdoor.usermanagement.exceptions.ErrorInfo;
import com.capg.greatoutdoor.usermanagement.exceptions.UserEmailInvalidException;
import com.capg.greatoutdoor.usermanagement.exceptions.UserNameAlreadyExistException;
import com.capg.greatoutdoor.usermanagement.exceptions.UserNameInvalidException;
import com.capg.greatoutdoor.usermanagement.exceptions.UserNotFoundException;
import com.capg.greatoutdoor.usermanagement.exceptions.UserNumberInvalidException;
import com.capg.greatoutdoor.usermanagement.exceptions.UserPasswordInvalidException;

@RestControllerAdvice
public class ErrorController {
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value= {UserNotFoundException.class})
	public ErrorInfo handleUserNotFound(UserNotFoundException ex , HttpServletRequest req)
	{
		return new ErrorInfo(LocalDateTime.now(), ex.getMessage(),req.getRequestURI().toString());
	}
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value= {UserNameInvalidException.class})
	public ErrorInfo handleUserNameInvalid(UserNameInvalidException ex , HttpServletRequest req)
	{
		return new ErrorInfo(LocalDateTime.now(), ex.getMessage(),req.getRequestURI().toString());
	}

	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value= {UserEmailInvalidException.class})
	public ErrorInfo handleEmailInvalid(UserEmailInvalidException ex , HttpServletRequest req)
	{
		return new ErrorInfo(LocalDateTime.now(), ex.getMessage(),req.getRequestURI().toString());
	}
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value= {UserPasswordInvalidException.class})
	public ErrorInfo handlePasswordInvalid(UserPasswordInvalidException ex , HttpServletRequest req)
	{
		return new ErrorInfo(LocalDateTime.now(), ex.getMessage(),req.getRequestURI().toString());
	}
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value= {ContactNumberAlreadyExistException.class})
	public ErrorInfo handleContactNumberExist(ContactNumberAlreadyExistException ex , HttpServletRequest req)
	{
		return new ErrorInfo(LocalDateTime.now(), ex.getMessage(),req.getRequestURI().toString());
	}
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value= {EmailAlreadyExistException.class})
	public ErrorInfo handleEmailExistException(EmailAlreadyExistException ex , HttpServletRequest req)
	{
		return new ErrorInfo(LocalDateTime.now(), ex.getMessage(),req.getRequestURI().toString());
	}
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value= {UserNameAlreadyExistException.class})
	public ErrorInfo handlePasswordInvalid(UserNameAlreadyExistException ex , HttpServletRequest req)
	{
		return new ErrorInfo(LocalDateTime.now(), ex.getMessage(),req.getRequestURI().toString());
	}
	
	@ResponseStatus(code=HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value= {UserNumberInvalidException.class})
	public ErrorInfo handleUserNumberInvalid(UserNumberInvalidException ex , HttpServletRequest req)
	{
		return new ErrorInfo(LocalDateTime.now(), ex.getMessage(),req.getRequestURI().toString());
	}
	
	@ExceptionHandler(value = {HttpStatusCodeException.class})
	public ResponseEntity<ErrorInfo> handleNotFound(HttpStatusCodeException excepion, HttpServletRequest request)
	{
		ErrorInfo response=new ErrorInfo(LocalDateTime.now(), excepion.getMessage(), request.getRequestURI());
		
		return new ResponseEntity<ErrorInfo>(response,excepion.getStatusCode());
	}
	}
