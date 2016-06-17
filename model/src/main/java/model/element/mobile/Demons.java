package model.element.mobile;

import contract.ActionOnLorann;
import contract.IActionOnLorann;
import model.Model;

public class Demons extends Mobile implements IActionOnLorann {

	private IBehavior behavior;

	public Demons(IBehavior behavior, int x, int y, Model model) {
		super(behavior.getSprite());
		this.setModel(model);
		this.behavior = behavior;
		this.setX(x);
		this.setY(y);
	}

	public void execMovement() {
		this.behavior.movement();
	}

	public ActionOnLorann getActionOnLorann() {
		return ActionOnLorann.KILL;
	}
}
