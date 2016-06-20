package model.element.motionless;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.element.Permeability;

public class BoneHorizTest {

	private BoneHoriz boneHoriz;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.boneHoriz = new BoneHoriz();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBoneHoriz() {
		Assert.assertEquals(Permeability.BLOCKING, this.boneHoriz.getPermeability());
		Assert.assertEquals('-', this.boneHoriz.getSymbol());
	}

}
