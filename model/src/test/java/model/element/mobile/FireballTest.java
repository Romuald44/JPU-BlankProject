package model.element.mobile;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Model;

public class FireballTest {

	private Fireball fireball;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.fireball = new Fireball(new Lorann(0, 0, new Model()), new Model());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFireball() {
		Assert.assertFalse(this.fireball.getActive());
		Assert.assertNotNull(this.fireball.getDirection());
		Assert.assertTrue(this.fireball.getThreadActive());
	}

	@Test
	public void testGetActive() {
		Assert.assertNotNull(this.fireball.getActive());
	}

	@Test
	public void testGetDirection() {
		Assert.assertNotNull(this.fireball.getDirection());
	}

	@Test
	public void testDeactivate() {
		Assert.assertFalse(this.fireball.getActive());
	}

}
