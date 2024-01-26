package com.jmant69.csvrestapi.response;

public class UploadResponse {
	public UploadResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String message;
	
	public UploadResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
