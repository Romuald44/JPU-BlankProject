package model.element.motionless;

public class BoneHoriz extends MotionlessElement {

	public BoneHoriz() {
		super(new Sprite("horizontal_bone.png"), Permeability.BLOCKING, '-');
	}

}