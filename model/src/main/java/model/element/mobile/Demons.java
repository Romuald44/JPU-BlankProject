package model.element.mobile;

import contract.ActionOnLorann;
import contract.IActionOnLorann;
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

	public void run() {
		while(this.getThreadActive()) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.behavior.movement(this.getModel().getLorann(), this, this.getModel());
		}
	}
}
