/**
 * 
 */
package be.shoktan.IngressFieldOptimizer.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import models.Field;

/**
 * @author wisthler
 *
 */
public class FieldValidationException extends ValidationException{	
	public FieldValidationException(Field field, String message) {
		super("error during the validation of the field <"+field+"> :: "+message);
	}
	
}
