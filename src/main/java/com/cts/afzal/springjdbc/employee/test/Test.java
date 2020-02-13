package com.cts.afzal.springjdbc.employee.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.afzal.springjdbc.employee.dao.EmployeeDao;
import com.cts.afzal.springjdbc.employee.dto.Employee;

public class Test {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");

		EmployeeDao employeeDao = ctx.getBean("employeeDao", EmployeeDao.class);

//		Employee emp = employeeDao.read(1001);

		List<Employee> emp = employeeDao.read();

		System.out.println("Employee record:\n" + emp);

	}

}
