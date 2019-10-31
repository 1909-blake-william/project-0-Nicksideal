package com.revature.prompts;

import java.util.Scanner;

import com.revature.daos.CurrencyTableDao;
import com.revature.daos.TransactionHistoryDao;
import com.revature.daos.UserDao;

public class AddCurrencyPrompt implements Prompt{

	private Scanner scan = new Scanner(System.in);
	private UserDao userDao =  UserDao.currentImplementation;
	private CurrencyTableDao  currencyTableDao=  CurrencyTableDao.currentImplementation;
	private TransactionHistoryDao transactionHistoryDao = 
			TransactionHistoryDao.currentImplementation;
	@Override
	public Prompt run() {
		
		System.out.println("How much Gold you wish to add?");
		int gold = scan.nextInt();
		System.out.println("How much Silver you wish to add?");
		int silver = scan.nextInt();
		System.out.println("How Much Copper do you wish to add?");
		int copper = scan.nextInt();
		scan.nextLine();
		System.out.println("How did you obtain this money?");
		String memo = scan.nextLine();
		
		String quantityAmount =  gold + " Gold " + silver + " Silver " + copper + " Copper"; 
		currencyTableDao.addCurrency(gold, silver, copper);
		transactionHistoryDao.addTransactionCurrency(quantityAmount, memo);
		
		return new AddInventoryChangesPrompt();
	}

}
