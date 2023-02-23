package com.saksoft.employee.dao;

import java.awt.print.Book;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.saksoft.employee.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveEmployee(Employee emp) {
		boolean EmployeeisAdded = false;
		Session session = sessionFactory.openSession();
		Employee emp1 = session.get(Employee.class, emp.geteId());
		Transaction transaction = session.beginTransaction();
		try {
			if (emp != null) {
				session.save(emp);
				transaction.commit();
				EmployeeisAdded = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return EmployeeisAdded;
	}

	@Override
	public Employee getEmployeeById(int eId) {
		Employee emp = null;
		Session session = sessionFactory.openSession();
		try {
			emp = session.get(Employee.class, eId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return emp;

	}

	@Override
	public boolean deleteEmployeeById(int eId) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean EmployeeIsDeleted = false;
		try {
			Employee emp = session.get(Employee.class, eId);
			if (emp != null) {
				session.delete(emp);
				transaction.commit();
				EmployeeIsDeleted = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return EmployeeIsDeleted;
	}

	@Override
	public boolean updateEmployee(Employee emp) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean EmployeeIsUpdated = false;
		try {
			Employee emp2 = session.get(Employee.class, emp.geteId());
			session.evict(emp2);
			session.update(emp2);
			transaction.commit();
			EmployeeIsUpdated = true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return EmployeeIsUpdated;
	}

	@Override
	public List<Employee> getAllEmployee() {
		Session session = sessionFactory.openSession();
		List<Employee> list = null;
		try {
			Criteria criteria = session.createCriteria(Employee.class);
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<Employee> sortEmployeeByNameAscendingOrder() {
		Session session = sessionFactory.openSession();
		List<Employee> sortedList = null;
		try {
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.addOrder(Order.asc("eFirstName"));
			//criteria.addOrder(Order.desc("eFirstName"));

			sortedList = criteria.list();
			System.out.println(sortedList);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return sortedList;
	}

	

	@Override
	public long getTotalCountOfEmployee() {
		Session session = sessionFactory.openSession();
		long countOfEmployees = 0;
		try {
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.setProjection(Projections.rowCount());
			List<Long> list = criteria.list();
			if (!list.isEmpty()) {
				countOfEmployees = list.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return countOfEmployees;

	}

}
