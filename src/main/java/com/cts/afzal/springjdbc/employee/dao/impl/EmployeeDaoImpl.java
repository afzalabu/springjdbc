package com.cts.afzal.springjdbc.employee.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cts.afzal.springjdbc.employee.dao.EmployeeDao;
import com.cts.afzal.springjdbc.employee.dao.rowmapper.EmployeeRowMapper;
import com.cts.afzal.springjdbc.employee.dto.Employee;


@Component("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int create(Employee employee) {

		int result = 0;

		String sql = "insert into employee values(?,?,?)";

		result = jdbcTemplate.update(sql, employee.getId(), employee.getFirstName(), employee.getLastName());

		return result;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int update(Employee employee) {

		int result = 0;

		String sql = "update employee set firstname=?, lastname=? where id=?";

		result = jdbcTemplate.update(sql, employee.getFirstName(), employee.getLastName(), employee.getId());

		return result;
	}

	@Override
	public int delete(int id) {

		int result = 0;

		String sql = "delete from employee where id=?";

		result = jdbcTemplate.update(sql, id);

		return result;
	}

	@Override
	public Employee read(int employeeId) {

		String sql = "select * from employee where id=?";
		
		EmployeeRowMapper rowMapper = new EmployeeRowMapper();
		
		Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, employeeId);
		
		return employee;
	}

	@Override
	public List<Employee> read() {

		String sql = "select * from employee";
		
		EmployeeRowMapper rowMapper = new EmployeeRowMapper();
		
		List<Employee> employeeList = jdbcTemplate.query(sql, rowMapper);
		
		return employeeList;
	}

}
