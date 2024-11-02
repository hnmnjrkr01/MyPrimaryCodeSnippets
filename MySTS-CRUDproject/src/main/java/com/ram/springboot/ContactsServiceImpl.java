package com.ram.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactsServiceImpl implements ContactsServiceI{

	@Autowired
	ContactsDAOI contactDAO;
	
	@Override
	public Contacts createContact(Contacts contact) {
		return contactDAO.createContact(contact);
	}
	
	

}
