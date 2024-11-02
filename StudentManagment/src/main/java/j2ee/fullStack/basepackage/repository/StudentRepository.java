package j2ee.fullStack.basepackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import j2ee.fullStack.basepackage.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
