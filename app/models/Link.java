/**
 * 
 */
package models;

import java.util.Arrays;
import java.util.List;

import com.google.maps.clients.mapsengine.geojson.LineString;
import com.google.maps.clients.mapsengine.geojson.Point;

/**
 * @author wisthler
 *
 */
public class Link {
	private Portal origin;
	private Portal target;
	private LineString line;

	

	/* =============== Constructors =============== */	
	
	/**
	 * @param origin
	 * @param target
	 */
	private Link(Portal origin, Portal target) {
		super();
		this.origin = origin;
		this.target = target;
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
	
	
	
	
	/* =============== Others methods =============== */	

	/**
	 * compute the line on the map between the two portals
	 */
	private void build() {
		List<Point> list = Arrays.asList(new Point[]{origin.getCoord(), target.getCoord()});
		this.line = new LineString(list);
	}
}
