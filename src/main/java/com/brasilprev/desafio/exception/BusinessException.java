package com.brasilprev.desafio.exception;

import org.springframework.http.HttpStatus;

import com.brasilprev.desafio.error.ErrorResponse;

public class BusinessException extends Exception {

	private static final long serialVersionUID = -1964727435145661424L;

	public static final String ERROR_EXISTS = "Cliente ja existe!";
	public static final String ERROR_NOT_FOUND = "Cliente nao existe!";

	public BusinessException(String message, HttpStatus httpStatus) {
		this.error = new ErrorResponse(message, httpStatus);
	}
	
	public BusinessException(String message) {
		this.error = new ErrorResponse(message, HttpStatus.BAD_REQUEST);
	}

	private final ErrorResponse error;

	public ErrorResponse getError() {
		return error;
	}
}
