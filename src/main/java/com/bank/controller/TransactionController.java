package com.bank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.Property;
import com.bank.domain.Account;
import com.bank.domain.BasicAccount;
import com.bank.service.TransactionService;

@Controller
public class TransactionController {
	
	String accountType;
	
	@Autowired
	private TransactionService tService;
	@Autowired
	private Property property;
	
	
	@RequestMapping("/")
	public String showForm() {
		System.out.println("form");
		return "AccountNo";
	}
	
	@RequestMapping("/accNoDtls")
	public String getAccDetls(@RequestParam(value = "accNo") String saccNo,
			@RequestParam(value = "accType") String accType,Model model) {
		
		BasicAccount baseAcc = new BasicAccount();
		
		System.out.println("inside getAccDetls ");
		
		if ("0".equals(saccNo) || "".equals(saccNo) ) {
			model.addAttribute("msg", "Account Number Cant be Zero or Empty");
			return "AccountNo";
			
		}else {
			
			int accNo = Integer.parseInt(saccNo);
			baseAcc.setAccNo(accNo);
			accountType=accType;
			List<Object> list=tService.getAccDetails(accNo, accType);
			
			if (list.isEmpty()) {
				model.addAttribute("msg", "Please Give Correct AccountNumber");
				return "AccountNo";
			}
			StringBuffer name= (StringBuffer) list.get(0);
			Account account=(Account) list.get(1);
			List<Account> list1=new ArrayList<>();
			list1.add(account);
			model.addAttribute("account", list1);
			model.addAttribute("accType", accType);
			model.addAttribute("name", name);
			model.addAttribute("baseAcc", baseAcc);
			model.addAttribute("url", property.getProperties().get("url"));
			System.out.println(property.getProperties().get("url"));
			return "AcountDetails";
		}
		
		
	}//method
	
	@RequestMapping(value = "/txByBank",method = RequestMethod.POST)
	public String txBank(@ModelAttribute("baseAcc") BasicAccount baseAcc,Model model) throws Exception {
		baseAcc.setAccType(accountType);
		String msg=tService.txByBank(baseAcc);
		model.addAttribute("msg", msg);
		model.addAttribute("url", property.getProperties().get("url"));
		return "TransactionForm";
		
	}

}
