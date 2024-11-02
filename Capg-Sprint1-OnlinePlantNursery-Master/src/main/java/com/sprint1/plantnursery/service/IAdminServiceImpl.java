package com.sprint1.plantnursery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.plantnursery.exceptions.UserNotFoundException;
import com.sprint1.plantnursery.entity.Admin;
import com.sprint1.plantnursery.entity.Plant;
import com.sprint1.plantnursery.repository.IAdminRepository;

/*Controller Class for Customer Controller
Author : Nikhil Bandgad
*/

@Service
@Transactional
public class IAdminServiceImpl implements IAdminService {
	@Autowired
	private IAdminRepository iadminrepository;

	@Override
	public Admin validateAdmin(String adminId) throws UserNotFoundException {
		Admin admin_info = iadminrepository.findByAdminId(adminId);
		if (admin_info == null)
			throw new UserNotFoundException("User Not Found");
		return admin_info;
	}
	
	@Override
	public Admin addAdmin(Admin admin) {
		Admin admin_info = iadminrepository.save(admin);
		return admin_info;
	}
	
	@Override
	public Admin removeAdmin(Admin admin) {
		iadminrepository.delete(admin);
		return admin;
	}
	
	@Override
	public List<Admin> getAllUsers() {
		return iadminrepository.findAll();
	}
}
