package model.element.motionless;

import contract.ActionOnLorann;
import contract.IPurse;
import model.element.Permeability;
import model.element.Sprite;

public class Purse extends MotionlessElement implements IPurse {

	private int points = 650;
	
	public Purse() {
		super(new Sprite("purse.png"), Permeability.PENETRABLE, 'p');
	}

	@Override
	public ActionOnLorann getActionOnLorann() {
		return ActionOnLorann.RECOVERABLE;
	}
	
	public int getPoints() {
		return this.points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
}