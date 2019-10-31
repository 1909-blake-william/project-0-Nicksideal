package com.revature.prompts;

import java.util.Scanner;

import com.revature.daos.CurrencyTableDao;

public class CreateNewAccountPrompt implements Prompt {

	private Scanner scan = new Scanner(System.in);
	private CurrencyTableDao currencyTableDao = CurrencyTableDao.currentImplementation;
	
	@Override
	public Prompt run() {
		
		System.out.println("How much gold are you starting with?");
		int gold=scan.nextInt();
		System.out.println("How much silver are you starting with?");
		int silver=scan.nextInt();
		System.out.println("How much copper are you starting with?");
		int copper=scan.nextInt();
		
		currencyTableDao.save(gold, silver, copper);
		
		return null;
	}

}
