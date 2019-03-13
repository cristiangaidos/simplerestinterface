
package de.gaidos.simplerestinterface.persistance;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import de.gaidos.simplerestinterface.model.Persons;

@Repository
@ConditionalOnProperty(name = "useMySQLRepo")
public interface PersonsRepository extends JpaRepository<Persons, Integer> {

  // custom query to search persons by color code
  List<Persons> findByColorCode(int colorCode);

}
