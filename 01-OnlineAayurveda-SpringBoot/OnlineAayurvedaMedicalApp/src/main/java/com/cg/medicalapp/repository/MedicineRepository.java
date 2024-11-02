package com.cg.medicalapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.medicalapp.entity.Category;
import com.cg.medicalapp.entity.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine,Integer>{

	int countByMedicineName(String medicineName);

	@Query("select m from Medicine m where m.medicineName=:name")
	List<Medicine> findByMedicineName(@Param("name") String medicineName);

	@Query("select m from Medicine m where m.category=:category")
	List<Medicine> findMedicineInCategory(@Param("category") Category category);


}
