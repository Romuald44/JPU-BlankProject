package model.element.motionless;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.ActionOnLorann;
import model.element.Permeability;

public class GateTest {

	private Gate gate;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.gate = new Gate();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetActionOnLorann() {
		Assert.assertEquals(ActionOnLorann.KILL, this.gate.getActionOnLorann());
	}

	@Test
	public void testGate() {
		Assert.assertEquals(Permeability.PENETRABLE, this.gate.getPermeability());
		Assert.assertEquals('g', this.gate.getSymbol());
	}

	@Test
	public void testOpen() {
		this.gate.open();
		Assert.assertEquals(ActionOnLorann.FINISH, this.gate.getActionOnLorann());
		Assert.assertTrue(this.gate.isOpen());
	}

	@Test
	public void testIsOpen() {
		Assert.assertNotNull(this.gate.isOpen());
	}

}
