/**
 * 
 */
package models;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wisthler
 *
 */
public class Cartography {
	private static final Logger LOG = LoggerFactory.getLogger(Cartography.class);
	
	private SortedSet<Portal> allPortals = new TreeSet<>();
	private Set<Link> allLinks = new HashSet<>();
	
	
	
	/* =============== Constructors              =============== */
	
	/**
	 * create a basic cartography providing a list a portals
	 * @param portals
	 */
	public Cartography(Portal... portals){
		this.allPortals.addAll(Arrays.asList(portals));
	}
	
	
	
	/* =============== Getters/Setters           =============== */
	
	public Set<Link> getAllLinks(){
		return this.allLinks;
	}
	
	
	/* =============== Override/Implement method =============== */	
	/* =============== Others methods            =============== */
	
	public void generateAllLinks(){
		for(Portal a: allPortals){
			for(Portal b: allPortals){
				if(a != null && b != null && a.compareTo(b) < 0){
					this.allLinks.add(new Link(a, b));
					this.allLinks.add(new Link(b, a));
				}
			}
		}
	}
}
