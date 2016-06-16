package model.element.motionless;

import model.element.Permeability;
import model.element.Sprite;

public class Land extends MotionlessElement {

	public Land() {
		super(new Sprite("land.png"), Permeability.PENETRABLE, ' ');
	}

}