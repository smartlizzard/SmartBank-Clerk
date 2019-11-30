package com.bank.domain;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class PrimaryAccount implements Account {

	private Long id;
    private int accountNumber;
    private BigDecimal accountBalance;
    
  
    private List<PrimaryTransaction> primaryTransactionList;

    
    
	    
}
