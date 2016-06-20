package model.element.mobile;

import java.awt.Point;
import java.util.ArrayList;

import contract.IFireball;
import model.Model;
import model.element.Sprite;
import model.element.motionless.Land;

public class Fireball extends Mobile implements IFireball {

	/**
	 * Point direction
	 */
	private Point direction;
	
	/**
	 * boolean active
	 */
	private boolean active;
	
	/**
	 * Lorann lorann
	 */
	private Lorann lorann;
	
	/**
	 * ArrayList sprites
	 */
	private ArrayList<String> sprites;

	/**
	 * Instantiate Fireball
	 * @param lorann
	 * @param model
	 */
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
		this.setThreadActive(true);
	}

	/**
	 * get Active
	 * @return active
	 */
	public boolean getActive() {
		return this.active;
	}
	
	/**
	 * get Direction
	 * @return direction
	 */
	public Point getDirection() {
		return this.direction;
	}

	/**
	 * re active fireball
	 */
	public void reactivate() {
		this.active = true;
		try {
			this.setX(this.lorann.getX());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.setY(this.lorann.getY());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.direction.x = lorann.getLastPosition().x - lorann.getPosition().x;
		this.direction.y = lorann.getLastPosition().y - lorann.getPosition().y;
	}

	/**
	 * de activate fireball
	 */
	public void deactivate() {
		this.active = false;
	}

	/**
	 * change direction fireball
	 */
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

	/**
	 * loop run
	 */
	public void run() {
		int indice = 0;
		boolean bool = false;
		while(this.getThreadActive()) {
			if(this.getActive()) {
				this.setSprite(new Sprite(this.sprites.get(indice)));
				indice++;
				if(indice == 4) {
					indice = 0;
				}
				bool = false;
				if(this.direction.x != 0 && this.direction.y == 0) {
					switch(this.direction.x) {
					case -1:
						try {
							if(this.getModel().getElements(this.getX()+direction.x, this.getY()+direction.y) instanceof Land) {
								bool = this.moveLeft();
								if(!bool) {
									this.direction.x = 1;
								}
							}
							else {
								this.direction.x = 1;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					case 1:
						try {
							if(this.getModel().getElements(this.getX()+direction.x, this.getY()+direction.y) instanceof Land) {
								bool = this.moveRight();
								if(!bool) {
									this.direction.x = -1;
								}
							}
							else {
								this.direction.x = -1;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					}
				}
				else if(this.direction.x == 0 && this.direction.y != 0) {
					switch(this.direction.y) {
					case -1:
						try {
							if(this.getModel().getElements(this.getX()+direction.x, this.getY()+direction.y) instanceof Land) {
								bool = this.moveUp();
								if(!bool) {
									this.direction.y = 1;
								}
							}
							else {
								this.direction.y = 1;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					case 1:
						try {
							if(this.getModel().getElements(this.getX()+direction.x, this.getY()+direction.y) instanceof Land) {
								bool = this.moveDown();
								if(!bool) {
									this.direction.y = -1;
								}
							}
							else {
								this.direction.y = -1;
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						break;
					}
				}
				else if(this.direction.x != 0 && this.direction.y != 0){
					switch(this.direction.x) {
					case -1:
						switch(this.direction.y) {
						case -1:
							try {
								if(this.getModel().getElements(this.getX()+direction.x, this.getY()+direction.y) instanceof Land) {
									bool = this.moveUpLeft();
									if(!bool) {
										this.direction.x = 1;
										this.direction.y = 1;
									}
								}
								else {
									this.direction.x = 1;
									this.direction.y = 1;
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							break;
						case 1:
							try {
								if(this.getModel().getElements(this.getX()+direction.x, this.getY()+direction.y) instanceof Land) {
									bool = this.moveDownLeft();
									if(!bool) {
										this.direction.x = 1;
										this.direction.y = -1;
									}
								}
								else {
									this.direction.x = 1;
									this.direction.y = -1;
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							break;
						}
						break;
					case 1:
						switch(this.direction.y) {
						case -1:
							try {
								if(this.getModel().getElements(this.getX()+direction.x, this.getY()+direction.y) instanceof Land) {
									bool = this.moveUpRight();
									if(!bool) {
										this.direction.x = -1;
										this.direction.y = 1;
									}
								}
								else {
									this.direction.x = -1;
									this.direction.y = 1;
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							break;
						case 1:
							try {
								if(this.getModel().getElements(this.getX()+direction.x, this.getY()+direction.y) instanceof Land) {
									bool = this.moveDownRight();
									if(!bool) {
										this.direction.x = -1;
										this.direction.y = -1;
									}
								}
								else {
									this.direction.x = -1;
									this.direction.y = -1;
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
							break;
						}
						break;
					}
				}
				for(int i = 0; i < this.getModel().getMobiles().size(); i++) {
					if(this.getModel().getMobiles().get(i).getX() == this.getX() &&
							this.getModel().getMobiles().get(i).getY() == this.getY() &&
							this.getModel().getMobiles().get(i) instanceof Lorann) {
						this.deactivate();
						this.getModel().setMobileHasChanged();
					}
					if(this.getModel().getMobiles().get(i).getX() == this.getX() &&
							this.getModel().getMobiles().get(i).getY() == this.getY() &&
							this.getModel().getMobiles().get(i).getThreadActive() &&
							this.getModel().getMobiles().get(i) instanceof Demons) {
						this.deactivate();
						this.getModel().getMobiles().get(i).setThreadActive(false);
						this.getModel().setMobileHasChanged();
					}
				}
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			this.getModel().setMobileHasChanged();
		}
	}
}
