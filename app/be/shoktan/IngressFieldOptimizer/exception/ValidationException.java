package be.shoktan.IngressFieldOptimizer.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Runtime Exception throwed when a validation method fail
 * @author wisthler
 *
 */
public class ValidationException extends RuntimeException{
	/**
	 * @param message
	 */
	public ValidationException(String message) {
		super(message);
	}
}