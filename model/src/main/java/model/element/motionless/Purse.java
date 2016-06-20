package model.element.motionless;

import contract.ActionOnLorann;
import contract.IPurse;
import model.element.Permeability;
import model.element.Sprite;

public class Purse extends MotionlessElement implements IPurse {

	/**
	 * int Points
	 */
	public static int points = 0;
	
	/**
	 * Instantiate Purse
	 */
	public Purse() {
		super(new Sprite("purse.png"), Permeability.PENETRABLE, 'p');
	}

	@Override
	public ActionOnLorann getActionOnLorann() {
		return ActionOnLorann.RECOVERABLE;
	}

	/**
	 * set Points
	 */
	public void setPoints() {
		int cpt = 0;
		for(int i = 0; i < this.getModel().getMobiles().size(); i++) {
			if(this.getModel().getMobiles().get(i).getThreadActive()) {
				cpt++;
			}
		}
		switch(this.getModel().mobiles.size()-cpt) {
			case 0:
				Purse.points += 650;
				break;
			case 1:
				Purse.points += 620;
				break;
			case 2 :
				Purse.points += 590;
				break;
			case 3 :
				Purse.points += 560;
				break;
			case 4 :
				Purse.points += 530;
				break;
		}
	}
}
