package de.gaidos.simplerestinterface.exceptionhandling;

public class NotImplementedException extends RuntimeException {

	private static final long serialVersionUID = -859585882744992623L;

	public NotImplementedException(String exception) {
	    super(exception);
	  }

	}