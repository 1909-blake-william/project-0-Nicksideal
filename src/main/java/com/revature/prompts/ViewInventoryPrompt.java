package com.revature.prompts;

import java.util.ArrayList;
import java.util.List;

import com.revature.daos.CurrencyTableDao;
import com.revature.daos.ItemTableDao;
import com.revature.daos.UserDao;
import com.revature.models.CurrencyTable;
import com.revature.models.ItemTable;
import com.revature.util.AuthUtil;

public class ViewInventoryPrompt implements Prompt{
	
	private UserDao userDao = UserDao.currentImplementation;
	private ItemTableDao itemTableDao = ItemTableDao.currentImplementation;
	private CurrencyTableDao currencyTableDao = CurrencyTableDao.currentImplementation;
	
	
	
	@Override
	public Prompt run() {
		
		// get currency from currency dao and output to user
		//System.out.println("your gold is: " + currency.getGold() + " s=" +);
		List<CurrencyTable> printCurrency = new ArrayList<CurrencyTable>();
		printCurrency = currencyTableDao.findByAdventurer(AuthUtil.getCurrentUser().getId());
	
		System.out.println(printCurrency);
		// get items from item dao and output to user
		List<ItemTable> printItem = new ArrayList<ItemTable>();
		printItem = itemTableDao.findByAdventurer(AuthUtil.getCurrentUser().getId());
		 	 
		 for(ItemTable i:printItem) {
			 System.out.println(i);	 
		 }
		
		return new MainMenuPrompt();
		
	}
}
