package com.revature.prompts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.revature.daos.CurrencyTableDao;
import com.revature.daos.UserDao;
import com.revature.models.CurrencyTable;
import com.revature.util.AuthUtil;

public class DeleteAccountPrompt implements Prompt {
	private Scanner scan = new Scanner(System.in);
	private CurrencyTableDao currencyTableDao = CurrencyTableDao.currentImplementation;
	private UserDao userDao = UserDao.currentImplementation;

	@Override
	public Prompt run() {
		
		List<CurrencyTable> currentTable = new ArrayList<CurrencyTable>();
		
		System.out.println("Select by Account ID which account you wish to delete.");
		currentTable=(CurrencyTableDao.currentImplementation.findByAdventurer(AuthUtil.getCurrentUser().getId()));
		System.out.println(currentTable);
		int accountId=scan.nextInt();
		scan.nextLine();
		
		int ps = currencyTableDao.delete(accountId);
		
		
		if(ps == 0) {
			System.out.println("Account was not deleted.");
			System.out.println("Please check the Account ID and select the account you wish to delete.");
			System.out.println(currentTable);
		}else{
			System.out.println("Account was succesfully deleted.");
			System.out.println("Press 1 if you wish to delete another account");
			System.out.println("Press 2 if you wish to return to the Main Menu");
			
			String selection = scan.nextLine();
			
			switch(selection) {
			case "1":
				return new DeleteAccountPrompt();
			case "2":
				return new MainMenuPrompt();
				default:
					System.out.println("Invalid option");
					break;
			}
		}
		return null;
	}

}
