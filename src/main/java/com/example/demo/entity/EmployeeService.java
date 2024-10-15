package com.example.demo.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepo employeeRepo;
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void deleteByIds(List<Long> ids) {
		employeeRepo.deleteAllById(ids);
	}

	public String insert(Employee employee) {
		Long id = employee.getId();
		String name = employee.getName();
		String Query = "insert into Employee values(?,?)";
		int result = jdbcTemplate.update(Query, id, name);
		if (result > 0) {
			return "inserted";
		} else {
			return "not inserted";
		}
	}

	public List<Employee> getData() {

		return employeeRepo.findAll();
	}
}
