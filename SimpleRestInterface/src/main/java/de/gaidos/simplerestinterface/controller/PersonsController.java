
package de.gaidos.simplerestinterface.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.gaidos.simplerestinterface.model.Persons;
import de.gaidos.simplerestinterface.persistance.PersistenceDao;

@RestController
public class PersonsController {

  @Autowired
  PersistenceDao<Persons> dao;

  @RequestMapping("persons")
  public List<Persons> getAllPerson() {
    return dao.getAll();
  }

  @GetMapping("/persons/{id}")
  public ResponseEntity<Persons> getPersonsById(@PathVariable(value = "id") Long userId) {
    return dao.get(userId);
  }

}
