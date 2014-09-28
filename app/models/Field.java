/**
 * 
 */
package models;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author wisthler
 *
 */
public class Field {
	private SortedSet<Link> links = new TreeSet<>();
	
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
		build();
	}
	
	
	/* =============== Getters/Setters =============== */
	
	public SortedSet<Link> getLinks(){
		return this.links;
	}
	
	/* =============== Override/Implement method =============== */	
	
	
	
	
	/* =============== Others methods =============== */	
	
	private void build(){
		
	}
}
