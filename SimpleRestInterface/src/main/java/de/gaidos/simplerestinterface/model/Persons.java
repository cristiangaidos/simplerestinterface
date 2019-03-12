
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

  @Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((city == null) ? 0 : city.hashCode());
	result = prime * result + ((color == null) ? 0 : color.hashCode());
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + (int) (id ^ (id >>> 32));
	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
	result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Persons other = (Persons) obj;
	if (city == null) {
		if (other.city != null)
			return false;
	} else if (!city.equals(other.city))
		return false;
	if (color == null) {
		if (other.color != null)
			return false;
	} else if (!color.equals(other.color))
		return false;
	if (firstName == null) {
		if (other.firstName != null)
			return false;
	} else if (!firstName.equals(other.firstName))
		return false;
	if (id != other.id)
		return false;
	if (lastName == null) {
		if (other.lastName != null)
			return false;
	} else if (!lastName.equals(other.lastName))
		return false;
	if (zipCode == null) {
		if (other.zipCode != null)
			return false;
	} else if (!zipCode.equals(other.zipCode))
		return false;
	return true;
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
