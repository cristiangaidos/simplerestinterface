
package de.gaidos.simplerestinterface.persistance;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

import de.gaidos.simplerestinterface.model.Persons;
import de.gaidos.simplerestinterface.utils.CSVUtils;

public class PersonsDao implements PersistenceDao<Persons> {

  private static final String CSV_FILE_PATH = new File(PersonsDao.class.getClassLoader().getResource("input.csv").getFile()).getPath();

  @Override
  public ResponseEntity<Persons> get(long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Persons> getAll() {
    return csvLineToPersonList(CSVUtils.readCSVFile(CSV_FILE_PATH));
  }

  @Override
  public void save(Persons t) {
    // TODO Auto-generated method stub

  }

  @Override
  public void update(Persons t, String[] params) {
    // TODO Auto-generated method stub
  }

  @Override
  public void delete(Persons t) {
    // TODO Auto-generated method stub
  }

  private static List<Persons> csvLineToPersonList(List<String> lines) {
    List<Persons> personList = new ArrayList<Persons>();
    int idCount = 0;
    for (String line : lines) {
      personList.add(csvLineToPersonConvertion(idCount++, line));
    }
    return personList;
  }

  private static Persons csvLineToPersonConvertion(int lineNumber, String lineContent) {
    String[] line = lineContent.split(CSVUtils.DEFAULT_SEPARATOR);

    if (line == null && line.length != 4) {
      // handle error
      return null;
    } else {
      String[] cityZipSplit = line[2].split(" ");
      return new Persons(lineNumber, line[0], line[1], cityZipSplit[0], cityZipSplit[1], line[3]);
    }
  }
}
