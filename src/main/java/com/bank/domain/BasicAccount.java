package com.bank.domain;

import lombok.Data;

@Data
public class BasicAccount {
	
	private String accType;
	private int accNo;
	private double balance;
	private String operation;
	
	

}
