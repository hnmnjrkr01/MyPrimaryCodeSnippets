package com.sprint1.plantnursery.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sprint1.plantnursery.entity.Seed;


/*Controller Class for Seed Controller
Created By : Smita Pradhan 
*/

public interface ISeedRepository extends JpaRepository<Seed, Integer>{
	
	Optional<Seed> findByName(String name);
	List<Seed> findByTypeOfSeed(String typeOfSeed);

}