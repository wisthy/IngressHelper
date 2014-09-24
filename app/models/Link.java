/**
 * 
 */
package models;

/**
 * @author wisthler
 *
 */
public class Link {
	private Portal origin;
	private Portal target;
	
	
	
	/**
	 * @param origin
	 * @param target
	 */
	private Link(Portal origin, Portal target) {
		super();
		this.origin = origin;
		this.target = target;
	}



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
	
	
}
