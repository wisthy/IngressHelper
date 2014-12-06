package be.shoktan.IngressHelper.models;

import be.shoktan.IngressHelper.exception.ValidationException;

public interface IValidable2 {
	/**
	 * try to validate the object to ensure it follows all the defined rules
	 */
	public Validation validate();
}
