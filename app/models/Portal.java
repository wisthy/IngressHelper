package models;

import com.google.maps.clients.mapsengine.geojson.Point;

public class Portal {
	private String name;
	private Point coord;
	
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
}
