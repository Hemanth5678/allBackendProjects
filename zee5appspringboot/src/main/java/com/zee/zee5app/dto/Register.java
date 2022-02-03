package com.zee.zee5app.dto;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
//ORM mapping purpose
@Entity  //entity class is used for ORM
@Table(name = "reg")	//set tablename


//@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
//@Data
public class Register implements Comparable<Register>{
//	@Override
//	public int hashCode() {
//		return Objects.hash(email, firstName, id, lastName, password);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Register other = (Register) obj;
//		return  Objects.equals(email, other.email)
//				&& Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
//				&& Objects.equals(lastName, other.lastName) && Objects.equals(password, other.password);
//	}

	@Id	//it will consider this coln as PK.
	@Column(name = "regId") // specify col name
	//@Setter(value = AccessLevel.NONE)
	private String id;
	
	@Size(max=50)
	@NotBlank
	//@Setter(value = AccessLevel.NONE)
	private String firstName;
	
	@Size(max=50)
	@NotBlank
	//@Setter(value = AccessLevel.NONE)
	private String lastName;
	
	@Size(max=50)
	@Email
	//@Setter(value = AccessLevel.NONE)
	private String email;
	
	@Size(max=100)
	@NotBlank
	//@Setter(value = AccessLevel.NONE)
	private String password;
	
	@NotBlank
	//@Setter(value = AccessLevel.NONE)
	private BigDecimal contactNumber; //TODO newone
	
	
	
	//private String AadharCardId;
	//setter : set value for a  particular field
	// getter: get/return value of a particular field
//	public Register() {
//		//System.out.println("hello bro how are you doing? Just a good register constructor here");
//	}
	
//	public Register(String id,String firstName, String lastName, String email, String password) throws InvalidIdLengthException, InvalidNameException {
//		
//		super();
//		this.setId(id);
//		this.setFirstName(firstName);
//		this.setLastName(lastName);
//		this.email=email;
//		this.password=password;
//	}
	
//	public void setFirstName(String firstName) throws InvalidNameException {
//		
//		if(firstName==null || firstName=="" || firstName.length()<2) {
//			throw new InvalidNameException("firstname not valid");
//		}
//		this.firstName = firstName;
//	}
//	
//	public void setLastName(String lastName) throws InvalidNameException {
//		if(lastName==null || lastName=="" || lastName.length()<2) {
//			throw new InvalidNameException("firstname not valid");
//		}
//		this.lastName = lastName;
//	}
//	
//	public void setId(String Id) throws InvalidIdLengthException {
//		if(Id.length()<6) {
//			
//			throw new InvalidIdLengthException("id length is less than or equal to 6");
//		}
//		this.id=Id;
//	}
	
	@Override
	public int compareTo(Register o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId()); // ascending order
		//return o.id.compareTo(this.getId()); //descending order
	}
}
