package model.element.motionless;

import model.element.Permeability;
import model.element.Sprite;

public class Gate extends MotionlessElement {

	private boolean open = false;
	
	public Gate() {
		super(new Sprite("gate_closed.png"), Permeability.BLOCKING, 'g');
	}

	@Override
	public ActionOnLorann getActionOnLorann() {
		return ActionOnLorann.KILL;
	}
	
	public void open() {
		if(!open) {
			this.open = true;
		}
	}
	
	public boolean isOpen() {
		return this.open;
	}

}