package com.revature.daos;

import java.util.List;

import com.revature.models.ItemTable;

public interface ItemTableDao {
	
	
	ItemTableDao currentImplementation = new ItemTableDaoSQL();
	UserDao userDao = UserDao.currentImplementation;
	
	int save (ItemTable i);
	
	List<ItemTable> findAll();
	
	List<ItemTable> findByAdventurer(int adventurerId);
	
	String addItem(String item);
	
	int rmvItem(int item);

	String findById(int adventurer);
	
	
	
}
