package com.saksoft.employee.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(EmployeeAlreadyExistException.class)
	public ResponseEntity<String> employeeAlreadyExistException(EmployeeAlreadyExistException ex) {
		String message = ex.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(EmployeeNotFoundtException.class)
	public ResponseEntity<String> employeeNotFoundtException(EmployeeNotFoundtException ex) {
		String message = ex.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> methodArgumentNotValidException(MethodArgumentNotValidException ex) {
		Map<String, String> map = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((errors) -> {
			String fieldName = ((FieldError) errors).getField();
			String message = errors.getDefaultMessage();
			map.put(fieldName, message);
		});
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.BAD_REQUEST);

	}

}
