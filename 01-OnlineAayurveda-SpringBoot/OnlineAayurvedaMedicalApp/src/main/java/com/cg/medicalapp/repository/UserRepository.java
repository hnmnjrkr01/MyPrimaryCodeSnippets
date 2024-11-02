package com.cg.medicalapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.medicalapp.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>  {
	
}
