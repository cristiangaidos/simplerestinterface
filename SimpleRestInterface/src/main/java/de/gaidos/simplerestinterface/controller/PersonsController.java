
package de.gaidos.simplerestinterface.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.gaidos.simplerestinterface.model.Persons;
import de.gaidos.simplerestinterface.service.PersonService;

@RestController
@RequestMapping(value = "/simplerestinterface", method = RequestMethod.GET)
public class PersonsController {

  @Autowired
  PersonService ps;

  @RequestMapping(value = "/persons")
  public List<Persons> getAllPerson() {
    return ps.getAllPerson();
  }

  @RequestMapping(method = RequestMethod.POST, value = "/addperson")
  public void addPerson(@RequestBody Persons person) {
    ps.save(person);
  }

  @RequestMapping(value = "/persons/{id}", method = RequestMethod.GET)
  public Persons getPersonsById(@PathVariable(value = "id") Integer userId) {
    return ps.getPersonsById(userId);
  }

  @RequestMapping(value = "/persons/color/{color}", method = RequestMethod.GET)
  public List<Persons> getPersonsById(@PathVariable(value = "color") String color) {
    return ps.getPersonsByColorCode(color);
  }

}
