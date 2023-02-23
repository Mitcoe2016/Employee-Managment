package com.saksoft.employee.dao;

import java.util.List;

import com.saksoft.employee.entity.Employee;

public interface EmployeeDao {
	public boolean saveEmployee(Employee emp);

	public Employee getEmployeeById(int eId);

	public boolean deleteEmployeeById(int eId);

	public boolean updateEmployee(Employee emp);

	public List<Employee> getAllEmployee();
	public List<Employee> sortEmployeeByNameAscendingOrder();
	public long getTotalCountOfEmployee();
}
