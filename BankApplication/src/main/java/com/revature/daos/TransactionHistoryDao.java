package com.revature.daos;

import java.util.List;

import com.revature.models.TransactionTable;

public interface TransactionHistoryDao {

	TransactionHistoryDao currentImplementation = new TransactionHistoryDaoSQL();
	
	int save (TransactionTable c);
	
	List<TransactionTable> findAll();
	
	List<TransactionTable> findByAdventurer(int id);
	
	int addTransactionItem(String item, String memo);

	int addTransactionCurrency(String quantity, String memo);

	int rmvTransactionItem(String item, String memo);

	int rmvTransactionCurrency(String quantity, String memo);
}
