package model.element.motionless;

public class Land extends MotionlessElement {

	public Land() {
		super(new Sprite(""), Permeability.PENETRABLE, ' ');
	}

}