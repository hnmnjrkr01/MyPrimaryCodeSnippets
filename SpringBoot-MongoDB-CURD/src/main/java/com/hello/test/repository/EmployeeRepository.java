package com.hello.test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hello.test.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer>{

}
