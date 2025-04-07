package com.swscode.restaurantlisting.util;

import java.util.Arrays;
import java.util.List;

import com.swscode.restaurantlisting.response.ApiResponse;

public class ResponseUtil {
	
	public static <T> ApiResponse<T> success(T data, String message,String path){
		ApiResponse<T> apiResponse = new ApiResponse<T>();
		apiResponse.setSuccess(true);
		apiResponse.setMessage(message);
		apiResponse.setData(data);
		apiResponse.setErrorCode(0);  // No error 
		apiResponse.setTimeStamp(System.currentTimeMillis());
		apiResponse.setPath(path);
		
		
		return apiResponse;
	}
	
    public static <T> ApiResponse<T> error(List<String> errorList,String message, int errorCode, String path){
	   ApiResponse<T> apiResponse = new ApiResponse<T>();
	   apiResponse.setSuccess(false);;
	   apiResponse.setMessage(message);
	   apiResponse.setData(null);
	   apiResponse.setErrors(errorList);
	   apiResponse.setErrorCode(errorCode);
	   apiResponse.setTimeStamp(System.currentTimeMillis());
	   apiResponse.setPath(path);
	   
	   return apiResponse;
   }
   
    public static <T> ApiResponse<T> error(String error, String message, int errorCode, String path){
    	
    	return error(Arrays.asList(error), message, errorCode, path);
    }

}
