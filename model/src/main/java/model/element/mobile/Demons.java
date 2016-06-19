package model.element.mobile;

import java.awt.Point;
import java.util.ArrayList;

import contract.ActionOnLorann;
import contract.IActionOnLorann;
import contract.IMobile;
import model.Model;
import model.element.Permeability;

public class Demons extends Mobile implements IActionOnLorann {

	private IBehavior behavior;

	public Demons(IBehavior behavior, int x, int y, Model model) {
		super(behavior.getSprite());
		this.setModel(model);
		this.behavior = behavior;
		this.setThreadActive(true);
		this.setX(x);
		this.setY(y);
	}

	public ActionOnLorann getActionOnLorann() {
		return ActionOnLorann.KILL;
	}
	
	protected boolean isMovePossible(final int x, final int y) {
		return (this.getModel().getElements(x, y).getPermeability() == Permeability.PENETRABLE);
	}
	
	private void getMobilesAnswer() {
		if(this.getModel().getLorann() != null) {
			ArrayList<IMobile> mobiles = this.getModel().getMobiles();
			for(int i = 0; i < mobiles.size(); i++) {
				if((mobiles.get(i).getPosition().getX() == this.getModel().getLorann().getX()) &&
						(mobiles.get(i).getPosition().getY() == this.getModel().getLorann().getY()) &&
						mobiles.get(i) instanceof IActionOnLorann) {
					this.getModel().setStateThreadFinish();
					this.getModel().setDeath(true);
				}
			}
		}
	}

	public void run() {
		while(this.getThreadActive()) {
			Point PositionDemons = this.behavior.movement(this.getModel().getLorann(), new Point(this.getPosition()));
			if(this.isMovePossible(PositionDemons.x, PositionDemons.y)){
				this.setPosition(PositionDemons);
			} else if(this.isMovePossible(PositionDemons.x, getPosition().y)) {
				this.position.x = PositionDemons.x;
			} else if(this.isMovePossible(getPosition().x, PositionDemons.y)) {
				this.position.y = PositionDemons.y;
			}
			getMobilesAnswer();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
