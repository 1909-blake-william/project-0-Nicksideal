package com.revature.prompts;

import java.util.Scanner;

public class CurrencyTableManagementPrompt implements Prompt {

	private Scanner scan = new Scanner(System.in);
	@Override
	public Prompt run() {
		System.out.println("Enter 1 to create a new account");
		System.out.println("Enter 2 to remove an account");
		System.out.println("Enter 3 to when you are done managing accounts");
		
		String selection = scan.nextLine();
		
		switch(selection) {
		case "1": 
			return new CreateNewAccountPrompt();
		case "2":
			return new DeleteAccountPrompt();
		case "3":
			return new MainMenuPrompt();
		default: System.out.println("wrong input");
		break;
			
	}
		return null;

}
}
