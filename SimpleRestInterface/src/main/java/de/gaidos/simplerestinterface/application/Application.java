
package de.gaidos.simplerestinterface.application;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.gaidos.simplerestinterface.model.Persons;
import de.gaidos.simplerestinterface.persistance.PersonsDao;

@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    //    SpringApplication.run(Application.class, args);

    PersonsDao dao = new PersonsDao();

    for (Persons p : dao.getAll()) {
      System.out.println(p.getLastName());
    }

  }
}