
package de.gaidos.simplerestinterface.persistance;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import de.gaidos.simplerestinterface.exceptionhandling.ColorNotFoundException;
import de.gaidos.simplerestinterface.exceptionhandling.PersonNotFoundException;
import de.gaidos.simplerestinterface.model.Persons;

@Component
public class PersonsDao {
	
	public Persons get(Integer id) {
		List<Persons> personList = PersistenceAccess.getPersonsFromPersistence();
		if (id > 0 && id < personList.size()) {
			return personList.get(id - 1);
		}
		throw new PersonNotFoundException("Person not found!");
	}

	public List<Persons> getAll() {
		return PersistenceAccess.getPersonsFromPersistence();
	}

	public List<Persons> getPersonsByColorCode(String colorCode) {
		List<Persons> personsWithSpecifiedColorCode = new ArrayList<Persons>();
		int intColCode = 0;
		try {
			intColCode = Integer.parseInt(colorCode);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			throw new ColorNotFoundException("Color not found!");
		}
		List<Persons> personList = PersistenceAccess.getPersonsFromPersistence();
		for (Persons person : personList) {
			ColorTypes colorType = ColorTypes.valueOf(person.getColor());
			if (colorType != null && colorType.getColorCode() == intColCode) {
				personsWithSpecifiedColorCode.add(person);
			}
		}
		
		if(personsWithSpecifiedColorCode.isEmpty()) {
			throw new PersonNotFoundException("Persons not found for given color " + colorCode);
		}
		
		return personsWithSpecifiedColorCode;
	}

	public void save(Persons person) {
		PersistenceAccess.persistPerson(person);
	}

	public void update(Persons t, String[] params) {
		// TODO Auto-generated method stub
	}

	public void delete(Persons t) {
		// TODO Auto-generated method stub
	}


}
