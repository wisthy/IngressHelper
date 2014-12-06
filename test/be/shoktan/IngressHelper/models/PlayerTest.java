package be.shoktan.IngressHelper.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.shoktan.IngressHelper.models.Player;
import be.shoktan.IngressHelper.models.Validation;

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
