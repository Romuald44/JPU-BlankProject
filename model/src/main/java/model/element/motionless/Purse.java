package model.element.motionless;

public class Purse extends MotionlessElement {

	public Purse() {
		super(new Sprite("purse.png"), Permeability.PENETRABLE, 'p');
	}

	@Override
	public ActionOnHeroes getActionOnHeroes() {
		return ActionOnHeroes.RECOVERABLE;
	}

}