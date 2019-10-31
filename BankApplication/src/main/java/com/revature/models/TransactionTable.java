package com.revature.models;

public class TransactionTable {
	private int transaction_id;
	private String type;
	private String quantity_amount;
	private String item_name;
	private String memo;
	private int adventurer;
	public TransactionTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TransactionTable(int transaction_id, String type, String quantity_amount, String item_name, String memo,
			int adventurer) {
		super();
		this.transaction_id = transaction_id;
		this.type = type;
		this.quantity_amount = quantity_amount;
		this.item_name = item_name;
		this.memo = memo;
		this.adventurer = adventurer;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + adventurer;
		result = prime * result + ((item_name == null) ? 0 : item_name.hashCode());
		result = prime * result + ((memo == null) ? 0 : memo.hashCode());
		result = prime * result + ((quantity_amount == null) ? 0 : quantity_amount.hashCode());
		result = prime * result + transaction_id;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		TransactionTable other = (TransactionTable) obj;
		if (adventurer != other.adventurer)
			return false;
		if (item_name == null) {
			if (other.item_name != null)
				return false;
		} else if (!item_name.equals(other.item_name))
			return false;
		if (memo == null) {
			if (other.memo != null)
				return false;
		} else if (!memo.equals(other.memo))
			return false;
		if (quantity_amount == null) {
			if (other.quantity_amount != null)
				return false;
		} else if (!quantity_amount.equals(other.quantity_amount))
			return false;
		if (transaction_id != other.transaction_id)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQuantity_amount() {
		return quantity_amount;
	}
	public void setQuantity_amount(String quantity_amount) {
		this.quantity_amount = quantity_amount;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getAdventurer() {
		return adventurer;
	}
	public void setAdventurer(int adventurer) {
		this.adventurer = adventurer;
	}
	@Override
	public String toString() {
		return "TransactionTable [transaction_id=" + transaction_id + ", type=" + type + ", quantity_amount="
				+ quantity_amount + ", item_name=" + item_name + ", memo=" + memo + ", adventurer=" + adventurer + "]";
	}

}