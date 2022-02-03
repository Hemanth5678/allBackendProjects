package com.zee.zee5app.dto;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.zee.zee5app.Exception.InvalidAmountException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Data
@Setter
@Getter
@ToString
@Entity  //entity class is used for ORM
@Table(name = "sub")
@AllArgsConstructor
public class Subscriptions implements Comparable<Subscriptions>{
	
	@Id	//it will consider this coln as PK.
	@Column(name = "subId") 
	@Setter(value = AccessLevel.NONE)
	private String id;
	
	@NotNull
	private Date dop;
	
	@NotNull
	private Date expiry;
	
	@NotNull
	private float amount;
	
	@NotBlank
	private String paymentmode;
	
	@NotBlank  //string : notblank
	private String status;
	
	@NotBlank
	private String subscriptiontype;
	
	@NotBlank
	private String autorenewal;
	//@Setter(value = AccessLevel.NONE)
	
	@NotBlank
	private String regid;
//	public Subscriptions(String id, Date dop, String status, String paymentmode, String autorenewal, Date expiry, float amount, String subscriptiontype, String regid) throws InvalidIdLengthException, InvalidAmountException {
//		super();
//		this.setId(id);
//		this.dop = dop;
//		this.status = status;
//		this.paymentmode = paymentmode;
//		this.autorenewal = autorenewal;
//		this.expiry = expiry;
//		this.setamount(amount);
//		this.subscriptiontype=subscriptiontype;
//		this.regid = regid;
//	}
//	public Subscriptions() {
//		// TODO Auto-generated constructor stub
//	}
//	/*private void setstatus(String status2) throws InvalidNameException {
//		// TODO Auto-generated method stub
//		if(status==null || status=="" || status.length()<2) {
//			throw new InvalidNameException("dop not valid");
//		}
//		this.status = status;
//		
//	}*/
//	
//	/*private void setdop(String dop2) throws InvalidNameException {
//		// TODO Auto-generated method stub
//		if(dop==null || dop=="" || dop.length()<2) {
//			throw new InvalidNameException("dop not valid");
//		}
//		this.dop = dop;
//		
//	}*/
//	
//	public void setId(String Id) throws InvalidIdLengthException {
//		// TODO Auto-generated method stub
//		if(Id.length()<6) {
//			
//			throw new InvalidIdLengthException("id length is less than or equal to 6");
//		}
//		this.id=Id;
//	}
//	
//	public void setamount(float amount) throws InvalidAmountException {
//		// TODO Auto-generated method stub
//		if(amount<599) {
//			
//			throw new InvalidAmountException("amount is less than Rs.599 . Kindly pay 599 ");
//		}
//		if(amount>599) {
//			
//			throw new InvalidAmountException("amount is greater than Rs.599 . Kindly contact customer care for refund ");
//		}
//		this.amount=amount;
//	}
//	
	@Override
	public int compareTo(Subscriptions o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}
	
	
}
