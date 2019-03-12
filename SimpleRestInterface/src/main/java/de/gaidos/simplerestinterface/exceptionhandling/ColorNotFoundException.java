package de.gaidos.simplerestinterface.exceptionhandling;

public class ColorNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -859585882744992623L;

	public ColorNotFoundException(String exception) {
	    super(exception);
	  }

	}