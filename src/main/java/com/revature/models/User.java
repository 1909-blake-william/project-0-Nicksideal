package com.revature.models;

import java.io.Serializable;

public class User implements Serializable {
	private int adventurer_id;
	private String username;
	private String password;
	private String race;
	private String class_type;
	private String active;
	private String role_type;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String username, String password, String race, String class_type, String active,
			String role_type) {
		super();
		this.adventurer_id = id;
		this.username = username;
		this.password = password;
		this.race = race;
		this.class_type = class_type;
		this.active = active;
		this.role_type = role_type;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((active == null) ? 0 : active.hashCode());
		result = prime * result + ((class_type == null) ? 0 : class_type.hashCode());
		result = prime * result + adventurer_id;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((race == null) ? 0 : race.hashCode());
		result = prime * result + ((role_type == null) ? 0 : role_type.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (active == null) {
			if (other.active != null)
				return false;
		} else if (!active.equals(other.active))
			return false;
		if (class_type == null) {
			if (other.class_type != null)
				return false;
		} else if (!class_type.equals(other.class_type))
			return false;
		if (adventurer_id != other.adventurer_id)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (race == null) {
			if (other.race != null)
				return false;
		} else if (!race.equals(other.race))
			return false;
		if (role_type == null) {
			if (other.role_type != null)
				return false;
		} else if (!role_type.equals(other.role_type))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	public int getId() {
		return adventurer_id;
	}
	public void setId(int id) {
		this.adventurer_id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getClass_type() {
		return class_type;
	}
	public void setClass_type(String class_type) {
		this.class_type = class_type;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getRole_type() {
		return role_type;
	}
	public void setRole_type(String role_type) {
		this.role_type = role_type;
	}
	@Override
	public String toString() {
		return "User [id=" + adventurer_id + ", username=" + username + ", password=" + password + ", race=" + race
				+ ", class_type=" + class_type + ", active=" + active + ", role_type=" + role_type + "]";
	}
	public int getAdventurer_id() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
