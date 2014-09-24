/**
 * 
 */
package models;

/**
 * @author wisthler
 *
 */
public class Field {
	private Link[] links;

	
	/**
	 * @param link1
	 * @param link2
	 * @param link3
	 */
	private Field(Link link1, Link link2, Link link3) {
		super();
		this.links = new Link[]{link1, link2, link3};
	}
	
	

}
