package com.cts.afzal.springjdbc.employee.dao;

import java.util.List;

import com.cts.afzal.springjdbc.employee.dto.Employee;

public interface EmployeeDao {

	int create(Employee employee);

	int update(Employee employee);

	int delete(int id);
	
	Employee read(int employeeId);
	
	List<Employee> read();

}
