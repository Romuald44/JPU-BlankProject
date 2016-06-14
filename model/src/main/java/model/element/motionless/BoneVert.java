package model.element.motionless;

public class BoneVert extends MotionlessElement {

	public BoneVert() {
		super(new Sprite("vertical_bone.png"), Permeability.BLOCKING, '|');
	}

}