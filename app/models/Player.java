package models;

import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import be.shoktan.IngressFieldOptimizer.exception.ValidationException;

/**
 * Model class representing an Ingress player
 * @author wisthler
 *
 */
public class Player implements IValidable2{
	private String name;
	private ETeam faction;
	private int level; // 1..16
	private Set<Portal> ownedPortals; //1..n
	
	/**
	 * method to use to confirm the player is in a valid state
	 * @return true if the player is valid, false elsewhere
	 */
	public Validation validate(){
		Validation result = new Validation();
		
		if(level < 1 || level > 16){
			result.add(new ValidationException("the level of a player must be between 1 and 16"));
		}
		
		if(faction == null){
			result.add(new ValidationException("a player must be in a faction"));
		}
		
		if(StringUtils.isBlank(this.name)){
			result.add(new ValidationException("a player name cannot be empty"));
		}
		
		return result;
	}
}
