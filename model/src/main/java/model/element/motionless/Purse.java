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

	public void setPoints() {
		switch(this.getModel().getSizeMaxMonsters()-this.getModel().mobiles.size()) {
			case 0:
				this.points += 650;
				break;
			case 1:
				this.points += 620;
				break;
			case 2 :
				this.points += 590;
				break;
			case 3 :
				this.points += 560;
				break;
			case 4 :
				this.points += 530;
				break;
		}
	}
}