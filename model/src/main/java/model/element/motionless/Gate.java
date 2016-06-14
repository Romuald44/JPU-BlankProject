package model.element.motionless;

public class Gate extends MotionlessElement {

	private boolean open = false;
	
	public Gate() {
		super(new Sprite("gate_closed.png"), Permeability.BLOCKING, 'g');
	}

	@Override
	public ActionOnHeroes getActionOnHeroes() {
		return ActionOnHeroes.KILL;
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