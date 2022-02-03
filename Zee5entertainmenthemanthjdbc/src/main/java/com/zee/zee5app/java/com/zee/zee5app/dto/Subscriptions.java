package com.zee.zee5app.dto;
import com.zee.zee5app.Exception.InvalidAmountException;
import com.zee.zee5app.Exception.InvalidIdLengthException;
import com.zee.zee5app.Exception.InvalidNameException;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Data
@Setter
@Getter
@ToString
public class Subscriptions implements Comparable<Subscriptions>{
	//@Setter(value = AccessLevel.NONE)
	private String id;
	private String dop;
	private String expiry;
	private String amount;
	private String paymentmode;
	private String status;
	private String subscriptiontype;
	
	private String autorenewal;
	//@Setter(value = AccessLevel.NONE)
	
	private String regid;
	public Subscriptions(String id, String dop, String status, String paymentmode, String autorenewal, String expiry, String amount, String subscriptiontype, String regid) throws InvalidIdLengthException, InvalidAmountException {
		super();
		this.setId(id);
		this.dop = dop;
		this.status = status;
		this.paymentmode = paymentmode;
		this.autorenewal = autorenewal;
		this.expiry = expiry;
		this.setamount(amount);
		this.subscriptiontype=subscriptiontype;
		this.regid = regid;
	}
	public Subscriptions() {
		// TODO Auto-generated constructor stub
	}
	/*private void setstatus(String status2) throws InvalidNameException {
		// TODO Auto-generated method stub
		if(status==null || status=="" || status.length()<2) {
			throw new InvalidNameException("dop not valid");
		}
		this.status = status;
		
	}*/
	
	/*private void setdop(String dop2) throws InvalidNameException {
		// TODO Auto-generated method stub
		if(dop==null || dop=="" || dop.length()<2) {
			throw new InvalidNameException("dop not valid");
		}
		this.dop = dop;
		
	}*/
	
	public void setId(String Id) throws InvalidIdLengthException {
		// TODO Auto-generated method stub
		if(Id.length()<6) {
			
			throw new InvalidIdLengthException("id length is less than or equal to 6");
		}
		this.id=Id;
	}
	
	public void setamount(String amount) throws InvalidAmountException {
		// TODO Auto-generated method stub
		if(Integer.valueOf(amount)<599) {
			
			throw new InvalidAmountException("amount is less than Rs.599 . Kindly pay 599 ");
		}
		if(Integer.valueOf(amount)>599) {
			
			throw new InvalidAmountException("amount is greater than Rs.599 . Kindly contact customer care for refund ");
		}
		this.amount=amount;
	}
	
	@Override
	public int compareTo(Subscriptions o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}
	
	
}
