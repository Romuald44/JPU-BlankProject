package model.element.motionless;

import contract.ActionOnLorann;
import model.element.Permeability;
import model.element.Sprite;

public class CrystalBall extends MotionlessElement {

	/**
	 * Instantiate Crystall Ball
	 */
	public CrystalBall() {
		super(new Sprite("crystal_ball.png"), Permeability.PENETRABLE, 'c');
	}

	@Override
	public ActionOnLorann getActionOnLorann() {
		return ActionOnLorann.OPEN_GATE;
	}

}