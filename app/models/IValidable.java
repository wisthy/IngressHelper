package models;

import be.shoktan.IngressFieldOptimizer.exception.ValidationException;

@Deprecated
public interface IValidable {
	/**
	 * try to validate the object to ensure it follows all the defined rules
	 * @throws ValidationException if at least a rule is not respected
	 */
	@Deprecated
	public void validateOld() throws ValidationException;
}
