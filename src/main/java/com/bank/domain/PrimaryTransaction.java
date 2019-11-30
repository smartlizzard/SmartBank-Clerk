package com.bank.domain;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class PrimaryTransaction {

	 
	private Long id;
	private Date date;
	private String description;

	private String type;
	private String status;
	private double amount;
	private BigDecimal availableBalance;

	
	private PrimaryAccount primaryAccount;

	
}
