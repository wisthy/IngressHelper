package models;

public class Portal {
	private Double longitude;
	private Double latitude;
	
	
	
	/**
	 * @param longitude
	 * @param latitude
	 */
	private Portal(Double longitude, Double latitude) {
		super();
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	
	
	/**
	 * @return the longitude
	 */
	public Double getLongitude() {
		return longitude;
	}
	
	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return latitude;
	}
	
	
}
