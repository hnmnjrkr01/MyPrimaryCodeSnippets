package com.sprint1.plantnursery.service;

import org.springframework.data.util.ReflectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import com.sprint1.plantnursery.entity.Plant;
import com.sprint1.plantnursery.entity.Seed;
import com.sprint1.plantnursery.exceptions.SeedIdNotFoundException;
import com.sprint1.plantnursery.repository.ISeedRepository;

/*Controller Class for Seed Controller
Created By : Smita Pradhan 
*/

@Service
@Transactional
public class SeedServiceImpl implements ISeedService{
	
	
	@Autowired
	private ISeedRepository seedRepo;

	@Override
	public Seed addSeed(Seed seed) 
	{
		return seedRepo.save(seed);
	}
	
	
	@Override
	public Seed updateSeed(Seed seed, int id) {
		
		Optional<Seed> seedOptional = seedRepo.findById(id);
		if(seedOptional.isPresent()) {
			Seed seedToBeUpdated = seedOptional.get();
			seedToBeUpdated.setBloomTime(seed.getBloomTime());
			seedToBeUpdated.setCommanName(seed.getCommanName());
			seedToBeUpdated.setSeedsCost(seed.getSeedsCost());
			seedToBeUpdated.setSeedsDescription(seed.getSeedsDescription());
			seedToBeUpdated.setDifficultyLevel(seed.getDifficultyLevel());
			seedToBeUpdated.setSeedsStock(seed.getSeedsStock());
			seedToBeUpdated.setWatering(seed.getWatering());
			seedToBeUpdated.setTypeOfSeeds(seed.getTypeOfSeeds());
			seedToBeUpdated.setSeedsPerPacket(seed.getSeedsPerPacket());
			seedToBeUpdated.setTemprature(seed.getTemprature());
			seedRepo.save(seedToBeUpdated);
			return seedToBeUpdated;
		}
		return seedOptional.orElseThrow(() -> new SeedIdNotFoundException("Seed Not Found"));

}

	
	@Override
	public Seed deleteSeedById(int id) throws SeedIdNotFoundException {
		Optional<Seed> seedOptional = seedRepo.findById(id);		
		if(seedOptional.isPresent()) {
			seedRepo.delete(seedOptional.get());
		}
		return seedOptional.orElseThrow(()->new SeedIdNotFoundException("Invalid seed id...Cannot delete"));	
	}
	
	@Override
	public Seed getSeed(int id) throws SeedIdNotFoundException{
		Optional<Seed> seedOptional = seedRepo.findById(id);
		return seedOptional.orElseThrow(() -> new SeedIdNotFoundException("Seed Not Found...Invalid ID"));
	}

	

	
	@Override
	public List<Seed> getAllSeeds() {
		return seedRepo.findAll();
	}

	
}
