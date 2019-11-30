package com.bank.domain;

import lombok.Data;

@Data
public class User {

	   
	    private Long userId;
	    private String username;
	    private String password;
	    private String firstName;
	    private String lastName;

	    
	    private String email;
	    private String phone;

	    private boolean enabled=true;

	    
	    private PrimaryAccount primaryAccount;

	    private SavingsAccount savingsAccount;

	   
	  //  private List<Appointment> appointmentList;

	   
	  //  private List<Recipient> recipientList;
	    
	 
		//private Set<UserRole> userRoles = new HashSet<>();
	    
	    

		

		
}
