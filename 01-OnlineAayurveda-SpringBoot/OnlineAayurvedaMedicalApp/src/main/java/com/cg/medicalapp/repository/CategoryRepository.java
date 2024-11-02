package com.cg.medicalapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.medicalapp.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}