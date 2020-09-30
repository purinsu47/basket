package com.gofluent.shopping.util;

public class Success {
	boolean isSuccessful;
	String message;

	public Success(boolean isSuccessful, String message) {
		super();
		this.isSuccessful = isSuccessful;
		this.message = message;
	}

	public boolean isSuccessful() {
		return isSuccessful;
	}

	public void setSuccessful(boolean isSuccessful) {
		this.isSuccessful = isSuccessful;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
