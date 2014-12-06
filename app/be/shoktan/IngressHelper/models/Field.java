/**
 * 
 */
package be.shoktan.IngressHelper.models;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.shoktan.IngressHelper.exception.ValidationException;

import com.google.maps.clients.mapsengine.geojson.Point;
import com.google.maps.clients.mapsengine.geojson.Polygon;

/**
 * @author wisthler
 *
 */
public class Field implements IValidable{
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
			validateOld();
		} catch (ValidationException e) {
			LOG.error("unable to validate this field:"+ e.getMessage());
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
	
	/*
	 * (non-Javadoc)
	 * @see models.IValidable#validate()
	 */
	@Override
	public void validateOld() throws ValidationException{
		if(LOG.isDebugEnabled())LOG.debug("trying to validate "+this);
		
		if(this.links == null) {
			throw new ValidationException("no links in the field");
		}
		
		if(this.links.size() != 3) {
			throw new ValidationException("there should be exactly three links to create a field");
		}
		

		if(links.get(0) == null || links.get(1) == null ||links.get(2) == null){
			throw new ValidationException("all the links must be initialized before building the field");
		}
		
		for(int i = 0; i < 3; i++){
			Link link1 = links.get(i);
			Link link2 = links.get((i + 1) % 3); // modulo 3
			Link link3 = links.get((i + 2) % 3);
			
			boolean ok = false;
			
			if(link2.contains(link1.getOrigin()) && link3.contains(link1.getTarget()) && !link2.contains(link1.getTarget()) && ! link3.contains(link1.getOrigin())){
				ok = true;
			}
			
			if(!ok && link2.contains(link1.getTarget()) && link3.contains(link1.getOrigin()) && !link2.contains(link1.getOrigin()) && !link3.contains(link1.getTarget())){
				ok = true;
			}
			
			if(!ok){
				throw new ValidationException("each binome of links in a field must have exactly one common portal");
			}
			
			/*if((!link2.contains(link1.getOrigin())) && (!link2.contains(link1.getTarget()))){
				throw new ValidationException("two links of the field must have a common portal!");
			}*/
		}
		
		
		
		
		
	}
	
	
	
	/* =============== Others methods =============== */
	
	
	
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
