package com.revature.prompts;

import java.util.List;

import com.revature.daos.UserDao;
import com.revature.daos.UserDaoSQL;
import com.revature.models.TransactionTable;

public class TransactionHistoryPrompt implements Prompt{

	private UserDao userDao = UserDaoSQL.currentImplementation;
	@Override
	public Prompt run() {
		
		
		return null;
	}

	

}
