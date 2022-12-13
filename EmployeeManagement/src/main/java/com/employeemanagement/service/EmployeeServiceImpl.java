package com.employeemanagement.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.model.Employee;
import com.employeemanagement.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	EmployeeRepo employeeRepo;
	@Autowired
	public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	@Override
	public Employee addEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeRepo.findAll();
	}

	@Override
	public void deleteEmployeeById(Long id) {
		if(employeeRepo.existsById(id)) {
			employeeRepo.deleteById(id);
		}
	}
	
	@Override
	public Employee updateEmployeeById(Long id, Employee employee) {
        Employee employee1 = employeeRepo.findById(id).get();

        if(Objects.nonNull(employee.getId())) {
        	employee1.setId(employee.getId());
        }
        
        if(Objects.nonNull(employee.getFirstName())) {
        	employee1.setFirstName(employee.getFirstName());
        }
        
        if(Objects.nonNull(employee.getLastName())) {
        	employee1.setLastName(employee.getLastName());
        }
        
        if(Objects.nonNull(employee.getAddress())) {
        	employee1.setAddress(employee.getAddress());
        }
		
		return employeeRepo.save(employee1);
	}
	
}
