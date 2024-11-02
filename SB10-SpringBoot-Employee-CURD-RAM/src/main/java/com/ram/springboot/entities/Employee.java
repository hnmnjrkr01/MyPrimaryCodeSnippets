package com.ram.springboot.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Employee")
public class Employee {
	@Id
	@GeneratedValue
	private long empId;
	//Column will be created automatically with JPA
	private String empName;
	private long empSal;

	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public long getEmpSal() {
		return empSal;
	}
	public void setEmpSal(long empSal) {
		this.empSal = empSal;
	}
	//constructor
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + "]";
	}


}
