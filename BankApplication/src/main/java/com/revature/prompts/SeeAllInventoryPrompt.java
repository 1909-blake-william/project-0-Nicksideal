package com.revature.prompts;

import java.util.List;

import com.revature.daos.CurrencyTableDao;
import com.revature.daos.ItemTableDao;
import com.revature.daos.UserDao;
import com.revature.models.CurrencyTable;
import com.revature.models.ItemTable;

public class SeeAllInventoryPrompt implements Prompt{
	private UserDao userDao = UserDao.currentImplementation;
	private ItemTableDao itemTableDao = ItemTableDao.currentImplementation;
	private CurrencyTableDao currencyTableDao = CurrencyTableDao.currentImplementation;

	@Override
	public Prompt run() {
		
		List<CurrencyTable> currency = currencyTableDao.findAll();
		for (CurrencyTable a:currency) {
			System.out.println(a);
		}
		
		List<ItemTable> item = itemTableDao.findAll();
		for (ItemTable a:item) {
			System.out.println(a);
		}
		
		return new MainMenuPrompt();
	}
	

}
