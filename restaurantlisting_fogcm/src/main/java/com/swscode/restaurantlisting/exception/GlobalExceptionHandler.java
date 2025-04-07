package com.swscode.restaurantlisting.exception;

import java.util.Arrays;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.swscode.restaurantlisting.response.ApiResponse;
import com.swscode.restaurantlisting.util.ResponseUtil;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ApiResponse<Object> handleGeneralException (Exception ex, HttpServletRequest request){
		
		return ResponseUtil.error(Arrays.asList(ex.getMessage()),"An unexpeeted error occurred" , 1001,request.getRequestURI());
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ApiResponse<Object> handleResourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request){
		return ResponseUtil.error(Arrays.asList(ex.getMessage()),"Resource Not Found", 404,request.getRequestURI());
	}
	
	@ExceptionHandler(ResponseNotFoundException.class)
	public ApiResponse<Object> handleResponseNotFoundException( ResponseNotFoundException ex , HttpServletRequest request){
		return ResponseUtil.error(Arrays.asList(ex.getMessage()), "Response Data Not Received", 204, request.getRequestURI());
	}

}
