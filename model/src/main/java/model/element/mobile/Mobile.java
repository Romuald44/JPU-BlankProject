package model.element.mobile;

import java.awt.Point;

import model.element.Element;
import model.element.Permeability;
import model.element.Sprite;

public abstract class Mobile extends Element {
	private Point position;

	public Mobile(final Sprite sprite) {
		super(sprite, Permeability.BLOCKING);
		this.position = new Point();
	}

	public int getX() {
		return this.position.x;
	}

	public int getY() {
		return this.position.y;
	}

	protected void setX(final int x) {
		if ((x >= 0) && (x < this.getNettleWorld().getWidth())) {
			this.position.x = x;
			this.getModel().setMobileHasChanged();
		}
	}

	protected void setY(final int y) {
		if ((y >= 0) && (y < this.getNettleWorld().getHeight())) {
			this.position.y = y;
			this.getModel().setMobileHasChanged();
		}
	}

	public Point getPosition() {
		return this.position;
	}

	private boolean isMovePossible(final int x, final int y) {
		return (this.getModel().getElements(x, y).getPermeability() != Permeability.BLOCKING);
	}

	public void moveUp() {
		if (this.isMovePossible(this.getX(), this.getY() - 1)) {
			this.setY(this.getY() - 1);
		}
	}

	public void moveLeft() {
		if (this.isMovePossible(this.getX() - 1, this.getY())) {
			this.setX(this.getX() - 1);
		}
	}

	public void moveDown() {
		if (this.isMovePossible(this.getX(), this.getY() + 1)) {
			this.setY(this.getY() + 1);
		}
	}

	public void moveRight() {
		if (this.isMovePossible(this.getX() + 1, this.getY())) {
			this.setX(this.getX() + 1);
		}
	}

	public void moveUpLeft() {
		if (this.isMovePossible(this.getX() - 1, this.getY() - 1)) {
			this.setX(this.getX() - 1);
			this.setY(this.getY() - 1);
		}
	}

	public void moveUpRight() {
		if (this.isMovePossible(this.getX() + 1, this.getY() - 1)) {
			this.setX(this.getX() + 1);
			this.setY(this.getY() - 1);
		}
	}

	public void moveDownLeft() {
		if (this.isMovePossible(this.getX() - 1, this.getY() + 1)) {
			this.setX(this.getX() - 1);
			this.setY(this.getY() + 1);
		}
	}

	public void moveDownRight() {
		if (this.isMovePossible(this.getX() + 1, this.getY() + 1)) {
			this.setX(this.getX() + 1);
			this.setY(this.getY() + 1);
		}
	}
}
