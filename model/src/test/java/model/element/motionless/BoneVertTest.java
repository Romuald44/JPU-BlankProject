package model.element.motionless;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.element.Permeability;

public class BoneVertTest {

	private BoneVert boneVert;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.boneVert = new BoneVert();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBoneVert() {
		Assert.assertEquals(Permeability.BLOCKING, this.boneVert.getPermeability());
		Assert.assertEquals('|', this.boneVert.getSymbol());
	}

}
