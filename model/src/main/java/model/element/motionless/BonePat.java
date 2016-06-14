package model.element.motionless;

public class BonePat extends MotionlessElement {

	public BonePat() {
		super(new Sprite("bone.png"), Permeability.BLOCKING, 'o');
	}

}