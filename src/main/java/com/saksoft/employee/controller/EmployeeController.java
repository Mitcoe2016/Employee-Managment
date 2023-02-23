package com.saksoft.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.saksoft.employee.entity.Employee;
import com.saksoft.employee.exception.EmployeeAlreadyExistException;
import com.saksoft.employee.exception.EmployeeNotFoundtException;
import com.saksoft.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService service;

	@PostMapping(value = "saveEmployees")
	public ResponseEntity<Boolean> saveEmployee(@Valid @RequestBody Employee emp) {
		boolean EmployeeisAdded = service.saveEmployee(emp);
		System.out.println(emp);

		if (EmployeeisAdded) {
			return new ResponseEntity<Boolean>(EmployeeisAdded, HttpStatus.CREATED);
		} else {
			throw new EmployeeAlreadyExistException("Employee already exist with Id=" + emp.geteId());
		}
	}

	@GetMapping(value = "getEmployeeById/{eId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int eId) {
		Employee emp = service.getEmployeeById(eId);
		if (emp != null) {
			return new ResponseEntity<Employee>(emp, HttpStatus.FOUND);
		} else {
			throw new EmployeeNotFoundtException("Employee with id= " + eId + " not found");
		}

	}

	@DeleteMapping(value = "deleteEmployeeById/{eId}")
	public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable int eId) {
		boolean EmployeeIsDeleted = service.deleteEmployeeById(eId);
		if (EmployeeIsDeleted) {
			return new ResponseEntity<Boolean>(EmployeeIsDeleted, HttpStatus.CREATED);
		} else {
			throw new EmployeeNotFoundtException("Employee with id= " + eId + " not found");
		}

	}

	@PutMapping(value = "updateEmployee")
	public ResponseEntity<Boolean> updateEmployee(@RequestBody Employee emp) {
		boolean EmployeeIsUpdated = service.updateEmployee(emp);
		if (EmployeeIsUpdated) {
			return new ResponseEntity<Boolean>(EmployeeIsUpdated, HttpStatus.CREATED);
		} else {
			throw new EmployeeNotFoundtException("Employee with id= " + emp + " not found");

		}

		

	}

	@GetMapping(value = "getAllEmployee")
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> list = service.getAllEmployee();
		if (!list.isEmpty()) {
			return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
		} else {
			throw new EmployeeNotFoundtException("Employee List not exist ");
		}

	}
	
	@GetMapping(value = "sortEmployeeByNameAscendingOrder")
	public ResponseEntity<List<Employee>> sortEmployeeByNameAscendingOrder() {
		List<Employee> sortedList = service.sortEmployeeByNameAscendingOrder();
		System.out.println(sortedList);
		if (!sortedList.isEmpty()) {
			return new ResponseEntity<List<Employee>>(sortedList, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Employee>>(sortedList, HttpStatus.OK);
		}

	}

	@GetMapping(value = "countOfEmployee")
	public ResponseEntity<Long> getTotalCountOfEmployee() {

		long countOfEmployee = service.getTotalCountOfEmployee();

		if (countOfEmployee!= 0) {
			return new ResponseEntity<Long>(countOfEmployee, HttpStatus.OK);
		} else {
			throw new EmployeeNotFoundtException("Employee List not exist ");
		}
		

	}

}
