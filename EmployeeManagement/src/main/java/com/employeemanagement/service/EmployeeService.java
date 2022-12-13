package com.employeemanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employeemanagement.model.Employee;

@Service
public interface EmployeeService {
	public Employee addEmployee(Employee employee);
	public List<Employee> getEmployees();
	public void deleteEmployeeById(Long id);
	public Employee updateEmployeeById(Long id, Employee employee);
}
