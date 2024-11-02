package com.cg.medicalapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.medicalapp.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{

}
