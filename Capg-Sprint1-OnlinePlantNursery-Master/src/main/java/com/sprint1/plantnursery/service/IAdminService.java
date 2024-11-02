package com.sprint1.plantnursery.service;

import com.sprint1.plantnursery.exceptions.UserNotFoundException;

import java.util.List;

import com.sprint1.plantnursery.entity.Admin;

/*Controller Class for Customer Controller
Author : Nikhil Bandgad
*/

public interface IAdminService {
	public Admin addAdmin(Admin admin);
	public Admin removeAdmin(Admin admin);
	public Admin validateAdmin(String adminId)throws UserNotFoundException;
	public List<Admin> getAllUsers();
}
