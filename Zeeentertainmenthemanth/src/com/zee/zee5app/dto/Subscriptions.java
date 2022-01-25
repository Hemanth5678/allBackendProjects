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
	private String dateofpurchase;
	private String status;
	private String packcountry;
	private String paymentmode;
	private String autorenewal;
	private String expirydate;
	//@Setter(value = AccessLevel.NONE)
	private String amountpaid;
	public Subscriptions(String id, String dateofpurchase, String status, String packcountry, String paymentmode, String autorenewal, String expirydate, String amountpaid) throws InvalidIdLengthException, InvalidAmountException {
		super();
		this.setId(id);
		this.dateofpurchase = dateofpurchase;
		this.status = status;
		this.packcountry = packcountry;
		this.paymentmode = paymentmode;
		this.autorenewal = autorenewal;
		this.expirydate = expirydate;
		this.setAmountpaid(amountpaid);
	}
	public Subscriptions() {
		// TODO Auto-generated constructor stub
	}
	/*private void setstatus(String status2) throws InvalidNameException {
		// TODO Auto-generated method stub
		if(status==null || status=="" || status.length()<2) {
			throw new InvalidNameException("dateofpurchase not valid");
		}
		this.status = status;
		
	}*/
	
	/*private void setdateofpurchase(String dateofpurchase2) throws InvalidNameException {
		// TODO Auto-generated method stub
		if(dateofpurchase==null || dateofpurchase=="" || dateofpurchase.length()<2) {
			throw new InvalidNameException("dateofpurchase not valid");
		}
		this.dateofpurchase = dateofpurchase;
		
	}*/
	
	public void setId(String Id) throws InvalidIdLengthException {
		// TODO Auto-generated method stub
		if(Id.length()<6) {
			
			throw new InvalidIdLengthException("id length is less than or equal to 6");
		}
		this.id=Id;
	}
	
	public void setAmountpaid(String amountpaid) throws InvalidAmountException {
		// TODO Auto-generated method stub
		if(Integer.valueOf(amountpaid)<599) {
			
			throw new InvalidAmountException("amount is less than Rs.599 . Kindly pay 599 ");
		}
		if(Integer.valueOf(amountpaid)>599) {
			
			throw new InvalidAmountException("amount is greater than Rs.599 . Kindly contact customer care for refund ");
		}
		this.amountpaid=amountpaid;
	}
	
	@Override
	public int compareTo(Subscriptions o) {
		// TODO Auto-generated method stub
		return this.id.compareTo(o.getId());
	}
	
	
}
