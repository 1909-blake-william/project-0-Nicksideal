package com.revature.models;

public class CurrencyTable {
	private int account_id;
	private int gold;
	private int silver;
	private int copper;
	private int adventurer;

	public CurrencyTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CurrencyTable(int account_id, int gold, int silver, int copper, int adventurer) {
		super();
		this.account_id = account_id;
		this.gold = gold;
		this.silver = silver;
		this.copper = copper;
		this.adventurer = adventurer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account_id;
		result = prime * result + adventurer;
		result = prime * result + copper;
		result = prime * result + gold;
		result = prime * result + silver;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CurrencyTable other = (CurrencyTable) obj;
		if (account_id != other.account_id)
			return false;
		if (adventurer != other.adventurer)
			return false;
		if (copper != other.copper)
			return false;
		if (gold != other.gold)
			return false;
		if (silver != other.silver)
			return false;
		return true;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public int getSilver() {
		return silver;
	}

	public void setSilver(int silver) {
		this.silver = silver;
	}

	public int getCopper() {
		return copper;
	}

	public void setCopper(int copper) {
		this.copper = copper;
	}

	public int getAdventurer() {
		return adventurer;
	}

	public void setAdventurer(int adventurer) {
		this.adventurer = adventurer;
	}

	@Override
	public String toString() {
		return "CurrencyTable [account_id=" + account_id + ", gold=" + gold + ", silver=" + silver + ", copper="
				+ copper + ", adventurer=" + adventurer + "]";
	}

}
