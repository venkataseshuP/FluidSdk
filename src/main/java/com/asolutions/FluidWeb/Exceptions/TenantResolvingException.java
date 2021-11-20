package com.asolutions.FluidWeb.Exceptions;

public class TenantResolvingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TenantResolvingException(Throwable throwable, String message) {
		super(message, throwable);
	}
}
