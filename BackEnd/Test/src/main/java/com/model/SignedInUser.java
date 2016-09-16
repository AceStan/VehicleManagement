package com.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SignedInUser implements Serializable{

	private String username;
	private String password;
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
	public SignedInUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public SignedInUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
