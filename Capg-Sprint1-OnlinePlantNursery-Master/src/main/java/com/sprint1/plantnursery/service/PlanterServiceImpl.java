package com.sprint1.plantnursery.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.plantnursery.entity.Planter;
import com.sprint1.plantnursery.exceptions.ResourceNotFoundException;
import com.sprint1.plantnursery.exceptions.InsufficientStockException;
import com.sprint1.plantnursery.repository.IPlanterRepository;

/*Controller Class for Planter Controller
Created By: Pruthvi Tilwankar
*/

@Service
@Transactional
public class PlanterServiceImpl implements IPlanterService {

	@Autowired
	private IPlanterRepository iplanterrepository;
	

	@Override
	public Planter addPlanter(Planter planter) {
		if (planter.getPlanterId() == 0)
			return iplanterrepository.save(planter);
		Optional<Planter> optionalPlanter = iplanterrepository.findById(planter.getPlanterId()); 
		if (optionalPlanter.isPresent()) {
			Planter p = optionalPlanter.get();
			p.setPlanterStock(p.getPlanterStock()+1);
			return iplanterrepository.save(p);
		}else {
			return iplanterrepository.save(planter);
		}
	}

	@Override
	public Planter deletePlanter(int planterId) {
		Optional<Planter> optionalPlanter = iplanterrepository.findById(planterId); 
		if (optionalPlanter.isPresent()) {
			Planter p = optionalPlanter.get();
			p.setPlanterStock(p.getPlanterStock()-1);
			if (p.getPlanterStock() < 0)
				throw new InsufficientStockException("Stock is insufficient");
			iplanterrepository.save(p);
		}
		return optionalPlanter.orElseThrow(() -> new ResourceNotFoundException("The planter with given id does not exist"));
	}
	
	@Override
	public Planter getPlanter(int id) {
		Optional<Planter> optionalPlanter =  iplanterrepository.findById(id); 
		return optionalPlanter.orElseThrow(() -> new ResourceNotFoundException("Planter does not exist with given id"));
	}
	
	@Override
	public Planter updatePlanter(Planter planter) {
		Optional<Planter> optionalPlanter = iplanterrepository.findById(planter.getPlanterId());  
		if (optionalPlanter.isPresent()) {
			iplanterrepository.save(planter);
		}
		return iplanterrepository.findById(planter.getPlanterId()).orElseThrow(() -> new ResourceNotFoundException("Planter with given id does not exist. So, update can not be done"));
	}

	@Override
	public List<Planter> viewAllPlanters() {
		return iplanterrepository.findAll();
	}

	@Override
	public List<Planter> viewAllPlanters(double minCost, double maxCost) {
		List<Planter> allPlanters = iplanterrepository.findAll();
		List<Planter> requiredPlanters = allPlanters.stream().filter((p) -> p.getPlanterCost() >minCost && p.getPlanterCost() < maxCost).collect(Collectors.toList());
		return requiredPlanters;
	}

}
