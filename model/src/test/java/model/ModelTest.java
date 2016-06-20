package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.element.motionless.MotionlessElements;

public class ModelTest {
	
	private Model model;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.model = new Model();
		this.model.loadMap(1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testModel() {
		Assert.assertNotNull(this.model.getMobiles());
	}

	@Test
	public void testGetThreadFireball() {
		Assert.assertNotNull(this.model.getThreadFireball());
	}

	@Test
	public void testGetMap() {
		Assert.assertNotNull(this.model.getMap());
	}

	@Test
	public void testAddElement() {
		this.model.addElement(MotionlessElements.LAND, 0, 0);
		Assert.assertEquals(MotionlessElements.LAND, this.model.getElements(0, 0));
	}

	@Test
	public void testReplaceLand() {
		this.model.replaceLand(0, 0);
		Assert.assertEquals(MotionlessElements.LAND, this.model.getElements(0, 0));
	}

	@Test
	public void testGetPointsPurse() {
		Assert.assertNotNull(this.model.getPointsPurse());
	}

	@Test
	public void testSetDeath() {
		this.model.setDeath(true);
		Assert.assertTrue(this.model.getDeath());
	}

	@Test
	public void testGetDeath() {
		Assert.assertNotNull(this.model.getDeath());
	}

	@Test
	public void testSetTheEnd() {
		this.model.setTheEnd(true);
		Assert.assertTrue(this.model.getTheEnd());
	}

	@Test
	public void testGetTheEnd() {
		Assert.assertNotNull(this.model.getTheEnd());
	}

	@Test
	public void testGetWidth() {
		Assert.assertNotNull(this.model.getWidth());
	}

	@Test
	public void testGetHeight() {
		Assert.assertNotNull(this.model.getHeight());
	}

	@Test
	public void testGetElements() {
		try {
			this.model.getElements(0, 0);
		}
		catch(final Exception e) {
			Assert.assertEquals("Out of range", e.getMessage());
		}
	}

	@Test
	public void testGetArrayElement() {
		Assert.assertNotNull(this.model.getArrayElement());
	}

	@Test
	public void testGetMobiles() {
		Assert.assertNotNull(this.model.getMobiles());
	}

	@Test
	public void testGetLorann() {
		Assert.assertNotNull(this.model.getLorann());
	}

	@Test
	public void testGetPurse() {
		Assert.assertNotNull(this.model.getPurse());
	}

	@Test
	public void testGetGate() {
		Assert.assertNotNull(this.model);
	}

	@Test
	public void testAddMobile() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetScore() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetScore() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadScore() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadMap() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetMobileHasChanged() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetObservable() {
		fail("Not yet implemented");
	}

}
