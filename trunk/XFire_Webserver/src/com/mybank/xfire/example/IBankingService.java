package com.mybank.xfire.example;

public interface IBankingService {
	public String transferFunds(String fromAccount, String toAccount, double amount, String currency);
	        
}
