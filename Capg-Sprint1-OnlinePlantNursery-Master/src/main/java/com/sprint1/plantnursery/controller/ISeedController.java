package com.sprint1.plantnursery.controller;

import java.util.List;
import java.util.Map;
import com.sprint1.plantnursery.service.ISeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.plantnursery.entity.Plant;
import com.sprint1.plantnursery.entity.Seed;
/*Controller Class for Seed Controller
Created By : Smita Pradhan 
*/

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/seeds")
public class ISeedController {
	
	@Autowired
	private ISeedService seedService;
	
	
	/****************************
	 * Method: addseed 
	 * Description: It is used to add into the seed table 
	 * @returns seed It returns String type message
	 * @PostMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 ****************************/
	
	@PostMapping("/addSeeds")
	public ResponseEntity<Seed> addSeed( @RequestBody Seed seed){
		seedService.addSeed(seed);
		return new ResponseEntity<Seed>(seed,HttpStatus.CREATED);
	}
	
	/****************************
	 * Method: Update seed by Id
	 * Description: It is used to update  in seed table
	 * @returns seed It returns String type message 
	 * @PutMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type. 
	 * 
	 ****************************/	
	
	@PutMapping("/updateseeds/{id}")
	public ResponseEntity<Seed> updateSeed(@RequestBody Seed seed, @PathVariable int id) {
		// logger.trace("updating the whole plant having id "+ id);  
		seedService.updateSeed(seed, id);
		return new ResponseEntity<Seed>(seed, HttpStatus.ACCEPTED);
	}
	
	/****************************
	 * Method: deleteSeed by Id
	 * Description: It is used to remove the items in the Seed table
	 * @returns Seed It returns String type message 
	 * @DeleteMapping: It is used to handle the HTTP Delete requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * 
	 ****************************/
	
	@DeleteMapping("/deleteseeds/{id}")
	public ResponseEntity<Seed> deleteSeedById(@PathVariable int id){
		return new ResponseEntity<Seed>(seedService.deleteSeedById(id),HttpStatus.OK);
	}
	
	
	/****************************
	 * Method: viewSeed by SeedId
	 * Description: It is used to view all Seed items in Seed table
	 * @returns Seed It returns Seed with details
	 * @GetMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.   
	 * 
	 ****************************/
	
	@GetMapping("/getseeds/{id}")
	public ResponseEntity<Seed> getSeed(@PathVariable int id){
		return new ResponseEntity<Seed>(seedService.getSeed(id),HttpStatus.OK);	
	}
	
//	@GetMapping("/seeds/name/{name}")
//	public ResponseEntity<Seed> getSeed(@PathVariable String name) {
//		return new ResponseEntity<Seed>(seedService.getSeed(name),HttpStatus.ACCEPTED);	
//	}
	
	/****************************
	 * Method: viewAllSeed
	 * Description: It is used to view all Seed items in Seed table
	 * @returns Seed It returns Seed with details
	 * @GetMapping: It is used to handle the HTTP POST requests matched with given URI expression.
	 * @RequestBody: It used to bind the HTTP request/response body with a domain object in method parameter or return type.
	 * 
	 ****************************/
	
	@GetMapping("/getSeeds")
	public ResponseEntity<List<Seed>> viewAllSeeds() {
		//logger.trace("fetching all the plants");
		return new ResponseEntity<List<Seed>>(seedService.getAllSeeds(), HttpStatus.OK);
	}

	
//	@GetMapping("/seeds/typeOfSeed/{typeOfSeed}")
//	public ResponseEntity<List<Seed>> getSeeds(@PathVariable String typeOfSeed){
//		List<Seed> seedList = seedService.getSeeds(typeOfSeed);
//		return new ResponseEntity<List<Seed>>(seedList,HttpStatus.ACCEPTED);
//	}
	

}
