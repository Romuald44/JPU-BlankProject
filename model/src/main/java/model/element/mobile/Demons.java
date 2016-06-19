package model.element.mobile;

import java.awt.Point;
import java.util.ArrayList;

import contract.ActionOnLorann;
import contract.IActionOnLorann;
import contract.IMobile;
import model.Model;
import model.element.motionless.Land;

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
		boolean temp;
		while(this.getThreadActive()) {
			temp = false;
			while(!temp) {
				Point positionDemons = this.behavior.movement(this.getModel().getLorann(), new Point(this.getPosition()));
				if(this.getModel().getElements(positionDemons.x, positionDemons.y) instanceof Land) {
					this.setPosition(positionDemons);
					temp = true;
				} else if(this.getModel().getElements(positionDemons.x, this.getPosition().y) instanceof Land) {
					this.position.x = positionDemons.x;
					temp = true;
				} else if(this.getModel().getElements(this.getPosition().x, positionDemons.y) instanceof Land) {
					this.position.y = positionDemons.y;
					temp = true;
				}
			}
			getMobilesAnswer();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int i = 0; i < this.getModel().getMobiles().size(); i++) {
			if(this.getModel().getMobiles().get(i) == this) {
				this.getModel().removeMobile(i);
			}
		}
	}
}
