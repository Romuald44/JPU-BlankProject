package model.element.mobile;

public class Demons extends Mobile {

	private IBehavior behavior;

	public Demons(IBehavior behavior, int x, int y) {
		super(behavior.getSprite());
		this.behavior = behavior;
		this.setX(x);
		this.setY(y);
	}

	public void execMovement() {
		this.behavior.movement();
	}
}
