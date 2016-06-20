package model.element.mobile;

import java.awt.Point;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Model;

public class MobileTest {

	private Mobile mobile;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Model model = new Model();
		model.loadMap(1);
		this.mobile = new Lorann(0, 0, model);
		this.mobile.setThread(new Lorann(0, 0, model));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMobile() {
		Assert.assertNotNull(this.mobile.getSprite());
		Assert.assertNotNull(this.mobile.getPermeability());
		Assert.assertNotNull(this.mobile.getPosition());
		Assert.assertTrue(this.mobile.getThreadActive());
	}

	@Test
	public void testGetX() {
		Assert.assertNotNull(this.mobile.getX());
	}

	@Test
	public void testGetY() {
		Assert.assertNotNull(this.mobile.getY());
	}

	@Test
	public void testSetX() {
		try {
			this.mobile.setX(0);
		} catch (Exception e) {
			Assert.assertEquals("Out of range", e.getMessage());
		}
	}

	@Test
	public void testSetY() {
		try {
			this.mobile.setY(0);
		} catch (Exception e) {
			Assert.assertEquals("Out of range", e.getMessage());
		}
	}

	@Test
	public void testGetThread() {
		Assert.assertNotNull(this.mobile.getThread());
	}

	@Test
	public void testGetImage() {
		Assert.assertNotNull(this.mobile.getImage());
	}

	@Test
	public void testGetThreadActive() {
		Assert.assertNotNull(this.mobile.getThreadActive());
	}

	@Test
	public void testSetThreadActive() {
		this.mobile.setThreadActive(true);
		Assert.assertTrue(this.mobile.getThreadActive());
	}

	@Test
	public void testGetPosition() {
		Assert.assertNotNull(this.mobile.getPosition());
	}

	@Test
	public void testSetPosition() {
		Point position = new Point(10, 10);
		this.mobile.setPosition(position);
		Assert.assertEquals(position, this.mobile.getPosition());
	}

	@Test
	public void testIsMovePossible() {
		try {
			Assert.assertNotNull(this.mobile.isMovePossible(0, 0));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMoveUp() throws Exception {
		this.mobile.setX(10);
		this.mobile.setY(2);
		this.mobile.moveUp();
		Assert.assertEquals(1, this.mobile.getY());
	}

	@Test
	public void testMoveLeft() throws Exception {
		this.mobile.setX(10);
		this.mobile.setY(2);
		this.mobile.moveLeft();
		Assert.assertEquals(9, this.mobile.getX());
	}

	@Test
	public void testMoveDown() throws Exception {
		this.mobile.setX(10);
		this.mobile.setY(2);
		this.mobile.moveDown();
		Assert.assertEquals(3, this.mobile.getY());
	}

	@Test
	public void testMoveRight() throws Exception {
		this.mobile.setX(10);
		this.mobile.setY(2);
		this.mobile.moveRight();
		Assert.assertEquals(11, this.mobile.getX());
	}

}
