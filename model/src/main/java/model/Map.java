package model;

/**
 * The Class HelloWorld.
 *
 * @author Jean-Aymeric Diet
 */
class Map extends Entity {

	/** The width. */
	private int width;
	
	/** The Height. */
	private int height;
	
	/** The Height. */
	private String map;

	/**
	 * Instantiates a new hello world.
	 *
	 * @param id
	 *          the id
	 * @param key
	 *          the key
	 * @param message
	 *          the message
	 */
	public Map(final int width, final int height, final String map) {
		this.setWidth(width);
		this.setHeight(height);
		this.setMap(map);
	}

	/**
	 * Instantiates a new hello world.
	 */
	public Map() {
		this(0, 0, "");
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *          the new id
	 */
	public void setWidth(final int width) {
		this.width = width;
	}

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * Sets the key.
	 *
	 * @param key
	 *          the new key
	 */
	public void setHeight(final int height) {
		this.height = height;
	}
	
	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public String getMap() {
		return this.map;
	}

	/**
	 * Sets the key.
	 *
	 * @param key
	 *          the new key
	 */
	public void setMap(final String map) {
		this.map = map;
	}
	
	

}
