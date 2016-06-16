package model.element.mobile;

import java.awt.Point;

import contract.IFireball;
import model.Model;
import model.element.Sprite;

public class Fireball extends Mobile implements IFireball, Runnable {

	private Point direction;
	private boolean active;
	private Lorann lorann;

	public Fireball(Lorann lorann, Model model) {
		super(new Sprite("fireball_1.png"));
		this.setModel(model);
		this.lorann = lorann;
		this.active = false;
		this.getModel().startThreadFireball(this);
	}

	public boolean getActive() {
		return this.active;
	}

	public void reactivate() {
		this.active = true;
		System.out.println("X : "+this.lorann.getLastPosition().x+" Y : "+this.lorann.getLastPosition().y);
		this.setX(this.lorann.getLastPosition().x);
		this.setY(this.lorann.getLastPosition().y);
		System.out.println("X : "+this.getX()+" Y : "+this.getY());
		this.direction.x = lorann.getLastPosition().x - lorann.getPosition().x;
		this.direction.y = lorann.getLastPosition().y - lorann.getPosition().y;
	}

	public void deactivate() {
		this.active = false;
	}

	public void deviate() {
		if(this.active == true) {
			if(this.lorann.getPosition().x < this.getPosition().x) {
				this.direction.x = -1;
			}
			else if(this.lorann.getPosition().x > this.getPosition().x) {
				this.direction.x = 1;
			}
			else {
				this.direction.x = 0;
			}
			
			if(this.lorann.getPosition().y < this.getPosition().y) {
				this.direction.y = -1;
			}
			else if(this.lorann.getPosition().y > this.getPosition().y) {
				this.direction.y = 1;
			}
			else {
				this.direction.y = 0;
			}
		}
	}

	public void run() {
		if(this.active) {
			boolean bool = false;
			if(this.direction.x != 0 && this.direction.y == 0) {
				switch(this.direction.x) {
				case -1:
					bool = this.moveLeft();
					if(!bool) {
						this.direction.x = 1;
					}
					break;
				case 1:
					bool = this.moveRight();
					if(!bool) {
						this.direction.x = -1;
					}
					break;
				}
			}
			else if(this.direction.x == 0 && this.direction.y != 0) {
				switch(this.direction.y) {
				case -1:
					bool = this.moveUp();
					if(!bool) {
						this.direction.y = 1;
					}
					break;
				case 1:
					bool = this.moveDown();
					if(!bool) {
						this.direction.y = -1;
					}
					break;
				}
			}
			else if(this.direction.x != 0 && this.direction.y != 0){
				switch(this.direction.x) {
				case -1:
					switch(this.direction.y) {
					case -1:
						bool = this.moveUpLeft();
						if(!bool) {
							this.direction.x = 1;
							this.direction.y = 1;
						}
						break;
					case 1:
						bool = this.moveDownLeft();
						if(!bool) {
							this.direction.x = 1;
							this.direction.y = -1;
						}
						break;
					}
					break;
				case 1:
					switch(this.direction.y) {
					case -1:
						bool = this.moveUpRight();
						if(!bool) {
							this.direction.x = -1;
							this.direction.y = 1;
						}
						break;
					case 1:
						bool = this.moveDownRight();
						if(!bool) {
							this.direction.x = -1;
							this.direction.y = -1;
						}
						break;
					}
					break;
				}
			}
		}
	}
}
