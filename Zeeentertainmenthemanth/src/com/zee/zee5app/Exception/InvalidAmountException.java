package com.zee.zee5app.Exception;

import lombok.ToString;

@ToString(callSuper = true)
public class InvalidAmountException extends Exception{

	public InvalidAmountException(String message) {
		// TODO Auto-generated constructor stub
		super(message);
	}
}
