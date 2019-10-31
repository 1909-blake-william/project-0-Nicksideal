package com.revature.prompts;

import java.util.List;
import java.util.Scanner;

import com.revature.daos.ItemTableDao;
import com.revature.daos.TransactionHistoryDao;
import com.revature.models.ItemTable;
import com.revature.util.AuthUtil;

public class RemoveItemPrompt implements Prompt{

	private Scanner scan = new Scanner(System.in);
	private ItemTableDao itemTableDao = ItemTableDao.currentImplementation;
	private TransactionHistoryDao transactionHistoryDao = 
			TransactionHistoryDao.currentImplementation;
	@Override
	public Prompt run() {

		System.out.println("Select the item you wish to remove by entering its ID");
		List<ItemTable> itemTable = itemTableDao.findByAdventurer(AuthUtil.getCurrentUser().getId());
		for(ItemTable i:itemTable) {
			System.out.println(i);
		}
		int itemID = scan.nextInt();
		scan.nextLine();
		System.out.println("Provide the reason for removing the item");
		String memo = scan.nextLine();
		
		String item = itemTableDao.findById(itemID);
		
		itemTableDao.rmvItem(itemID);
		transactionHistoryDao.rmvTransactionItem(item, memo);
		
		return new InventoryManagementPrompt();
	}

}
