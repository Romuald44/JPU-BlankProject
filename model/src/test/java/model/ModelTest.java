package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.element.mobile.Demons;
import model.element.mobile.MonsterOne;
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
	public void testAddMobile() {
		int taille = this.model.getMobiles().size();
		this.model.addMobile(new Demons(new MonsterOne(), 0, 0, this.model));
		Assert.assertEquals(taille+1, this.model.getMobiles().size());
	}

	@Test
	public void testGetScore() {
		Assert.assertNotNull(this.model.getScore());
	}

	@Test
	public void testLoadScore() {
		this.model.loadScore();
		Assert.assertNotNull(this.model.getScore());
	}

	@Test
	public void testLoadMap() {
		for(int y = 0; y < this.model.getHeight(); y++) {
			for(int x = 0; x < this.model.getWidth(); x++) {
				Assert.assertNotNull(this.model.getElements(x, y));
			}
		}
	}

	@Test
	public void testGetObservable() {
		Assert.assertNotNull(this.model.getObservable());
	}

}
