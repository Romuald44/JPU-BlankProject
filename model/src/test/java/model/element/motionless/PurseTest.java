package model.element.motionless;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.ActionOnLorann;
import model.element.Permeability;

public class PurseTest {

	private Purse purse;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.purse = new Purse();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetActionOnLorann() {
		Assert.assertEquals(ActionOnLorann.RECOVERABLE, this.purse.getActionOnLorann());
	}

	@Test
	public void testPurse() {
		Assert.assertEquals(Permeability.PENETRABLE, this.purse.getPermeability());
		Assert.assertEquals('p', this.purse.getSymbol());
	}

}
