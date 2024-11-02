package com.ram.springboot;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ContactDAOImpl implements ContactsDAOI {

	
	@PersistenceContext
	private EntityManager emanager;
	
	@Override
	public Contacts createContact(Contacts contact) {

		return emanager.merge(contact);
	}
	

}
