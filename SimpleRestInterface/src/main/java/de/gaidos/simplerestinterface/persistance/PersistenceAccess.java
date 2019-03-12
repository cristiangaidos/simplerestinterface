package de.gaidos.simplerestinterface.persistance;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.gaidos.simplerestinterface.model.Persons;
import de.gaidos.simplerestinterface.utils.CSVUtils;

public class PersistenceAccess {
	
	private static final String CSV_FILE_PATH = new File(
			PersonsDao.class.getClassLoader().getResource("input.csv").getFile()).getPath();

	
	public static List<Persons> getPersonsFromPersistence() {
		return csvLineToPersonList(CSVUtils.readCSVFile(CSV_FILE_PATH));
	}
	
	public static boolean persistPerson(Persons person) {
		try {
		StringBuilder sb = new StringBuilder();
		sb.append(person.getLastName()).append(CSVUtils.DEFAULT_SEPARATOR);
		sb.append(person.getFirstName()).append(CSVUtils.DEFAULT_SEPARATOR);
		sb.append(person.getZipCode()).append(" ").append(person.getCity()).append(CSVUtils.DEFAULT_SEPARATOR);
		sb.append(ColorTypes.valueOf(person.getColor()).getColorCode());
		CSVUtils.writeCSVFile(CSV_FILE_PATH, sb.toString());
		}catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}
	
	private static List<Persons> csvLineToPersonList(List<String> lines) {
		List<Persons> personList = new ArrayList<Persons>();
		int idCount = 0;
		for (String line : lines) {
			Persons person = csvLineToPersonConvertion(idCount++, line);
			if(person != null) {
				personList.add(person);
			}
		}
		return personList;
	}

	private static Persons csvLineToPersonConvertion(int lineNumber, String lineContent) {
		String[] line = lineContent.split(CSVUtils.DEFAULT_SEPARATOR);

		if (line == null || line.length != 4) {
			// handle error
			return null;
		} else {
			String[] cityZipSplit = line[2].trim().split(" ");

			if (cityZipSplit.length != 2) {
				// treat error
				return null;
			}

			if (line[3].trim().isEmpty()) {
				// treat error
				return null;
			}

			String color = ColorTypes.NOT_DEFINED.name();
			try {
				color = ColorTypes.getColorByCode(Integer.parseInt(line[3].trim())).name();
			} catch (NumberFormatException e) {
				// TODO: handle exception
				return null;
			}

			return new Persons(lineNumber, line[0], line[1], cityZipSplit[0], cityZipSplit[1], color);
		}
	}

}
