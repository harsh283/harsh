/**
	* Project Name : Health Care Management System
	*
	* 
**/


package com.capg.greatoutdoor.addressmanagement.controller;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capg.greatoutdoor.addressmanagement.exceptions.AddressDoesnotExist;
import com.capg.greatoutdoor.addressmanagement.exceptions.EmptyAddressListException;
import com.capg.greatoutdoor.addressmanagement.exceptions.ErrorInfo;


/**
	* The GlobalExceptionHandler class to control the exceptions raised
	*
	* @author   :Shambu Harsh Kumar
	* @since    :2020-09-20 
**/

@RestControllerAdvice
public class GlobalExceptionHandler {
	/**
	* This method will be invoked when empty address list exception is found while returning address List
	*/
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value= {EmptyAddressListException.class})
	public ErrorInfo handleEmptyAddressListException(EmptyAddressListException exception , HttpServletRequest request)
	{
		return new ErrorInfo(LocalDateTime.now(), exception.getMessage(),request.getRequestURI().toString());
	}
	/**
	* This method will be invoked when empty address is found
	*/
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	@ExceptionHandler(value= {AddressDoesnotExist.class})
	public ErrorInfo handleAddressDoesnotExistException(AddressDoesnotExist exception , HttpServletRequest request)
	{
		return new ErrorInfo(LocalDateTime.now(), exception.getMessage(),request.getRequestURI().toString());
	}
	

}
