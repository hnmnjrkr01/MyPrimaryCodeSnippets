package com.hello.test.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hello.test.model.Employee;
import com.hello.test.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository empRepository;
	
	@PostMapping("/addEmp")
	public String saveEmployee(@RequestBody Employee employee) {
		empRepository.save(employee);
		return " Employee added with id: " + employee.getId();
	}
	
	@GetMapping("/getallEmployees")
	public List<Employee> getEmployees(){
		return empRepository.findAll();
	}
	
	@GetMapping("/getEmpById/{id}")
	public Optional<Employee> getEmployee(@PathVariable int id){
		return empRepository.findById(id);
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public String deleteEmployee(@PathVariable int id){
		empRepository.deleteById(id);
		return "Employee deleted, Id: " + id;
	}

}
