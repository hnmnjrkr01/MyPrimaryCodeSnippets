package com.ram.hibernate;
import java.io.Serializable;
import java.util.Date;


public class Employee implements Serializable{
private int empno;
private String ename;
private double sal;
private Date hiredate;
private int deptno;

public int getDeptno() {
	return deptno;
}
public void setDeptno(int deptno) {
	this.deptno = deptno;
}
public int getEmpno() {
	return empno;
}
public void setEmpno(int empno) {
	this.empno = empno;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public Date getHiredate() {
	return hiredate;
}
public void setHiredate(Date hiredate) {
	this.hiredate = hiredate;
}
public double getSal() {
	return sal;
}
public void setSal(double sal) {
	this.sal = sal;
}




}
