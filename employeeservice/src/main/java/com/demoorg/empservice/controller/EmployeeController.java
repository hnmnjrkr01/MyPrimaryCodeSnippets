package com.demoorg.empservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoorg.empservice.model.Employee;
import com.demoorg.empservice.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/getallemp")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
		
	}
	
	@GetMapping("/getemp/{eid}")
	public Optional<Employee> getEmployee(@PathVariable int eid) {
		return employeeRepository.findById(eid);
	}
	
	@PostMapping("/addemp")
	public String addEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return "Employee added with Id: " + employee.getEid();
	}

}
