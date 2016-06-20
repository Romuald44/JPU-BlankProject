package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MapTest {

	private Map map;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.map = new Map();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMapIntIntString() {
		Assert.assertNotNull(this.map.getWidth());
		Assert.assertNotNull(this.map.getHeight());
		Assert.assertNotNull(this.map.getMap());
	}

	@Test
	public void testMap() {
		Assert.assertEquals(0, this.map.getWidth());
		Assert.assertEquals(0, this.map.getHeight());
		Assert.assertEquals("", this.map.getMap());
	}

	@Test
	public void testGetWidth() {
		Assert.assertNotNull(this.map.getWidth());
	}

	@Test
	public void testSetWidth() {
		this.map.setWidth(0);
		Assert.assertEquals(0, this.map.getWidth());
	}

	@Test
	public void testGetHeight() {
		Assert.assertNotNull(this.map.getHeight());
	}

	@Test
	public void testSetHeight() {
		this.map.setHeight(0);
		Assert.assertEquals(0, this.map.getHeight());
	}

	@Test
	public void testGetMap() {
		Assert.assertNotNull(this.map.getMap());
	}

	@Test
	public void testSetMap() {
		this.map.setMap("");
		Assert.assertEquals("", this.map.getMap());
	}

}
