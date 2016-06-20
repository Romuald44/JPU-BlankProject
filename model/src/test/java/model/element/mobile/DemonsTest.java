package model.element.mobile;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.ActionOnLorann;
import model.Model;

public class DemonsTest {

	private Demons demon;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.demon = new Demons(new MonsterOne(), 0, 0, new Model());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDemons() {
		Assert.assertEquals(0, this.demon.getX());
		Assert.assertEquals(0, this.demon.getY());
		Assert.assertTrue(this.demon.getThreadActive());
	}

	@Test
	public void testGetActionOnLorann() {
		Assert.assertEquals(ActionOnLorann.KILL, this.demon.getActionOnLorann());
	}

}
