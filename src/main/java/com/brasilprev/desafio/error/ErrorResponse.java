package com.brasilprev.desafio.error;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ErrorResponse implements Serializable{

	private static final long serialVersionUID = 6055861157808135917L;
	
	private final String message;
	private final int code;
	private final String status;
	private final String objectName;
	private final List<ErrorObject> errors;
	
	public ErrorResponse(String message, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.code = httpStatus.value();
		this.status = httpStatus.getReasonPhrase();
		this.objectName = "";
		this.errors = new ArrayList<>(0);
	}
	

	public ErrorResponse(String message, int code, String status, String objectName, List<ErrorObject> errors) {
		super();
		this.message = message;
		this.code = code;
		this.status = status;
		this.objectName = objectName;
		this.errors = errors;
	}

	public String getMessage() {
		return message;
	}

	public int getCode() {
		return code;
	}

	public String getStatus() {
		return status;
	}

	public String getObjectName() {
		return objectName;
	}

	public List<ErrorObject> getErrors() {
		return errors;
	}

}
