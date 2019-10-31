package com.revature.prompts;

import java.util.ArrayList;
import java.util.List;

import com.revature.daos.TransactionHistoryDao;
import com.revature.daos.TransactionHistoryDaoSQL;
import com.revature.daos.UserDao;
import com.revature.daos.UserDaoSQL;
import com.revature.models.TransactionTable;
import com.revature.util.AuthUtil;

public class TransactionHistoryPrompt implements Prompt{

	private UserDao userDao = UserDaoSQL.currentImplementation;
	private TransactionHistoryDao transactionHistoryDao = TransactionHistoryDaoSQL.currentImplementation;
	@Override
	public Prompt run() {
		
		List<TransactionTable> userTranTable = new ArrayList<TransactionTable>();
		userTranTable = transactionHistoryDao.findByAdventurer(AuthUtil.getCurrentUser().getId());
		
		for(TransactionTable s:userTranTable) {
			System.out.println(s);
		}
		
		return new MainMenuPrompt();
	}

	

}
