package com.saksoft.employee.exception;

public class EmployeeAlreadyExistException extends RuntimeException {
	public EmployeeAlreadyExistException(String message) {
		super(message);

	}
}
