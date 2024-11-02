package j2ee.fullStack.basepackage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import j2ee.fullStack.basepackage.model.Student;
import j2ee.fullStack.basepackage.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> showAllStudents() {
		return studentRepository.findAll();
	}
	
	

}
