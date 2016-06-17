package model.element.mobile;

import java.awt.Point;
import java.util.ArrayList;

import contract.IFireball;
import model.Model;
import model.element.Sprite;

public class Fireball extends Mobile implements IFireball, Runnable {

	private Point direction;
	private boolean active;
	private Lorann lorann;
	private ArrayList<String> sprites;

	public Fireball(Lorann lorann, Model model) {
		super(new Sprite("fireball_1.png"));
		this.setModel(model);
		this.lorann = lorann;
		this.active = false;
		this.direction = new Point();
		this.sprites = new ArrayList<String>();
		this.sprites.add("fireball_1.png");
		this.sprites.add("fireball_2.png");
		this.sprites.add("fireball_3.png");
		this.sprites.add("fireball_4.png");
		this.sprites.add("fireball_5.png");
		this.getModel().startThreadFireball(this);
	}

	public boolean getActive() {
		return this.active;
	}

	public void reactivate() {
		this.active = true;
		this.setX(this.lorann.getLastPosition().x);
		this.setY(this.lorann.getLastPosition().y);
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
		int indice = 0;
		while(true) {
			//if(this.getActive()) {
				this.setSprite(new Sprite(this.sprites.get(indice)));
				indice++;
				if(indice == 4) {
					indice = 0;
				}
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
				this.getModel().setMobileHasChanged();
				for(int i = 0; i < this.getModel().getMobiles().size(); i++) {
					if(this.getModel().getMobiles().get(i).getX() == this.getX() &&
							this.getModel().getMobiles().get(i).getY() == this.getY() &&
							this.getModel().getMobiles().get(i) instanceof Demons) {
						this.getModel().removeMobile(i);
						this.getModel().setMobileHasChanged();
					}
					if(this.getModel().getMobiles().get(i).getX() == this.getX() &&
							this.getModel().getMobiles().get(i).getY() == this.getY() &&
							this.getModel().getMobiles().get(i) instanceof Lorann) {
						this.deactivate();
						this.getModel().setMobileHasChanged();
					}
				}
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		//}
	}
}
