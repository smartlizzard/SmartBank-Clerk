package com.bank.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bank.domain.BasicAccount;
import com.bank.domain.PrimaryAccount;
import com.bank.domain.SavingsAccount;
import com.bank.domain.User;

@Service
public class TransactionService {
	
	//RestTemplate rt=new RestTemplate();
	
	@Autowired
    RestTemplate restTemplet;
	
	
	
	public static final String request="http://SMARTBANK-SERVICE/account/getAccDtls";
	public static final String txReq="http://SMARTBANK-SERVICE/account/txByClerk";

	//public static final String request="http://localhost:8090/account/getAccDtls";
	//public static final String txReq="http://localhost:8090/account/txByClerk";
	//txReq="http://localhost:8090/account/txByClerk";
	//http://localhost:8090/account/getAccDtls/11223147/savings
	
	public List<Object> getAccDetails(int accNo,String accType) {
		System.out.println("inside getAccDetails ");
		
		if (accNo != 0) {
			//String finalReq=request+"/api/transaction"+accNo+"/"+accType;
			String finalReq=request+"/"+accNo+"/"+accType;
			System.out.println(finalReq);
			List<Object> list=new ArrayList<>();
			
			User user=restTemplet.getForObject(finalReq, User.class);
			if (user == null) {
				//list.add(user);
				return list;
				
			}
			
			StringBuffer name=new StringBuffer(user.getFirstName());
			name=name.append(" ").append(user.getLastName());
			
			
			list.add(name);
			
			if ("savings".equalsIgnoreCase(accType)) {
				SavingsAccount sa=user.getSavingsAccount();
				list.add(sa);
				return list;
			}
			else {
				PrimaryAccount pa=user.getPrimaryAccount();
				list.add(pa);
				return list;
			}
		}else {
			return null;
		}
		
		
	}//method
	
	public String txByBank(BasicAccount baseAcc) throws Exception {
		if (baseAcc.getBalance() > 0 && baseAcc.getOperation() != null) {
			URI uri=new URI(txReq);
			RequestEntity reqEntity=RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON).body(baseAcc);
			ResponseEntity<String> res=restTemplet.exchange(reqEntity, String.class);
			String message=res.getBody();
			return message;
			
		}else {
			return "PLZ SELECT AMOUNT > 0 OR SELECT OPERATION";
		}
		
	}//method

}//class
