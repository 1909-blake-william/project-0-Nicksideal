package com.revature.prompts;

import java.util.Scanner;

import com.revature.daos.UserDao;
import com.revature.models.User;
import com.revature.util.AuthUtil;

public class MainMenuPrompt implements Prompt{

	private Scanner scan = new Scanner(System.in);
	private UserDao userDao = UserDao.currentImplementation;
	
	@Override
	public Prompt run() {
		
		
		
		if (AuthUtil.getCurrentUser().getRole_type().equals("DungeonMaster")){
			System.out.println("Welcome Dungeon Master.");
			System.out.println("What would you like to see from your current adventurers?");
			System.out.println("Enter 1 to see a the latest list of adventurers.");
			System.out.println("Enter 2 to see the adventurer's inventory.");
			System.out.println("Enter 3 to see the history of transactions.");
			System.out.println("Enter 4 to log out");
			
			String selection = scan.nextLine();
			
			switch(selection) {
			case "1": 
				return new SeeAllAdventurersPrompt();
			case "2":
				return new SeeAllInventoryPrompt();
			case "3": 
				return new AllTransactionHistoryPrompt();
			case "4":
				return new LogOutPrompt();
			default: System.out.println("wrong input");
			break;
			}
			
		}else {	
			System.out.println("Welcome " + AuthUtil.getCurrentUser());
			System.out.println("What would you like to do today?");
			System.out.println("Enter 1 to view your inventory");
			System.out.println("Enter 2 to make changes in your inventory");
			System.out.println("Enter 3 to see your adventurer profile");
			System.out.println("Enter 4 to see your transaction history");
			System.out.println("Enter 5 if you wish to modify your currency tables");
			System.out.println("Enter 6 to log-out");
			
			String selection = scan.nextLine();
			
			switch(selection) {
			case "1": 
				return new ViewInventoryPrompt();
			case "2":
				return new InventoryManagementPrompt();
			case "3": 
				return new SeeYourAdventurerPrompt();
			case "4":
				return new TransactionHistoryPrompt();
			case "5":
				return new CurrencyTableManagementPrompt();
			case "6":
				return new LogOutPrompt();
			default: System.out.println("wrong input");
			break;
			}
		}
		
		return null;
	}
    
}
