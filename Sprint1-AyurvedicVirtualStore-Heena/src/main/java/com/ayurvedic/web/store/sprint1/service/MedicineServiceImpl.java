package com.ayurvedic.web.store.sprint1.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayurvedic.web.store.sprint1.entities.Medicine;
import com.ayurvedic.web.store.sprint1.exceptions.MedicinerNotFoundexception;
import com.ayurvedic.web.store.sprint1.repository.IMedicineRepository;

@Service
@Transactional
public class MedicineServiceImpl implements IMedicineService{

	@Autowired
	IMedicineRepository medicineRepository;
	EntityManager eManager;
	
	@Override
	public Medicine addMedicine(Medicine medicine) {
		
		if(medicine.equals(null))
			throw new MedicinerNotFoundexception();	
		else {
		Medicine medicine_added = medicineRepository.save(medicine);
		return medicine_added;
		}
	}

	@Override
	public List<Medicine> showAllMedicine() {
		return medicineRepository.findAll();
	}

	@Override
	public Medicine viewMedicine(int medicineId) {
		// TODO Auto-generated method stub
		Optional<Medicine> medicinedToDelete = medicineRepository.findById(medicineId);
		
		if(medicinedToDelete.isPresent()){
			Medicine medicineDeleted = medicinedToDelete.get();
			medicineRepository.delete(medicineDeleted);
			return medicineDeleted;
		}
			
		return medicinedToDelete.orElseThrow(()-> 
					new MedicinerNotFoundexception("Medicine-Id your provided : "+medicineId+" is not found!"));
	}

	@Override
	public Medicine updateMedicine( Medicine medicine) {
		// TODO Auto-generated method stub
		Optional<Medicine> medicineToUpdate = medicineRepository.findById(medicine.getMedicineId());
		
		if(medicineToUpdate.isPresent()) {
				medicineRepository.save(medicine);
		}
		
		return medicineToUpdate.orElseThrow(()-> 
			new MedicinerNotFoundexception("Medicine to be updated with id : "+medicine.getMedicineId()+" is not Found!"));
	}

	@Override
	public Medicine deleteMedicine(int medicineId) {
		// TODO Auto-generated method stub
		Optional<Medicine> medicineToDelete = medicineRepository.findById(medicineId);
		
		if(medicineToDelete.isPresent()) {
			Medicine medicineDeleted = medicineToDelete.get();
			medicineRepository.delete(medicineDeleted);
			return medicineDeleted;
		}
		
		return medicineToDelete.orElseThrow(()->
				new MedicinerNotFoundexception("Medicine-Id to be deleted : "+medicineId+" is not Found!"));
	}

	@Override
	public List<Medicine> availableQuantity(String medicineName) {
		// TODO Auto-generated method stub
	
		String sqlString = "Select e from medicine where medicineName = "+medicineName;
		Query sqlQuery = eManager.createQuery(sqlString);
		
		List<Medicine> medicineQuantity = sqlQuery.getResultList();
		
		return medicineQuantity;
	}
	
	
	
	

}
