package model.element.motionless;

import contract.ActionOnLorann;
import model.element.Permeability;
import model.element.Sprite;

public class Gate extends MotionlessElement {

	private boolean open = false;
	private ActionOnLorann action = ActionOnLorann.KILL;
	
	public Gate() {
		super(new Sprite("gate_closed.png"), Permeability.PENETRABLE, 'g');
	}

	@Override
	public ActionOnLorann getActionOnLorann() {
		return action;
	}
	
	public void open() {
		if(!open) {
			this.setSprite(new Sprite("gate_open.png"));
			this.setPermeability(Permeability.PENETRABLE);
			this.action = ActionOnLorann.FINISH;
			this.open = true;
		}
	}
	
	public boolean isOpen() {
		return this.open;
	}

}