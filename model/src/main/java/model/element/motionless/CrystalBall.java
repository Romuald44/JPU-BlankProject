package model.element.motionless;

public class CrystalBall extends MotionlessElement {

	public CrystalBall() {
		super(new Sprite("crystal_ball.png"), Permeability.PENETRABLE, 'c');
	}

	@Override
	public ActionOnHeroes getActionOnHeroes() {
		return ActionOnHeroes.OPEN_GATE;
	}

}