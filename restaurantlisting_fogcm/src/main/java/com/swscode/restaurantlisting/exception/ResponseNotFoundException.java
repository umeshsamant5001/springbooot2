package com.swscode.restaurantlisting.exception;

public class ResponseNotFoundException extends RuntimeException{
	
	public ResponseNotFoundException (String message) {
		super(message);
	}

}
