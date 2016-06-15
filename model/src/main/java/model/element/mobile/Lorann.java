package model.element.mobile;

import java.awt.Point;

import model.element.Sprite;

public class Lorann extends Mobile {

	private Point lastPosition;
	private Fireball fireball;

	public Lorann() {
		super(new Sprite("lorann_b"));
		this.fireball = new Fireball(this);
	}

	public Point getLastPosition() {
		return this.lastPosition;
	}

	private void setLastPosition(Point lastPosition) {
		this.lastPosition = lastPosition;
	}

	public Fireball getFireball() {
		return this.fireball;
	}

	public void setFireball(Fireball fireball) {
		this.fireball = fireball;
	}

	public void launchFireball() {
		this.fireball.reactivate();
	}
	
	public void disableFireball() {
		this.fireball.deactivate();
	}
	
	public void deviateFireball() {
		this.fireball.deviate();
	}
	
	public void moveFireball() {
		this.fireball.move();
	}

	public void death() {
	}
}
