package model.element.motionless;

import model.element.Element;
import model.element.Permeability;
import model.element.Sprite;

public abstract class MotionlessElement extends Element implements IActionOnLorann {
	private final char symbol;

	public MotionlessElement(final Sprite sprite, final Permeability permeability, final char symbol) {
		super(sprite, permeability);
		this.symbol = symbol;
	}
	
	public MotionlessElement(final Permeability permeability, final char symbol) {
		super(permeability);
		this.symbol = symbol;
	}

	public char getSymbol() {
		return this.symbol;
	}

	public ActionOnLorann getActionOnLorann() {
		return ActionOnLorann.NOP;
	}
}
