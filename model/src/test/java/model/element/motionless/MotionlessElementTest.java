package model.element.motionless;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.ActionOnLorann;

public class MotionlessElementTest {

	MotionlessElement motionlessElement;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.motionlessElement = new Land();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMotionlessElement() {
		Assert.assertNotNull(this.motionlessElement.getSprite());
		Assert.assertNotNull(this.motionlessElement.getPermeability());
		Assert.assertNotNull(this.motionlessElement.getSymbol());
	}

	@Test
	public void testGetSymbol() {
		Assert.assertNotNull(this.motionlessElement.getSymbol());
	}

	@Test
	public void testGetImage() {
		Assert.assertNotNull(this.motionlessElement.getImage());
	}

	@Test
	public void testGetActionOnLorann() {
		Assert.assertEquals(ActionOnLorann.NOP, this.motionlessElement.getActionOnLorann());
	}

}
