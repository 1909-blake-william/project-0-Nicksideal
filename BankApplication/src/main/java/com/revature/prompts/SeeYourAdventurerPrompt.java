package com.revature.prompts;

import com.revature.daos.UserDao;
import com.revature.util.AuthUtil;

public class SeeYourAdventurerPrompt implements Prompt{
	private UserDao userDao = UserDao.currentImplementation;

	@Override
	public Prompt run() {
		// TODO Auto-generated method stub
		System.out.println(AuthUtil.getCurrentUser());
		return new MainMenuPrompt();
	}

}
