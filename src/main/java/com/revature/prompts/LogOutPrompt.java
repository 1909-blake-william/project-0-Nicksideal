package com.revature.prompts;

import java.util.Scanner;

public class LogOutPrompt implements Prompt {

	private Scanner scan = new Scanner(System.in);

	@Override
	public Prompt run() {

		System.out.println("Press 1 if you are done managaging your Inventory");
		System.out.println("Press 2 if you with to continue managing your inventory");

		String choice = scan.nextLine();
		switch (choice) {
		case "1":
			return new LoginPrompt();
		case "2":
			return new MainMenuPrompt();
		default:
			System.out.println("Enter the correct input");
			return new LogOutPrompt();
		}

	}
}