package model;

/**
 * The Class HelloWorld.
 */
class Map extends Entity {

	/** The width. */
	private int width;
	
	/** The Height. */
	private int height;
	
	/** The map. */
	private String map;

	/**
	 * Instantiates a new Map.
	 *
	 * @param width
	 *          the width
	 * @param height
	 *          the height
	 * @param map
	 *          the map
	 */
	public Map(final int width, final int height, final String map) {
		this.setWidth(width);
		this.setHeight(height);
		this.setMap(map);
	}

	/**
	 * Instantiates a new Map.
	 */
	public Map() {
		this(0, 0, "");
	}

	/**
	 * Gets the width.
	 *
	 * @return the width
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Sets the width.
	 *
	 * @param width
	 *          the new width
	 */
	public void setWidth(final int width) {
		this.width = width;
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * Sets the height.
	 *
	 * @param height
	 *          the new height
	 */
	public void setHeight(final int height) {
		this.height = height;
	}
	
	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	public String getMap() {
		return this.map;
	}

	/**
	 * Sets the map.
	 *
	 * @param map
	 *          the new map
	 */
	public void setMap(final String map) {
		this.map = map;
	}
	
	

}
