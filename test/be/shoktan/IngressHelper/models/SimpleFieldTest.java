/**
 * 
 */
package be.shoktan.IngressHelper.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import play.test.UnitTest;
import be.shoktan.IngressHelper.exception.ValidationException;
import be.shoktan.IngressHelper.models.Field;
import be.shoktan.IngressHelper.models.Link;
import be.shoktan.IngressHelper.models.Portal;

/**
 * @author wisthler
 *
 */
public class SimpleFieldTest extends UnitTest{
private static final Logger LOG = LoggerFactory.getLogger(SimpleFieldTest.class);
	
	Portal memoirePrisonierPolitique;
	Portal demiCheval;
	Portal cineyKioske;
	Portal test;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		memoirePrisonierPolitique = new Portal("Mémoire Prisonnier Politique", 50.295923, 5.099632);
		demiCheval = new Portal("Demi-cheval", 50.295701 , 5.100146);
		cineyKioske = new Portal("Kioske", 50.296477, 5.099647);
		test = new Portal("test", 0, 0);
	}

	/**
	 * just a basic test for starting
	 */
	@Test
	public void test() {
		LOG.debug("**");
		LOG.debug("***** test() *****");
		Link l1 = new Link(memoirePrisonierPolitique, demiCheval);
		Link l2 = new Link(demiCheval, cineyKioske);
		Link l3 = new Link(cineyKioske, memoirePrisonierPolitique);
		Field f = new Field(l1,  l2, l3);
	}
	
	
	/**
	 * Test the rules that should trigger a failed validation
	 */
	@Test
	public void testFailValidation(){
		LOG.debug("**");
		LOG.debug("***** testFailValidation() *****");
		Link l1 = new Link(memoirePrisonierPolitique, demiCheval);
		Link l2 = new Link(demiCheval, cineyKioske);
		Link l3 = new Link(cineyKioske, memoirePrisonierPolitique);
		Link l4 = new Link(cineyKioske, test);
		
		Link[] links = new Link[]{null, l1, l2};
		
		for(Link a : links){
			for(Link b : links){
				for (Link c : links){
					try {
						new Field(a, b, c);
						fail();
					} catch (ValidationException e) {
					}
				}
			}
		}
		
		try {
			new Field(l1, l2, l4);
			fail();
		} catch (ValidationException e) {
		}
		
		try {
			new Field(l1, l1, l2);
			fail();
		} catch (ValidationException e) {
		}
	}
	
	/**
	 * test the creation of a field with the link in the wrong order
	 */
	@Test
	public void testDisordered(){
		LOG.debug("**");
		LOG.debug("***** testDisordered() *****");
		Link l1 = new Link(memoirePrisonierPolitique, demiCheval);
		Link l2 = new Link(demiCheval, cineyKioske);
		Link l3 = new Link(cineyKioske, memoirePrisonierPolitique);
		Link l4 = new Link(memoirePrisonierPolitique, cineyKioske);
		try {
			new Field(l1, l3, l2);
			
		} catch (ValidationException e) {
			fail();
		}
		
		try {
			new Field(l1, l2, l4);
			
		} catch (ValidationException e) {
			fail();
		}
	}
}
