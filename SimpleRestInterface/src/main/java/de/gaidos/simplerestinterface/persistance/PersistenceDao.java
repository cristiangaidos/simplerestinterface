
package de.gaidos.simplerestinterface.persistance;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface PersistenceDao<T> {

  public ResponseEntity<T> get(long id);

  public List<T> getAll();

  public void save(T t);

  public void update(T t, String[] params);

  public void delete(T t);

}
