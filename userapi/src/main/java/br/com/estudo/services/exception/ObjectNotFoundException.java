package br.com.estudo.services.exception;

public class ObjectNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5539541325410634776L;

	public ObjectNotFoundException(String message) {
		super(message);
	}
}
