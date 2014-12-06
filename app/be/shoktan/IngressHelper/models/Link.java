/**
 * 
 */
package be.shoktan.IngressHelper.models;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.shoktan.IngressHelper.exception.ValidationException;

import com.google.maps.clients.mapsengine.geojson.LineString;
import com.google.maps.clients.mapsengine.geojson.Point;

/**
 * @author wisthler
 *
 */
public class Link implements IValidable{
	private static final Logger LOG = LoggerFactory.getLogger(Link.class);
	
	private Portal origin;
	private Portal target;
	private LineString line;
	private EStatus status;

	

	/* =============== Constructors =============== */	
	
	/**
	 * @param origin
	 * @param target
	 */
	public Link(Portal origin, Portal target) {
		super();
		this.origin = origin;
		this.target = target;
		validateOld();
		build();
	}



	/* =============== Getters/Setters =============== */


	/**
	 * @return the origin
	 */
	public Portal getOrigin() {
		return origin;
	}

	/**
	 * @return the target
	 */
	public Portal getTarget() {
		return target;
	}
	
	
	
	/* =============== Override/Implement method =============== */	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Link [");
		builder.append(origin);
		builder.append(" -> ");
		builder.append(target);
		builder.append("]");
		return builder.toString();
	}
	
	/*
	 * (non-Javadoc)
	 * @see models.IValidable#validate()
	 */
	@Override
	public void validateOld() throws ValidationException{
		if(LOG.isDebugEnabled())LOG.debug("trying to validate "+this);
		
		if(origin == null){
			throw new ValidationException("the origin portal cannot be null");
		}
		
		if(target == null){
			throw new ValidationException("the target portal cannot be null");
		}
		
		if(origin.equals(target)){
			throw new ValidationException("origin portal and target portal cannot be the same portal");
		}
	}
	
	
	
	/* =============== Others methods =============== */	
	
	/**
	 * compute the line on the map between the two portals
	 */
	private void build() {
		List<Point> list = Arrays.asList(new Point[]{origin.getCoord(), target.getCoord()});
		this.line = new LineString(list);
	}
	
	/**
	 * check if the portal specified is either the origin portal or the target portal of this link
	 * @param portal the specified portal
	 * @return true if the specified portal is the origin or target portal of this link, false elsewhere
	 */
	public boolean contains(Portal portal){
		return origin == portal || target == portal;
	}



	public boolean containsLatitude(double x) {
		return (x >= origin.getLatitude() && x <= target.getLatitude()) || (x <= origin.getLatitude() && x >= target.getLatitude()); 
	}
	
	public Link reverse(){
		Link result = new Link(target, origin);
		return result;
	}
}
