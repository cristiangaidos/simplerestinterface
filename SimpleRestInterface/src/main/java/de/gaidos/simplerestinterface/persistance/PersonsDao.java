
package de.gaidos.simplerestinterface.persistance;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import de.gaidos.simplerestinterface.model.Persons;
import de.gaidos.simplerestinterface.utils.CSVUtils;

public class PersonsDao implements PersistenceDao<Persons> {

  private static final String CSV_FILE_PATH = "D:\\input.csv";

  @Override
  public Optional<Persons> get(long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Persons> getAll() {
    CSVUtils.readCSVFile(CSV_FILE_PATH);
    return null;
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

  private List<Persons> csvLineToPersonList(List<String> lines) {
    List<Persons> personList = new ArrayList<Persons>();
    int idCount = 0;
    for (String line : lines) {
      personList.add(csvLineToPersonConvertion(idCount++, line));
    }
    return personList;
  }

  private Persons csvLineToPersonConvertion(int lineNumber, String lineContent) {
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
