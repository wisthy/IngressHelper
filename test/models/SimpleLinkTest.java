/**
 * 
 */
package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.test.UnitTest;
import be.shoktan.IngressHelper.exception.ValidationException;
import be.shoktan.IngressHelper.models.Link;
import be.shoktan.IngressHelper.models.Portal;

/**
 * @author wisthler
 *
 */
public class SimpleLinkTest extends UnitTest{
	private static final Logger LOG = LoggerFactory.getLogger(SimpleLinkTest.class);
	
	Portal memoirePrisonierPolitique;
	Portal demiCheval;
	Portal cineyKioske;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		memoirePrisonierPolitique = new Portal("Mémoire Prisonnier Politique", 50.295923, 5.099632);
		//LOG.debug("P1: "+memoirePrisonierPolitique);
		
		demiCheval = new Portal("Demi-cheval", 50.295701 , 5.100146);
		//LOG.debug("P2: "+demiCheval);
		
		
		cineyKioske = new Portal("Kioske", 50.296477, 5.099647);
		//LOG.debug("P3: "+cineyKioske);
		
	}

	/**
	 * Test method for {@link be.shoktan.IngressHelper.models.Link#getOrigin()}.
	 */
	@Test
	public void testGetOrigin() {
		LOG.debug("***** testGetOrigin() *****");
		Link link = new Link(demiCheval, cineyKioske);
		//LOG.debug("link created: "+link);
		assertEquals(demiCheval, link.getOrigin());
	}

	/**
	 * Test method for {@link be.shoktan.IngressHelper.models.Link#getTarget()}.
	 */
	@Test
	public void testGetTarget() {
		LOG.debug("***** testGetTarget() *****");
		Link link = new Link(demiCheval, cineyKioske);
		assertEquals(cineyKioske, link.getTarget());
	}
	
	/**
	 * Test the rules that should trigger a failed validation
	 */
	@Test
	public void testFailValidation(){
		LOG.debug("***** testFailValidation() *****");
		
		Link link = null;
		
		Portal[] test = new Portal[]{demiCheval, null};
		
		for(Portal p1 : test){
			for(Portal p2 : test){
				try {
					link = new Link(p1, p2);
					fail("the link should have been refused!");
				} catch (ValidationException e) {
					
				}
			}
		}
		
		
	}
	
	@Test
	public void testContainsLatitude(){
		Link link = new Link(demiCheval, cineyKioske);
		Link reverse = new Link(cineyKioske, demiCheval);

		//demiCheval = new Portal("Demi-cheval", 50.295701 , 5.100146);
		//cineyKioske = new Portal("Kioske", 50.296477, 5.099647);
		
		double[] ok = new double[]{50.295701, 50.295702, 50.296, 50.296477};
		double[] ko = new double[]{49, 40.5957, 50.296478, 50.297};
		
		for(double d : ok){
			assertTrue(link.containsLatitude(d));
			assertTrue(reverse.containsLatitude(d));
		}
		
		for(double d : ko){
			assertFalse(link.containsLatitude(d));
			assertFalse(reverse.containsLatitude(d));
		}
		
	}

}
