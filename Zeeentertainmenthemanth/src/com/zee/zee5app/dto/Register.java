package com.zee.zee5app.dto;
import lombok.Data;

@Data
public class Register {
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String AadharCardId;
	//setter : set value for a  particular field
	// getter: get/return value of a particular field
}
