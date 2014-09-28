package models;

import com.google.maps.clients.mapsengine.geojson.Point;

public class Portal {
	private String name;
	private Point coord;
	
	
	
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Portal [name=");
		builder.append(name);
		builder.append(", coord=");
		builder.append(coord);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	/* =============== Others methods =============== */
}
