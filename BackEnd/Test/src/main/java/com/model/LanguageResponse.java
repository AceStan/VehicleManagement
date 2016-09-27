package com.model;

import java.util.ArrayList;

public class LanguageResponse {

	private ArrayList<String> signInStrings = new ArrayList<String>();

	
	
	public LanguageResponse() {
		super();
	}

	public ArrayList<String> getSignInStrings() {
		return signInStrings;
	}

	public void setSignInStrings(ArrayList<String> signInStrings) {
		this.signInStrings = signInStrings;
	}
	
}
