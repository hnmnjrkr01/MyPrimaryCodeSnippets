package com.cg.medicalapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.medicalapp.entity.Category;
import com.cg.medicalapp.entity.Medicine;
import com.cg.medicalapp.exception.NoSuchCategoryException;
import com.cg.medicalapp.exception.RecordExistsException;
import com.cg.medicalapp.exception.RecordNotFoundException;
import com.cg.medicalapp.repository.CategoryRepository;
import com.cg.medicalapp.repository.MedicineRepository;

@Service
public class MedicineServiceImpl implements MedicineService{
	
	@Autowired
    private MedicineRepository medicineRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Medicine addMedicine(Medicine medicine) throws RecordExistsException{
		Optional<Medicine> medicine1 = medicineRepository.findById(medicine.getMedicineId());
		if(medicine1.isPresent()) {

			throw new RecordExistsException("Medicine already found");
		}
		medicine = medicineRepository.save(medicine);
		return medicine;
		
	}

	@Override
	public Medicine viewMedicine(Medicine medicine) {
		Optional<Medicine> medicine1 = medicineRepository.findById(medicine.getMedicineId());
		if (!medicine1.isPresent())
		{
			throw new RecordNotFoundException("Medicine with id " + medicine.getMedicineId() + " not found");
		}
		return medicine1.get();
	}

	@Override
	public Medicine updateMedicine(Medicine medicine) throws RecordNotFoundException {
		Optional<Medicine> medicine1 = medicineRepository.findById(medicine.getMedicineId());
		
		if(!(medicine1.isPresent())) {
			throw new RecordNotFoundException("Medicine Not Found");
		}
			
//	if(medicineRepository.existsById(medicine.getMedicineId())) {
//			medicine = medicine1.get();
//			medicine = medicineRepository.save(medicine);
//		}
		medicine = medicineRepository.save(medicine);

		return medicine;
	}

	@Override
	public Medicine deleteMedicine (Medicine medicine) throws RecordNotFoundException {
		Optional<Medicine> medicine1 = medicineRepository.findById(medicine.getMedicineId());
		if(!medicine1.isPresent())
		{
			throw new RecordNotFoundException("Medicine Not Found");
		}

		medicine = medicine1.get();
		medicineRepository.delete(medicine);
		return medicine;
	}

	@Override
	public List<Medicine> showAllMedicine() throws RecordNotFoundException{
		List<Medicine> medicinelist = medicineRepository.findAll();
		
		if(medicinelist.isEmpty())
		{
			throw new RecordNotFoundException("No medicine found");
		}
		return medicinelist;
	}

	@Override
	public long availableQuantity(String medicineName) {
		return medicineRepository.countByMedicineName(medicineName);
	}

	@Override
	public List<Medicine> showMedicineByCategory(int categoryId) throws NoSuchCategoryException {
			Optional<Category> opt=categoryRepository.findById(categoryId);
			if(opt.isPresent()) {
				Category category=opt.get();
				return medicineRepository.findMedicineInCategory(category);
			} else {
				throw new NoSuchCategoryException("No category with id "+categoryId);
			}
	}
	
	

}
