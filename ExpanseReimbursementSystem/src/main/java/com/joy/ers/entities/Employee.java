package com.joy.ers.entities;

public class Employee {
	private int id;
	private String username;
	private String password;

	public Employee() {
		super();
	}

	public Employee(int id, String username) {
		super();
		this.id = id;
		this.username = username;
	}

	public Employee(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setPass(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "[USER] (id=" + id + ", username=" + username + ", password=" + password + "]";
	}
}