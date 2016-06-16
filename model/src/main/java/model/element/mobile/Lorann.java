package model.element.mobile;

import java.awt.Point;
import java.util.ArrayList;

import contract.ILorann;
import contract.ControllerOrder;
import model.Model;
import model.element.Sprite;

public class Lorann extends Mobile implements ILorann {

	private Point lastPosition;
	private Fireball fireball;
	private ArrayList<ControllerOrder> orders;

	public Lorann(int x, int y, Model model) {
		super(new Sprite("lorann_b.png"));
		this.setModel(model);
		this.fireball = new Fireball(this, model);
		this.setX(x);
		this.setY(y);
	}
	
	public ArrayList<ControllerOrder> getOrders() {
		return orders;
	}
	
	public void addOrder(ControllerOrder order) {
		this.orders.add(order);
	}

	public void removeOrder(ControllerOrder order) {
		this.orders.remove(order);
	}
	public boolean isOrder(ControllerOrder order) {
		return this.orders.contains(order);
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
