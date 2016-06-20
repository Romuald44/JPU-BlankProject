package model.element.motionless;

import contract.ActionOnLorann;
import model.element.Permeability;
import model.element.Sprite;

public class Gate extends MotionlessElement {

	/**
	 * Boolean open
	 */
	private boolean open = false;
	
	/**
	 * ActionOnLorann action
	 */
	private ActionOnLorann action = ActionOnLorann.KILL;
	
	/**
	 * Instantiate Gate
	 */
	public Gate() {
		super(new Sprite("gate_closed.png"), Permeability.PENETRABLE, 'g');
	}

	@Override
	public ActionOnLorann getActionOnLorann() {
		return action;
	}
	
	/**
	 * open the door
	 */
	public void open() {
		if(!this.open) {
			this.setSprite(new Sprite("gate_open.png"));
			this.action = ActionOnLorann.FINISH;
			this.open = true;
		}
	}
	
	/**
	 * close the door
	 */
	public void close() {
		if(this.open) {
			this.setSprite(new Sprite("gate_closed.png"));
			this.action = ActionOnLorann.KILL;
			this.open = false;
		}
	}
	
	/**
	 * check if the door is open
	 * @return boolean
	 */
	public boolean isOpen() {
		return this.open;
	}

}