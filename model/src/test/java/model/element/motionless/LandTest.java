package model.element.motionless;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.element.Permeability;

public class LandTest {

	private Land land;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.land = new Land();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLand() {
		Assert.assertEquals(Permeability.PENETRABLE, this.land.getPermeability());
		Assert.assertEquals(' ', this.land.getSymbol());
	}

}
