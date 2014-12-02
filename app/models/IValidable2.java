package models;

import be.shoktan.IngressFieldOptimizer.exception.ValidationException;

public interface IValidable2 {
	/**
	 * try to validate the object to ensure it follows all the defined rules
	 */
	public Validation validate();
}
