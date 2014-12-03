package models;

import java.util.Date;

public class Phase {
	private Operation operation;
	
	
	/* =============== Getters/Setters =============== */
	
	/**
	 * 
	 * @return the date of the phase
	 */
	public Date getDate(){
		return (this.operation != null)?this.operation.getDate():null;
	}
}
