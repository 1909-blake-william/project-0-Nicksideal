package com.revature.models;

public class ItemTable {
	private int item_id;
	private String item_name;
	private int adventurer;
	public ItemTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemTable(int item_id, String item_name, int adventurer) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.adventurer = adventurer;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + adventurer;
		result = prime * result + item_id;
		result = prime * result + ((item_name == null) ? 0 : item_name.hashCode());
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
		ItemTable other = (ItemTable) obj;
		if (adventurer != other.adventurer)
			return false;
		if (item_id != other.item_id)
			return false;
		if (item_name == null) {
			if (other.item_name != null)
				return false;
		} else if (!item_name.equals(other.item_name))
			return false;
		return true;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getAdventurer() {
		return adventurer;
	}
	public void setAdventurer(int adventurer) {
		this.adventurer = adventurer;
	}
	@Override
	public String toString() {
		return "ItemTable [item_id=" + item_id + ", item_name=" + item_name + ", adventurer=" + adventurer + "]";
	}
	
	
}
