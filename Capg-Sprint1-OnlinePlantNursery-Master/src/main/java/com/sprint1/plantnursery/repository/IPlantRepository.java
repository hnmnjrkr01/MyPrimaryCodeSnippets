package com.sprint1.plantnursery.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sprint1.plantnursery.entity.Plant;

/*Repository Class for Plant
Author : Disha Kale
*/

	@Repository
	public interface IPlantRepository extends JpaRepository<Plant, Integer>{
		
		Optional<Plant> findByname(String name);
		
		List<Plant> findByTypeOfPlant(String typeOfPlant);


}
