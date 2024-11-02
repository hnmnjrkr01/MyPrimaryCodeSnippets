package com.ram.springboot.dao;
import java.util.List;

import com.ram.springboot.entities.Employee;

public interface EmployeeDaoI {
	
	Employee CreateEmployee(Employee emp);
	Employee findEmployeeById(long empId);
	Employee updateEmployee(Employee emp); 
	List<Employee> findAllEmployees();
	void deleteEmployee(long empId);
}
