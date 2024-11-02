package com.cg.medicalapp.service;

import java.util.List;

import com.cg.medicalapp.entity.Medicine;
import com.cg.medicalapp.exception.NoSuchCategoryException;
import com.cg.medicalapp.exception.RecordNotFoundException;

public interface MedicineService {
	
		public Medicine addMedicine(Medicine medicine);
		public Medicine viewMedicine(Medicine medicine);
		public Medicine updateMedicine(Medicine medicine) throws RecordNotFoundException;
		public Medicine deleteMedicine(Medicine medicine) throws RecordNotFoundException;
		public List<Medicine> showAllMedicine();
		public List<Medicine> showMedicineByCategory(int categoryId) throws NoSuchCategoryException;
		public long availableQuantity(String medicineName);
		
	}
