package be.shoktan.IngressFieldOptimizer.helper;

import static org.junit.Assert.assertTrue;
import models.Link;
import models.Portal;

import org.junit.Before;
import org.junit.Test;

public class MathHelperTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Portal memoirePrisonierPolitique = new Portal("Mémoire Prisonnier Politique", 50.295923, 5.099632);
		Portal demiCheval = new Portal("Demi-cheval", 50.295701 , 5.100146);
		Portal cineyKioske = new Portal("Kioske", 50.296477, 5.099647);
		Link l1 = new Link(memoirePrisonierPolitique, demiCheval);
		Link l2 = new Link(demiCheval, cineyKioske);
		
		assertTrue(MathHelper.doSegmentsIntersectEachOther(l1, l2));
		assertTrue(MathHelper.doSegmentsIntersectEachOther(l2, l1));
		
	}

}
