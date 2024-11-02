package com.ayurvedic.web.store.sprint1.service;

import java.util.List;

import com.ayurvedic.web.store.sprint1.entities.Medicine;

public interface IMedicineService {

	public Medicine addMedicine(Medicine medicine);
	public List<Medicine> showAllMedicine();
	
	public Medicine viewMedicine(int medicineId);
	public Medicine updateMedicine( Medicine medicine);
	public Medicine deleteMedicine(int medicineId);
	public List<Medicine> availableQuantity(String medicineName);
	
}
