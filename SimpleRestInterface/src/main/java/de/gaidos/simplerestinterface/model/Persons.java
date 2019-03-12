
package de.gaidos.simplerestinterface.model;

public class Persons {

  private final long id;
  private final String lastName;
  private final String firstName;
  private final String zipCode;
  private final String city;
  private final String color;

  public Persons(long id, String lastName, String firstName, String zipCode, String city, String color) {
    this.id = id;
    this.lastName = lastName;
    this.firstName = firstName;
    this.zipCode = zipCode;
    this.city = city;
    this.color = color;
  }

  public long getId() {
    return id;
  }

  public String getLastName() {
    return lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getZipCode() {
    return zipCode;
  }

  public String getCity() {
    return city;
  }

  public String getColor() {
    return color;
  }

}
