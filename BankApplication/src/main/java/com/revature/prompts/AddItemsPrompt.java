package com.revature.prompts;

import java.util.Scanner;

import com.revature.daos.ItemTableDao;
import com.revature.daos.ItemTableDaoSQL;
import com.revature.daos.TransactionHistoryDao;
import com.revature.daos.TransactionHistoryDaoSQL;
import com.revature.daos.UserDao;
import com.revature.daos.UserDaoSQL;

public class AddItemsPrompt implements Prompt {
	private UserDao userDao = UserDao.currentImplementation;
	private ItemTableDao itemTableDao = ItemTableDao.currentImplementation;
	private TransactionHistoryDao transactionHistoryDao = TransactionHistoryDao.currentImplementation;

	private Scanner scan = new Scanner(System.in);

	@Override
	public Prompt run() {

		System.out.println("What Item do you wish to add?");
		String item = scan.nextLine();
		System.out.println("How did you obtain this item?");
		String memo = scan.nextLine();

		itemTableDao.addItem(item);
		transactionHistoryDao.addTransactionItem(item, memo);

		return new AddInventoryChangesPrompt();
	}

}
