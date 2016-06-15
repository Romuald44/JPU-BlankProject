package model.element.motionless;

import model.element.Permeability;
import model.element.Sprite;

public class BonePat extends MotionlessElement {

	public BonePat() {
		super(new Sprite("bone.png"), Permeability.BLOCKING, 'o');
	}

}