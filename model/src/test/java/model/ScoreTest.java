package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ScoreTest {

	private Score score;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.score = new Score();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testScoreInt() {
		Assert.assertNotNull(this.score.getScore());
	}

	@Test
	public void testScore() {
		Assert.assertEquals(0, this.score.getScore());
	}

	@Test
	public void testGetScore() {
		Assert.assertNotNull(this.score.getScore());
	}

	@Test
	public void testSetScore() {
		this.score.setScore(10);
		Assert.assertEquals(10, this.score.getScore());
	}

}
