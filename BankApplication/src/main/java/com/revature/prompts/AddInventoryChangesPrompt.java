package com.revature.prompts;

import java.util.Scanner;

public class AddInventoryChangesPrompt implements Prompt{

	private Scanner scan = new Scanner(System.in);
	
	@Override
	public Prompt run() {
		System.out.println("Press 1 to add currency");
		System.out.println("Press 2 to add items");
		System.out.println("Press 3 when you are done adding items");
		String selection = scan.nextLine();
		switch(selection) {
		case "1":
			return new AddCurrencyPrompt();
		case "2":
			return new AddItemsPrompt();
		case "3":
			return new InventoryManagementPrompt();
		default:
			System.out.println("Invalid Selection");
		}
		return null;
	}

}
