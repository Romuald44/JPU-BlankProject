package model.element.mobile;

import java.awt.Point;

import model.element.Sprite;

public class Fireball extends Mobile {

	private Point direction;
	private boolean active;
	private Lorann lorann;

	public Fireball(Lorann lorann) {
		super(new Sprite("fireball_1"));
		this.lorann = lorann;
		this.reactivate();
	}

	public boolean getActive() {
		return active;
	}

	public void reactivate() {
		this.active = true;
		this.direction.x = lorann.getLastPosition().x - lorann.getPosition().x;
		this.direction.y = lorann.getLastPosition().y - lorann.getPosition().y;
	}

	public void deactivate() {
		this.active = false;
	}
	
	public void move() {
		if(this.active = true) {
			if(this.direction.x != 0 && this.direction.y == 0) {
				switch(this.direction.x) {
				case -1:
					this.moveLeft();
					break;
				case 1:
					this.moveRight();
					break;
				}
			}
			else if(this.direction.x == 0 && this.direction.y != 0) {
				switch(this.direction.y) {
				case -1:
					this.moveUp();
					break;
				case 1:
					this.moveDown();
					break;
				}
			}
			else if(this.direction.x != 0 && this.direction.y != 0){
				switch(this.direction.x) {
				case -1:
					switch(this.direction.y) {
					case -1:
						this.moveUpLeft();
						break;
					case 1:
						this.moveDownLeft();
						break;
					}
					break;
				case 1:
					switch(this.direction.y) {
					case -1:
						this.moveUpRight();
						break;
					case 1:
						this.moveDownRight();
						break;
					}
					break;
				}
			}
		}
	}
}
