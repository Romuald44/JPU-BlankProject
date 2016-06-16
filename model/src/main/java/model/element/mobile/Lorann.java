package model.element.mobile;

import java.awt.Point;

import contract.ILorann;
import model.Model;
import model.element.Sprite;

public class Lorann extends Mobile implements ILorann {

	private Point lastPosition;
	private Fireball fireball;

	public Lorann(int x, int y, Model model) {
		super(new Sprite("lorann_b.png"));
		this.setModel(model);
		this.fireball = new Fireball(this, model);
		this.setX(x);
		this.setY(y);
	}

	public Point getLastPosition() {
		return this.lastPosition;
	}

	public void setLastPosition(Point lastPosition) {
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
