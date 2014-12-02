package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Player blank = new Player();
		Validation validation = blank.validate();
		assertFalse("the blank player shouldn't be valid", validation.isValid());
	}

}
