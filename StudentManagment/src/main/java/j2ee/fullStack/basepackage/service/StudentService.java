package j2ee.fullStack.basepackage.service;

import java.util.List;

import j2ee.fullStack.basepackage.model.Student;

public interface StudentService {
	
	public Student addStudent(Student student);
	public List<Student> showAllStudents();

}
