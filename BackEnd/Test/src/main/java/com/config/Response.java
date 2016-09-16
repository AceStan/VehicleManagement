package com.config;

public class Response<E> {
	private E data;
	private boolean okUser;
	private boolean okPass;
	private boolean okSSID;
	public E getData() {
		return data;
	}
	public void setData(E data) {
		this.data = data;
	}
	public boolean isOkUser() {
		return okUser;
	}
	public void setOkUser(boolean okUser) {
		this.okUser = okUser;
	}
	public boolean isOkPass() {
		return okPass;
	}
	public void setOkPass(boolean okPass) {
		this.okPass = okPass;
	}
	public boolean isOkSSID() {
		return okSSID;
	}
	public void setOkSSID(boolean okSSID) {
		this.okSSID = okSSID;
	}
	public Response(E data, boolean okUser, boolean okPass, boolean okSSID) {
		super();
		this.data = data;
		this.okUser = okUser;
		this.okPass = okPass;
		this.okSSID = okSSID;
	}
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
