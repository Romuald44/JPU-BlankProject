package model.element.motionless;

import model.element.Permeability;
import model.element.Sprite;

public class BoneVert extends MotionlessElement {

	public BoneVert() {
		super(new Sprite("vertical_bone.png"), Permeability.BLOCKING, '|');
	}

}