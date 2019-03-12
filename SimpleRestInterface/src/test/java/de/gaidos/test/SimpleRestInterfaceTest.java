package de.gaidos.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import de.gaidos.simplerestinterface.Application;
import de.gaidos.simplerestinterface.model.Persons;
import de.gaidos.simplerestinterface.service.PersonService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class SimpleRestInterfaceTest {

	@Autowired
	private PersonService personService;

	@Test
	public void testGetAllPersons() throws Exception {

		List<Persons> persons = new ArrayList<>();
		persons.add(new Persons(0, "Muller", "Hans", "67742", "Lauterecken", "BLAU"));
		persons.add(new Persons(1, "Petersen", "Peter", "18923", "Stratss", "GRUN"));
		persons.add(new Persons(2, "Johnson", "John", "23423", "Atarun", "LILA"));

		List<Persons> allPerson = personService.getAllPerson();

		assertTrue(allPerson.size() == 3);
		assertEquals(allPerson, persons);

	}

	@Test
	public void testGetAllPersonsWithColor() throws Exception {

		List<Persons> persons = new ArrayList<>();
		persons.add(new Persons(0, "Muller", "Hans", "67742", "Lauterecken", "BLAU"));

		List<Persons> allPerson = personService.getPersonsByColorCode("1");

		assertTrue(allPerson.size() == 1);
		assertEquals(allPerson, persons);
		
		persons.clear();
		persons.add(new Persons(1, "Petersen", "Peter", "18923", "Stratss", "GRUN"));
		allPerson = personService.getPersonsByColorCode("2");

		assertTrue(allPerson.size() == 1);
		assertEquals(allPerson, persons);
		
		persons.clear();
		persons.add(new Persons(2, "Johnson", "John", "23423", "Atarun", "LILA"));
		allPerson = personService.getPersonsByColorCode("3");

		assertTrue(allPerson.size() == 1);
		assertEquals(allPerson, persons);

	}

}
