package model.element;

import contract.IPermeability;
import model.Model;

public abstract class Element {//implements IPermeability
	private Sprite sprite;
	private Permeability permeability;
	private Model model;

	public Element(final Sprite sprite, final Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}
	
	public Element(final Permeability permeability) {
		this.setPermeability(permeability);
	}

	public Sprite getSprite() {
		return this.sprite;
	}

	private void setSprite(final Sprite sprite) {
		this.sprite = sprite;
	}

	public Permeability getPermeability() {
		return this.permeability;
	}

	private void setPermeability(final Permeability permeability) {
		this.permeability = permeability;
	}

	protected Model getModel() {
		return this.model;
	}

	public void setModel(final Model model) {
		this.model = model;
	}
}
