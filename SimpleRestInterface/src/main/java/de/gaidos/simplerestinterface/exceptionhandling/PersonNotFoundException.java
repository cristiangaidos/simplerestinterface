package de.gaidos.simplerestinterface.exceptionhandling;

public class PersonNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -8595858827144992623L;

	public PersonNotFoundException(String exception) {
	    super(exception);
	  }

	}