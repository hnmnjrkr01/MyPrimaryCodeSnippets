package com.sprint1.plantnursery.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.plantnursery.entity.Plant;
import com.sprint1.plantnursery.exceptions.PlantIdNotFoundException;
import com.sprint1.plantnursery.repository.IPlantRepository;

/*Service Class for Plant
Author : Disha Kale
*/

@Service 
public class PlantServiceImpl implements IPlantService
{
	@Autowired
	private IPlantRepository plantRepo;
	
	@Override
	public Plant addNewPlant(Plant plant) {
		plantRepo.save(plant);	
		return plant;
	}
	
	@Override
	public Plant updatePlant(Plant plant, int id){
		Optional<Plant> plantOptional = plantRepo.findById(id);
		if(plantOptional.isPresent()) {
			Plant plantToBeUpdated = plantOptional.get();
			plantToBeUpdated.setBloomTime(plant.getBloomTime());
			plantToBeUpdated.setName(plant.getName());
			plantToBeUpdated.setPlantCost(plant.getPlantCost());
			plantToBeUpdated.setPlantDescription(plant.getPlantDescription());
			plantToBeUpdated.setDifficultyLevel(plant.getDifficultyLevel());
			plantToBeUpdated.setPlantHeight(plant.getPlantHeight());
			plantToBeUpdated.setMedicinalOrCulinaryUse(plant.getMedicinalOrCulinaryUse());
			plantToBeUpdated.setPlantSpread(plant.getPlantSpread());
			plantToBeUpdated.setPlantsStock(plant.getPlantsStock());
			plantToBeUpdated.setTemparature(plant.getTemparature());
			plantToBeUpdated.setTypeOfPlant(plant.getTypeOfPlant());
			plantRepo.save(plantToBeUpdated);
			return plantToBeUpdated;
			
		}
		return plantOptional.orElseThrow(() -> new PlantIdNotFoundException("Plant Not Found"));
	}
	
	@Override
	public Plant deletePlant(int plantId){
		
		Optional<Plant> plantOptional = plantRepo.findById(plantId);
		
		if(plantOptional.isPresent()) {
			Plant here = plantOptional.get();
			plantRepo.delete(here);
			return here;
		}
		return plantOptional.orElseThrow(() -> new PlantIdNotFoundException("Plant Not Found"));
	}
	
	@Override
	public Plant getPlant(int plantId){
		Optional<Plant> plantOptional = plantRepo.findById(plantId);
		if(plantOptional.isPresent()) {
			
			return plantRepo.findById(plantId).get();
		}
		
		return plantOptional.orElseThrow(() -> new PlantIdNotFoundException("Plant Not Found"));
	}
	
	
	@Override
	public List<Plant> getAllPlants() {
		return plantRepo.findAll();
	}
}
	
	