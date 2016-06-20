package model.element;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Model;
import model.element.mobile.Lorann;

public class ElementTest {

	private Element element;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.element = new Lorann(0, 0, new Model());
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testElementSpritePermeability() {
		Assert.assertNotNull(this.element.getSprite());
		Assert.assertNotNull(this.element.getPermeability());
	}

	@Test
	public void testElementPermeability() {
		Assert.assertNotNull(this.element.getPermeability());
	}

	@Test
	public void testGetSprite() {
		Assert.assertNotNull(this.element.getSprite());
	}

	@Test
	public void testSetSprite() {
		Sprite sprite = new Sprite("lorann_u.png");
		this.element.setSprite(sprite);
		Assert.assertSame(sprite, this.element.getSprite());
	}

	@Test
	public void testGetPermeability() {
		Assert.assertNotNull(this.element.getPermeability());
	}

	@Test
	public void testSetPermeability() {
		this.element.setPermeability(Permeability.PENETRABLE);
		Assert.assertEquals(Permeability.PENETRABLE, this.element.getPermeability());
	}

	@Test
	public void testGetModel() {
		Assert.assertNotNull(this.element.getModel());
	}

	@Test
	public void testSetModel() {
		Model model = new Model();
		this.element.setModel(model);
		Assert.assertSame(model, this.element.getModel());
	}

}
