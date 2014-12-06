package be.shoktan.IngressHelper.models;


import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import be.shoktan.IngressHelper.models.Portal;
import play.test.UnitTest;

public class SimplePortalTest extends UnitTest {
	private static final Logger LOG = LoggerFactory.getLogger(SimplePortalTest.class);

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void BasicTest() {
		Portal memoirePrisonierPolitique = new Portal("Ciney:: Mémoire Prisonnier Politique", 50.295923, 5.099632);
		LOG.debug("portal created:: "+memoirePrisonierPolitique);
		
	}

}
