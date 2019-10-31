package com.revature.prompts;

import java.util.Scanner;

public class RemoveInventoryChangesPrompt implements Prompt{

	private Scanner scan = new Scanner(System.in);
	@Override
	public Prompt run() {
		System.out.println("Press 1 to remove currency");
		System.out.println("Press 2 to remove items");
		System.out.println("Press 3 when you are done removing items");
		String selection = scan.nextLine();
		switch(selection) {
		case "1":
			return new RemoveCurrencyPrompt();
		case "2":
			return new RemoveItemPrompt();
		case "3":
			return new InventoryManagementPrompt();
		default:
			System.out.println("Invalid Selection");
		}
		return null;
	}

}
