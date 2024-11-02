package com.ram.springboot.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.ram.springboot.entities.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDaoI {
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public Employee CreateEmployee(Employee emp) {
		return entityManager.merge(emp);
	}

	@Override
	public Employee findEmployeeById(long empId) {
		return entityManager.find(Employee.class,empId);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		//Employee emp=entityManager.find(Employee.class,employee.getEmpId());
		
		Employee emp=findEmployeeById(employee.getEmpId());//calling find Employee-Id method to 
		emp.setEmpName(employee.getEmpName());
		emp.setEmpSal(employee.getEmpSal());
		emp=entityManager.merge(emp);
		return emp;
	}
	
	@Override
	public List<Employee> findAllEmployees() {
		                                // Select * from Employee
		Query q = entityManager.createQuery("select e from Employee e");
	    List<Employee> list=q.getResultList();
		return list;
	}
	@Override
	public void deleteEmployee(long empId) {
		Employee emp=entityManager.find(Employee.class, empId);
		entityManager.remove(emp);
	}

}
	
