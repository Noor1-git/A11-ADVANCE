package edu.jsp.employee.model;

import java.util.Comparator;

public class SortBySalary implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		return (int)(o1.getSal()-o2.getSal());
	}

	
	
}
