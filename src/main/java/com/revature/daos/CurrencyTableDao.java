package com.revature.daos;

import java.util.List;

import com.revature.models.CurrencyTable;
import com.revature.models.ItemTable;


public interface CurrencyTableDao {
	UserDao currentimplementation = new UserDaoSQL();
	CurrencyTableDao currentImplementation = new CurrencyTableDaoSQL();
	
	int save (int gold, int silver, int copper);
	
	List<CurrencyTable> findAll();
	
	List<CurrencyTable> findByAdventurer(int adventurer);
	
	List<CurrencyTable> addCurrency (int gold, int silver, int copper);

	List<CurrencyTable> rmvCurrency(int gold, int silver, int copper);

	int delete(int account_id);
	
	
}
