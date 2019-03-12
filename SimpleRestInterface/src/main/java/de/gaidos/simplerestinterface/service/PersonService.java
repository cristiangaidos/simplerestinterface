package de.gaidos.simplerestinterface.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import de.gaidos.simplerestinterface.model.Persons;
import de.gaidos.simplerestinterface.persistance.PersonsDao;

@Service
@ComponentScan({"de.gaidos.simplerestinterface.persistance"})
public class PersonService {
	
	@Autowired
	PersonsDao dao;

	public PersonService() {

	}

	public List<Persons> getAllPerson() {
		return dao.getAll();
	}

	public Persons getPersonsById(Integer userId) {
		return dao.get(userId);
	}
	
	public List<Persons> getPersonsByColorCode(String color) {
		return dao.getPersonsByColorCode(color);
	}
	
	public void save(Persons person) {
		dao.save(person);
	}

}
