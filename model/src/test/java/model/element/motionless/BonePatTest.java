package model.element.motionless;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.element.Permeability;

public class BonePatTest {

	private BonePat bonePat;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.bonePat = new BonePat();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBonePat() {
		Assert.assertEquals(Permeability.BLOCKING, this.bonePat.getPermeability());
		Assert.assertEquals('o', this.bonePat.getSymbol());
	}

}
