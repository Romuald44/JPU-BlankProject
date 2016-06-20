package model.element.motionless;

import java.awt.Image;

import contract.ActionOnLorann;
import contract.IActionOnLorann;
import contract.IMotionLess;
import model.element.Element;
import model.element.Permeability;
import model.element.Sprite;

public abstract class MotionlessElement extends Element implements IActionOnLorann, IMotionLess {
	
	/**
	 * char symbol
	 */
	private final char symbol;

	/**
	 * Instantiate Motion Less Element
	 * @param sprite
	 * @param permeability
	 * @param symbol
	 */
	public MotionlessElement(final Sprite sprite, final Permeability permeability, final char symbol) {
		super(sprite, permeability);
		this.symbol = symbol;
	}

	/**
	 * get Symbol
	 * @return char
	 */
	public char getSymbol() {
		return this.symbol;
	}
	
	/**
	 * get Image
	 * @return Image
	 */
	public Image getImage() {
		return this.getSprite().getImage();
	}

	/**
	 * get Action on Lorann
	 * @return ActionOnLorann
	 */
	public ActionOnLorann getActionOnLorann() {
		return ActionOnLorann.NOP;
	}
}
