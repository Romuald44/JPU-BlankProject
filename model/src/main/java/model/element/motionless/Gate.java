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
		if(!open) {
			this.setSprite(new Sprite("gate_open.png"));
			this.setPermeability(Permeability.PENETRABLE);
			this.action = ActionOnLorann.FINISH;
			this.open = true;
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