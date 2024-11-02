package com.cg.jpastart.entities;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="students")
public class Student implements Serializable {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private int studentId;
	private String name;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
