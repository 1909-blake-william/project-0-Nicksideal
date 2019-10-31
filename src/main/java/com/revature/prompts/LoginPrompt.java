package com.revature.prompts;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.daos.UserDao;
import com.revature.models.User;
import com.revature.util.AuthUtil;

public class LoginPrompt implements Prompt {

	private Scanner scan = new Scanner(System.in);
	private Logger log = Logger.getRootLogger();
	private UserDao userDao = UserDao.currentImplementation;
	

		public Prompt run() {
			System.out.println("Welcome to your inventory app for adventuring");
			System.out.println("Enter 1 to login");
			System.out.println("Enter 2 to register");
			String choice = scan.nextLine();
			switch (choice) {
			case "1": {
				log.debug("attempting to login");
				System.out.println("Enter Username");
				String username = scan.nextLine();
				System.out.println("Enter Password");
				String password = scan.nextLine();
				
				User u = AuthUtil.login(username,password);
				
				if (u==null) {	
					log.info("Failed to login due to credentials");
					break;
				}else {
					log.info("Succesfully logged in");
					return new MainMenuPrompt();
				}
			}
			case "2":{
				System.out.println("Enter new username");
				String username = scan.nextLine();
				User u = userDao.findByUsername(username);
				if (u != null) {
					System.out.println("Invalid username");
					break;
				}
				System.out.println("Enter a new password");
				String password = scan.nextLine();
				User newUser = new User(1, username, password, "Adventurer", password, password, password);//fix new user format
				userDao.save(newUser);
				break;
			}
			default:
				System.out.println("Invalid option");
				break;
			}
			return this;
			
		}
	}

