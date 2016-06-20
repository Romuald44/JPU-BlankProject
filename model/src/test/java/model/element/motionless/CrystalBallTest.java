package model.element.motionless;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.ActionOnLorann;
import model.element.Permeability;

public class CrystalBallTest {

	private CrystalBall crystalBall;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.crystalBall = new CrystalBall();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetActionOnLorann() {
		Assert.assertEquals(ActionOnLorann.OPEN_GATE, this.crystalBall.getActionOnLorann());
	}

	@Test
	public void testCrystalBall() {
		Assert.assertEquals(Permeability.PENETRABLE, this.crystalBall.getPermeability());
		Assert.assertEquals('c', this.crystalBall.getSymbol());
	}

}
