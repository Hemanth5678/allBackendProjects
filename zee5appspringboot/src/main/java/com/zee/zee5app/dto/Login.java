package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data

@Entity  //entity class is used for ORM
@Table(name = "log")	//set tablename
public class Login {
	@Id	//it will consider this coln as PK.
	@Column(name = "username") // 
	private String UserName;
	
	@NotBlank
	@Size(max=100)
	private String Password;
	
	@NotNull
	private String regid;
	
	@NotBlank
	private ROLE role;
}
