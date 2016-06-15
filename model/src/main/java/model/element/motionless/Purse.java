package model.element.motionless;

import model.element.Permeability;
import model.element.Sprite;

public class Purse extends MotionlessElement {

	public Purse() {
		super(new Sprite("purse.png"), Permeability.PENETRABLE, 'p');
	}

	@Override
	public ActionOnLorann getActionOnLorann() {
		return ActionOnLorann.RECOVERABLE;
	}

}