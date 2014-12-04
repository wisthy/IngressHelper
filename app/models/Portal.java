package models;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.eclipse.jdt.core.dom.ThisExpression;

import be.shoktan.IngressFieldOptimizer.exception.ValidationException;

import com.google.maps.clients.mapsengine.geojson.Point;

public final class Portal implements IValidable, Comparable<Portal> {
	private String name;
	private Point coord;
	//private EExtendedFaction owningTeam;
	private Player owner;
	private boolean guardian;
	private boolean pivot;
	private Locality locality;
	
	
	
	/* =============== Constructors =============== */	
	
	/**
	 * 
	 * @param name the name of the portal
	 * @param latitude the latitude of the portal
	 * @param longitude the longitude of the portal
	 */
	public Portal(String name, double latitude, double longitude){
		this.name = name;
		this.coord = new Point(latitude, longitude);
		reset();
		validateOld();
	}

	
	
	/* =============== Getters/Setters =============== */
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the coord
	 */
	protected Point getCoord() {
		return coord;
	}
	
	/**
	 * 
	 * @return the latitude of the portal. Can be null
	 */
	public Double getLatitude(){
		return (this.coord != null)?this.coord.latitude:null;
	}
	
	
	/**
	 * 
	 * @return the longitude of the portal. Can be null
	 */
	public Double getLongitude(){
		return (this.coord != null)?this.coord.longitude:null;
	}	
	
	
	
	/* =============== Override/Implement method =============== */	

	/**
	 * @return true if the portal is a guardian, false elsewhere
	 */
	public boolean isGuardian() {
		return guardian;
	}



	/**
	 * @param guardian true if the portal is a guardian, false elsewhere
	 */
	public void setGuardian(boolean guardian) {
		this.guardian = guardian;
	}



	/**
	 * @return true if the portal is used or usable as pivot, false elsewhere
	 */
	public boolean isPivot() {
		return pivot;
	}



	/**
	 * @param pivot true if the portal is used or usable as pivot, false elsewhere
	 */
	public void setPivot(boolean pivot) {
		this.pivot = pivot;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Portal [");
		builder.append(name);
		builder.append("(");
		if(coord == null){
			builder.append("null");
		}else{
			builder.append(coord.latitude);
			builder.append(", ");
			builder.append(coord.longitude);
		}
		
		builder.append(")]");
		return builder.toString();
	}

	/*
	 * (non-Javadoc)
	 * @see models.IValidable#validate()
	 */
	@Override
	public void validateOld() throws ValidationException {
		// TODO Auto-generated method stub
		
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Portal o) {
		return new CompareToBuilder().append(this.coord.latitude, o.coord.latitude)
				.append(this.coord.longitude, o.coord.longitude)
				.toComparison();
	}
	
	
	
	/* =============== Others methods =============== */
	
	/**
	 * restore the portal to it's neutral state
	 */
	public void reset(){
		this.owner = null;
		this.guardian = false;
		this.pivot = false;
	}
}
