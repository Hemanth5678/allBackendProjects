package com.zee.zee5app.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@Entity  //entity class is used for ORM
@Table(name = "log")	//set tablename
@NoArgsConstructor
@AllArgsConstructor
public class Login {
	@Id	//it will consider this coln as PK.
	//@Column(name = "username") // 
	private String userName;
	
	@NotBlank
	@Size(max=100)
	private String Password;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@JoinColumn(name = "regId")// , foreignKey=@ForeignKey(name="fk_regId"))
	//@JsonProperty(access = Access.WRITE_ONLY)
	@JsonIgnore
	private Register register;
}
