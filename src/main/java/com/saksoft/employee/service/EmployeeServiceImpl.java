package com.saksoft.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saksoft.employee.dao.EmployeeDao;
import com.saksoft.employee.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao dao;

	@Override
	public boolean saveEmployee(Employee emp) {
		boolean EmployeeisAdded = dao.saveEmployee(emp);
		return EmployeeisAdded;

	}

	@Override
	public Employee getEmployeeById(int eId) {
		Employee emp = dao.getEmployeeById(eId);
		return emp;
	}

	@Override
	public boolean deleteEmployeeById(int eId) {
		boolean EmployeeIsDeleted=dao.deleteEmployeeById(eId);
		return EmployeeIsDeleted;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		boolean EmployeeIsUpdated =dao.updateEmployee(emp);
		return EmployeeIsUpdated;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list=dao.getAllEmployee();
		return list;
	}

	@Override
	public List<Employee> sortEmployeeByNameAscendingOrder() {
		List<Employee> sortedList=dao.sortEmployeeByNameAscendingOrder();
		return sortedList;
	}

	@Override
	public long getTotalCountOfEmployee() {
		long countOfEmployees = dao.getTotalCountOfEmployee();

			return countOfEmployees;
	}

}
