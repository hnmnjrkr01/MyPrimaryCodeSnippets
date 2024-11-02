package com.ayurvedic.web.store.sprint1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ayurvedic.web.store.sprint1.entities.Medicine;
import com.ayurvedic.web.store.sprint1.service.IMedicineService;

@RestController
@RequestMapping("/ayurvedaStore")
public class MedicineController {
	
	private static final HttpStatus HttpStatus = null;
	
	@Autowired
	IMedicineService medicineService;
	
	@PostMapping(path="/addMedicine")
	public ResponseEntity<Medicine> addMedicine(@RequestBody Medicine medicine){
		if(medicine.getMedicineId()==0)
			return new ResponseEntity("Invalid",HttpStatus.NOT_FOUND);
		
		Medicine medcineAdded = medicineService.addMedicine(medicine);
		return new ResponseEntity(medcineAdded,HttpStatus.OK);
	}

	@GetMapping(path="/showAllMedicine")
	public ResponseEntity<List<Medicine>> showAllMedicine( Medicine medicine){
		return new ResponseEntity<List<Medicine>>(medicineService.showAllMedicine(),HttpStatus.OK);
	}
	
	@PutMapping(path="/updateMedicine")
	public ResponseEntity<Medicine> updateMedicine(@RequestBody Medicine medicine){
		
		medicine = medicineService.updateMedicine(medicine);
		return new ResponseEntity<Medicine>(medicine, new HttpHeaders(),HttpStatus.OK );
	}
	
	@GetMapping(path="/viewMedicine/{medicineId}")
	public ResponseEntity<Medicine> viewMedicine(@PathVariable("medicineId") int medicineId){
		
		Medicine viewMedicine = medicineService.viewMedicine(medicineId);
		return new ResponseEntity<Medicine>(viewMedicine, new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteMedicine/{medicineId}")
	public ResponseEntity<Medicine> deleteMedicine(@PathVariable("medicineId") int medicineId){
		
		Medicine deletedMedicine = medicineService.deleteMedicine(medicineId);
		return new ResponseEntity<Medicine>(deletedMedicine, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/availableQuantity/{medicineName}")
	public ResponseEntity<List<Medicine>> availableQuantity(@PathVariable("medicineName") String medicineName ){
		List listOfMedNames = medicineService.availableQuantity(medicineName);
		return new ResponseEntity<List<Medicine>>(listOfMedNames,new HttpHeaders(), HttpStatus.OK);
	}
	
}
