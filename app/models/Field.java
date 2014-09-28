/**
 * 
 */
package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.shoktan.IngressFieldOptimizer.exception.FieldValidationException;
import be.shoktan.IngressFieldOptimizer.exception.ValidationException;

import com.google.maps.clients.mapsengine.geojson.Point;
import com.google.maps.clients.mapsengine.geojson.Polygon;

/**
 * @author wisthler
 *
 */
public class Field {
	private static final Logger LOG = LoggerFactory.getLogger(Field.class);
	
	private List<Link> links = new ArrayList<>();
	private Polygon triangle;
	
	/* =============== Constructors =============== */	

	
	/**
	 * @param link1
	 * @param link2
	 * @param link3
	 */
	public Field(Link link1, Link link2, Link link3) {
		super();
		this.links.add(link1);
		this.links.add(link2);
		this.links.add(link3);
		try {
			validate();
		} catch (ValidationException e) {
			LOG.error("unable to validate this field", e);
			throw e;
		}
		build();
	}
	
	
	
	/* =============== Getters/Setters =============== */
	
	/**
	 * 
	 * @return the sorted set of the 3 links composing this field
	 */
	public SortedSet<Link> getLinks(){
		SortedSet<Link> result = new TreeSet();
		result.addAll(this.links);
		return result;
	}
	
	
	
	/* =============== Override/Implement method =============== */	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Field [links=" + links + "]";
	}
	
	
	
	/* =============== Others methods =============== */
	
	/**
	 * try to validate the field to ensure it follow the rules
	 * @throws FieldValidationException if at least one rule is not respected
	 */
	private void validate() throws FieldValidationException{
		if(this.links == null) {
			throw new FieldValidationException(this, "no links in the field");
		}
		
		if(this.links.size() != 3) {
			throw new FieldValidationException(this, "there should be exactly three links to create a field");
		}
		

		if(links.get(0) == null || links.get(1) == null ||links.get(2) == null){
			throw new FieldValidationException(this, "all the links must be initialized before building the field");
		}
		
		for(int i = 0; i < 3; i++){
			int origin = i;
			int target = (i + 1) % 3; // modulo 3
			if(links.get(origin).getTarget() != links.get(target).getOrigin()){
				throw new FieldValidationException(this, "the target portal of a link must be the origin portal of the next link");
			}
		}
		
		
	}
	
	/**
	 * build the actual triangle representing the field using the provided links
	 */
	private void build(){
		List<Point> points = new ArrayList<>();
		for(Link link : this.links){
			points.add(link.getOrigin().getCoord());
		}
		
		// now close the triangle by going back to the origin
		points.add(points.get(0));
		
		triangle = Polygon.createSimplePolygon(points); 
	}
}
