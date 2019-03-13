
package de.gaidos.simplerestinterface.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import de.gaidos.simplerestinterface.model.Persons;
import de.gaidos.simplerestinterface.persistance.PersonsDao;
import de.gaidos.simplerestinterface.persistance.PersonsRepository;

@Service
@ComponentScan({ "de.gaidos.simplerestinterface.persistance" })
public class PersonService {

  @Autowired
  PersonsDao dao;

  @Autowired(required = false)
  PersonsRepository repo;

  @Value(value = "${useMySQLRepo}")
  boolean useMySQLRepo;

  public PersonService() {

  }

  public List<Persons> getAllPerson() {
    if (useMySQLRepo) {
      return repo.findAll();
    }
    return dao.getAll();
  }

  public Persons getPersonsById(Integer userId) {
    if (useMySQLRepo) {
      return repo.findById(userId).get();
    }
    return dao.get(userId);
  }

  public List<Persons> getPersonsByColorCode(String color) {
    if (useMySQLRepo) {
      return repo.findByColorCode(Integer.parseInt(color));
    }
    return dao.getPersonsByColorCode(color);
  }

  public void save(Persons person) {
    if (useMySQLRepo) {
      repo.saveAndFlush(person);
    }
    dao.save(person);
  }

}
