package com.revature.prompts;

import java.util.Scanner;

public class InventoryManagementPrompt implements Prompt{

		private Scanner scan = new Scanner(System.in);
		
	@Override
	public Prompt run() {
		
		System.out.println("Welcome to Inventory Management");
		System.out.println("");
		System.out.println("Do you wish to add to your inventory? Press 1");
		System.out.println("Do you wish to remove from your inventory? Press 2");
		System.out.println("Are you done with managing your inventory? Press 3");
		
		String selection = scan.nextLine();
		switch(selection) {
		case "1":
			return new AddInventoryChangesPrompt();
		case "2":
			return new RemoveInventoryChangesPrompt();
		case "3":
			return new MainMenuPrompt();
		default:
			System.out.println("Invalid Selection");
			break;
		}
		return null;
	}
	

}
