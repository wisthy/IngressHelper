package models;

import java.util.Date;
import java.util.List;

/**
 * Model class representing an Ingress Operation
 * @author wisthler
 *
 */
public class Operation {
	private List<Phase> phases;
	private Date date;
	
	
	
	/* =============== Getters/Setters =============== */
	
	/**
	 * @return the date of the operation
	 */
	public Date getDate() {
		return date;
	}
}
