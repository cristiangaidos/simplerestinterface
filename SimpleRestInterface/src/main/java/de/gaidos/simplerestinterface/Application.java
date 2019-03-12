package de.gaidos.simplerestinterface;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"de.gaidos.simplerestinterface.controller","de.gaidos.simplerestinterface.service","de.gaidos.simplerestinterface.persistance", "de.gaidos.test"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

//    PersonsDao dao = new PersonsDao();
//
//    for (Persons p : dao.getAll()) {
//      System.out.println(p.getLastName());
//    }

	}
}