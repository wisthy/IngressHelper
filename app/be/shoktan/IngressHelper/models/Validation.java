package be.shoktan.IngressHelper.models;

import java.util.HashSet;
import java.util.Set;

import be.shoktan.IngressHelper.exception.ValidationException;

/**
 * Utility model class representing a validation process.
 * It contains all the errors detected during validation if any.
 * @author wisthler
 *
 */
public class Validation {
	private Set<ValidationException> errors = new HashSet<>();
	
	/**
	 * check if the validation succeeded or not
	 * @return true if the validation succeeded, false elsewhere
	 */
	public boolean isValid(){
		return errors.size() == 0;
	}

	/**
	 * method to add an validation error
	 * @param exception the error to add 
	 */
	public void add(ValidationException exception) {
		errors.add(exception);
	}
	
	
}
