package edu.jsp.employee.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import edu.jsp.employee.model.Employee;
import edu.jsp.employee.model.SortByContact;
import edu.jsp.employee.model.SortById;
import edu.jsp.employee.model.SortByName;
import edu.jsp.employee.model.SortBySalary;

public class Controller {

	private List<Employee> employees = new ArrayList<>();

	public Employee saveEmployee(Employee employee) {

		if (employee != null) {

			employees.add(employee);
			return employee;

		} else {
			return null;
		}
	}

	public Employee deleteEmployee(Employee target) {

		if (target != null) {

			for (Employee employee : employees) {
				if (employee.getId() == target.getId()) {
					employees.remove(employee);
					return employee;
				}
			}
			return null;
		} else {
			return null;
		}
	}

	public List<Employee> getAllEmployee() {
		return sortedEmployees(null);
	}

	public Employee getEmployee(int id) {

		if (id > 0) {
			for (Employee employee : employees) {
				if (employee.getId() == id) {
					return employee;
				}
			}
			return null;
		} else {
			return null;
		}
	}

	public List<Employee> sortedEmployees(Comparator<Employee> comparator) {

		if (comparator instanceof SortById) {
			Collections.sort(employees, comparator);
			return employees;
		} else if (comparator instanceof SortByName) {
			Collections.sort(employees, comparator);
			return employees;
		} else if (comparator instanceof SortBySalary) {
			Collections.sort(employees, comparator);
			return employees;
		} else if (comparator instanceof SortByContact) {
			Collections.sort(employees, comparator);
			return employees;
		} else {
			return employees;
		}

	}

}
