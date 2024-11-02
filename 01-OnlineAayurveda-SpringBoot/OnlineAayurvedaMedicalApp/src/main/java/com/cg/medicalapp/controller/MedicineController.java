package com.cg.medicalapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.medicalapp.entity.Cart;
import com.cg.medicalapp.entity.Medicine;
import com.cg.medicalapp.exception.NoSuchCategoryException;
import com.cg.medicalapp.exception.RecordExistsException;
import com.cg.medicalapp.exception.RecordNotFoundException;
import com.cg.medicalapp.service.CartService;
import com.cg.medicalapp.service.MedicineService;

@CrossOrigin("*")
@RestController
public class MedicineController {
	
	@Autowired
    private MedicineService medicineService;
	
	@Autowired
	private CartService cartService;

    @PostMapping(value = {"/api/v1/medicine"})
    public ResponseEntity<String> addMedicine(@Valid @RequestBody Medicine medicine) throws RecordExistsException {

    	medicineService.addMedicine(medicine);
        return new ResponseEntity<>("Medicine added Sucessfully!", HttpStatus.CREATED);
    }
    
    @GetMapping("/api/v1/medicine/{medicineId}")
   	public ResponseEntity<Medicine> viewMedicine(@Valid @PathVariable("medicineId") int medicineId) {
    	Medicine medicine = new Medicine();
    	medicine.setMedicineId(medicineId);
		Medicine medicine1 = medicineService.viewMedicine(medicine);
		
		return new ResponseEntity<>(medicine1, HttpStatus.OK);
   	}
    
    @GetMapping(value = {"/api/v1/medicines"})
    public ResponseEntity<List<Medicine>> showAllMedicine() {

        List<Medicine> allMedicine = medicineService.showAllMedicine();
        return new ResponseEntity<>(allMedicine,HttpStatus.OK);
    }
    
    @DeleteMapping(value = {"/api/v1/medicine/{medicineId}"})
    public ResponseEntity<String> removeMedicine(@Valid @PathVariable("medicineId") int medicineId) throws RecordNotFoundException {

    	Medicine medicine = new Medicine();
    	medicine.setMedicineId(medicineId);
        medicineService.deleteMedicine(medicine);
        return new ResponseEntity<>("Medicine has been deleted!!", HttpStatus.ACCEPTED);
    }
    
    @PutMapping("/api/v1/medicine")
	public ResponseEntity<Medicine> updateMedicine(@Valid @RequestBody Medicine medicine)
			throws RecordNotFoundException {

		medicine = medicineService.updateMedicine(medicine);
		return new ResponseEntity<>(medicine, HttpStatus.OK);
	}
    
    @PutMapping("/api/v1/Cart/{cartId}/{medicineId}")
    public ResponseEntity<Cart> addToCart(@PathVariable("cartId") int cartId,@PathVariable("medicineId") int medicineId) throws RecordNotFoundException
    {
		return new ResponseEntity<>(cartService.addToCart(cartId,medicineId), HttpStatus.OK);
    }
    
	@GetMapping("/api/v1/Category/{id}")
	public ResponseEntity<List<Medicine>> showByCategory(@PathVariable("id") int id) throws NoSuchCategoryException{
			return new ResponseEntity<>(medicineService.showMedicineByCategory(id), HttpStatus.OK);
	}

}
