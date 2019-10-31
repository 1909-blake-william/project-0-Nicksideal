package com.revature.prompts;

import java.util.Scanner;

import com.revature.daos.CurrencyTableDao;
import com.revature.daos.TransactionHistoryDao;
import com.revature.daos.UserDao;

public class RemoveCurrencyPrompt implements Prompt{
	private Scanner scan = new Scanner(System.in);
	private UserDao userDao =  UserDao.currentImplementation;
	private CurrencyTableDao  currencyTableDao=  CurrencyTableDao.currentImplementation;
	private TransactionHistoryDao transactionHistoryDao = 
			TransactionHistoryDao.currentImplementation;

	@Override
	public Prompt run() {
		System.out.println("How much Gold you wish to remove?");
		int gold = scan.nextInt();
		System.out.println("How much Silver you wish to remove?");
		int silver = scan.nextInt();
		System.out.println("How Much Copper do you wish to remove?");
		int copper = scan.nextInt();
		scan.nextLine();
		System.out.println("Provide the reason for this transaction/theft");
		String memo = scan.nextLine();
		
		
		String quantityAmount =  "-"+gold + " Gold " + "-"+silver + " Silver " + "-"+copper + " Copper";
		currencyTableDao.rmvCurrency(gold, silver, copper);
		transactionHistoryDao.rmvTransactionCurrency(quantityAmount, memo);
		
		return new RemoveInventoryChangesPrompt();
	}

}
