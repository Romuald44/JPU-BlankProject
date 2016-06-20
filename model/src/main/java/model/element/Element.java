package model.element;

import model.Model;


public abstract class Element {
	
	/**
	 * Sprite sprite
	 */
	private Sprite sprite;
	
	/**
	 * Permeability permeability
	 */
	private Permeability permeability;
	
	/**
	 * Model model
	 */
	private Model model;

	/**
	 * Instantiate Element
	 * @param sprite
	 * @param permeability
	 */
	public Element(final Sprite sprite, final Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}

	/**
	 * Instantiate Element
	 * @param permeability
	 */
	public Element(final Permeability permeability) {
		this.setPermeability(permeability);
	}

	/**
	 * get Sprite
	 * @return Sprite
	 */
	public Sprite getSprite() {
		return this.sprite;
	}

	/**
	 * set Sprite
	 * @param sprite
	 */
	protected void setSprite(final Sprite sprite) {
		this.sprite = sprite;
	}

	/**
	 * get Permeability
	 * @return Permeability
	 */
	public Permeability getPermeability() {
		return this.permeability;
	}

	/**
	 * set Permeability
	 * @param permeability
	 */
	public void setPermeability(final Permeability permeability) {
		this.permeability = permeability;
	}

	/**
	 * get Model
	 * @return Model
	 */
	protected Model getModel() {
		return this.model;
	}

	/**
	 * set Model
	 * @param model
	 */
	public void setModel(final Model model) {
		this.model = model;
	}
}
