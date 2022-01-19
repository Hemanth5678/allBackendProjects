package com.zee.zee5app.dto;
import lombok.Data;

@Data
public class Subscriptions {
	private String id;
	private String type;
	private String purchasedate;
	private String status;
	private String packcountry;
	private String paymentmode;
	private String autorenewal;
	private String expirydate;
}
