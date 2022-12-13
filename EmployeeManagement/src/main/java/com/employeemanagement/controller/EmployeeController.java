package com.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.model.Employee;
import com.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	EmployeeService employeeService;
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping()
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addEmployee(employee);
	}
	
	@GetMapping()
	public List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployeeById(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployeeById(@PathVariable Long id, @RequestBody Employee employee) {
		return employeeService.updateEmployeeById(id, employee);
	}
}
