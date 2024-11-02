package com.sprint1.plantnursery.repository;

/*Controller Class for Customer Controller
Author : Nikhil Bandgad
*/

import org.springframework.stereotype.Repository;

import com.sprint1.plantnursery.entity.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface IAdminRepository extends JpaRepository<Admin, Integer>{
	public Admin findByAdminId(String adminId);
}
