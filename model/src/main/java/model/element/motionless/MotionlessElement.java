package model.element.motionless;
import model.element.Element;

public abstract class MotionlessElement extends Element {
	private final char symbol;

	public MotionlessElement(final Sprite sprite, final Permeability permeability, final char symbol) {
		super(sprite, permeability);
		this.symbol = symbol;
	}

	public char getSymbol() {
		return this.symbol;
	}

	@Override
	public ActionOnHeroes getActionOnHeroes() {
		return ActionOnHeroes.NOP;
	}
}
