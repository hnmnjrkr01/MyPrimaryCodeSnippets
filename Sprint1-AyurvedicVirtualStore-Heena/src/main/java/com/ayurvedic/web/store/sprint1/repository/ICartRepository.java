package com.ayurvedic.web.store.sprint1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayurvedic.web.store.sprint1.entities.Cart;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Integer>{

		Optional<Cart> findByCartId(int cartId);
}
