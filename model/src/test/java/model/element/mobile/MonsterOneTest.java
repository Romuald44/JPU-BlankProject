package model.element.mobile;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MonsterOneTest {

	private MonsterOne monsterOne;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.monsterOne = new MonsterOne();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetSprite() {
		Assert.assertNotNull(this.monsterOne.getSprite());
	}

}
