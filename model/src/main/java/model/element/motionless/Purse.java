package model.element.motionless;

import contract.ActionOnLorann;
import contract.IPurse;
import model.element.Permeability;
import model.element.Sprite;

public class Purse extends MotionlessElement implements IPurse {

	public static int points = 0;
	
	public Purse() {
		super(new Sprite("purse.png"), Permeability.PENETRABLE, 'p');
	}

	@Override
	public ActionOnLorann getActionOnLorann() {
		return ActionOnLorann.RECOVERABLE;
	}

	public void setPoints(int points) {
		this.points += points;
	}
}