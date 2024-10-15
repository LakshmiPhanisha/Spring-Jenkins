package com.example.demo.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@PostMapping("/insert")
	public String insert(@RequestBody Employee employee) {
		return employeeService.insert(employee);

	}

	@GetMapping("/get")
	public List<Employee> getData() {
		return employeeService.getData();
	}

	@DeleteMapping("/deleteByIds")
	public ResponseEntity<String> deleteEntitiesByIds(@RequestBody List<Long> ids) {
		employeeService.deleteByIds(ids);
		return ResponseEntity.ok("Entities deleted successfully.");
	}
}
