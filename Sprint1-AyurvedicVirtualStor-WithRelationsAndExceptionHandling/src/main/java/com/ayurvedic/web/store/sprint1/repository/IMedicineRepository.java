package com.ayurvedic.web.store.sprint1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ayurvedic.web.store.sprint1.entities.AyurOrder;
import com.ayurvedic.web.store.sprint1.entities.Medicine;

@Repository
public interface IMedicineRepository extends JpaRepository<Medicine, Integer>{

	Optional<Medicine> findById(int medicineId);

}
