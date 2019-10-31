package com.revature.prompts;

import java.util.List;

import com.revature.daos.UserDao;
import com.revature.models.User;

public class SeeAllAdventurersPrompt implements Prompt{

	private UserDao userDao = UserDao.currentImplementation;
	
	
	@Override
	public Prompt run() {
		List<User> adventurer = userDao.findAll();
		for (User a:adventurer) {
			System.out.println(a);
		}
		
		return new MainMenuPrompt();
	}

	

}
