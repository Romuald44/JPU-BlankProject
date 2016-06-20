package model.element;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SpriteTest {

	private Sprite sprite;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.sprite = new Sprite("lorann_u.png");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSprite() {
		Assert.assertNotNull(this.sprite.getImage());
	}

	@Test
	public void testGetImage() {
		Assert.assertNotNull(this.sprite.getImage());
	}

}
