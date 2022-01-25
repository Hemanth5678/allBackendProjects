package com.zee.zee5app.Exception;

import lombok.ToString;

@ToString(callSuper = true)
public class NameNotFoundException extends Exception{
	public NameNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}
