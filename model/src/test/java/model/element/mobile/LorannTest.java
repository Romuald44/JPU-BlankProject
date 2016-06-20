package model.element.mobile;

import java.awt.Point;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Model;

public class LorannTest {

	private Lorann lorann;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.lorann = new Lorann(0, 0, new Model());
		this.lorann.setFireball(new Fireball(this.lorann, new Model()));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLorann() {
		Assert.assertNotNull(this.lorann.getLastPosition());
		Assert.assertTrue(this.lorann.getThreadActive());
		Assert.assertNotNull(this.lorann.getPosition());
	}

	@Test
	public void testGetLastPosition() {
		Assert.assertNotNull(this.lorann.getLastPosition());
	}

	@Test
	public void testSetLastPositionPoint() {
		Point position = new Point(10, 10);
		this.lorann.setLastPosition(position);
		Assert.assertEquals(position, this.lorann.getLastPosition());
	}

	@Test
	public void testSetLastPositionIntInt() {
		this.lorann.setLastPosition(10, 10);
		Assert.assertEquals(new Point(10, 10), this.lorann.getLastPosition());
	}

	@Test
	public void testGetFireball() {
		Assert.assertNotNull(this.lorann.getFireball());
	}

	@Test
	public void testSetFireball() {
		Fireball fireball = new Fireball(this.lorann, new Model());
		this.lorann.setFireball(fireball);
		Assert.assertSame(fireball, this.lorann.getFireball());
	}

}
