package com.zee.zee5app.dto;

import lombok.Data;

@Data
public class Login {
	private String UserName;
	private String Password;
	private String regid;
	private ROLE role;
}
