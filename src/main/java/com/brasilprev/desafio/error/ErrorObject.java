package com.brasilprev.desafio.error;

import java.io.Serializable;

public class ErrorObject implements Serializable {

	private static final long serialVersionUID = 9156598047719816376L;

	private final String message;
	private final String field;
	private final Object parameter;

	public ErrorObject(String message, String field, Object parameter) {
		super();
		this.message = message;
		this.field = field;
		this.parameter = parameter;
	}

	public String getMessage() {
		return message;
	}

	public String getField() {
		return field;
	}

	public Object getParameter() {
		return parameter;
	}

}