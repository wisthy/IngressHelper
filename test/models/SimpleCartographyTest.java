package models;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import play.test.UnitTest;

public class SimpleCartographyTest extends UnitTest {
	Portal memoirePrisonierPolitique;
	Portal demiCheval;
	Portal cineyKioske;

	@Before
	public void setUp() throws Exception {
		memoirePrisonierPolitique = new Portal("Mémoire Prisonnier Politique", 50.295923, 5.099632);
		demiCheval = new Portal("Demi-cheval", 50.295701 , 5.100146);
		cineyKioske = new Portal("Kioske", 50.296477, 5.099647);
	}

	@Test
	public void test() {
		Cartography carto = new Cartography(memoirePrisonierPolitique, demiCheval, cineyKioske);
		carto.generateAllLinks();
		assertEquals(6, carto.getAllLinks().size());
	}

}
