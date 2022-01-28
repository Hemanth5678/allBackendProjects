package com.zee.zee5app.Exception;

import lombok.ToString;

@ToString(callSuper = true)
public class LocationNotFoundException extends Exception{
	public LocationNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}
