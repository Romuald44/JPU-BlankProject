package model.element.mobile;

import java.awt.Image;
import java.awt.Point;

import contract.IMobile;
import model.element.Element;
import model.element.Permeability;
import model.element.Sprite;

public abstract class Mobile extends Element implements IMobile, Runnable {
	/**
	 * Point position
	 */
	protected Point position;
	
	/**
	 * Thread thread
	 */
	private Thread thread;
	
	/**
	 * Boolean threadActive
	 */
	private boolean threadActive;

	/**
	 * Instantiate Mobile
	 * @param sprite
	 */
	public Mobile(final Sprite sprite) {
		super(sprite, Permeability.BLOCKING);
		this.position = new Point();
		this.threadActive = true;
	}

	/**
	 * get X
	 * @return position x
	 */
	public int getX() {
		return this.position.x;
	}

	/**
	 * get y 
	 * @return position y
	 */
	public int getY() {
		return this.position.y;
	}

	/**
	 * set position X
	 * @param x
	 */
	protected void setX(final int x) {
		if ((x >= 0) && (x < this.getModel().getWidth())) {
			this.position.x = x;
			this.getModel().setMobileHasChanged();
		}
	}

	/**
	 * set position Y
	 * @param y
	 */
	protected void setY(final int y) {
		if ((y >= 0) && (y < this.getModel().getHeight())) {
			this.position.y = y;
			this.getModel().setMobileHasChanged();
		}
	}
	
	/**
	 * get Thread
	 * @return Thread
	 */
	public Thread getThread() {
		return this.thread;
	}
	
	/**
	 * set Thread
	 * @param mobile
	 */
	public void setThread(Runnable mobile) {
		this.thread = new Thread(mobile);
	}
	
	/**
	 * start Thread
	 */
	public void startThread() {
		this.thread.start();
	}

	/**
	 * get Image
	 * @return Image
	 */
	public Image getImage() {
		return this.getSprite().getImage();
	}

	/**
	 * get Thread Active
	 */
	public boolean getThreadActive() {
		return this.threadActive;
	}

	/**
	 * set Thread Active
	 * @param active
	 */
	public void setThreadActive(boolean active) {
		this.threadActive = active;
	}

	/**
	 * get Position
	 * @return Point
	 */
	public Point getPosition() {
		return this.position;
	}
	
	/**
	 * set Position
	 * @param position
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	/**
	 * check if move is possible
	 * @param x
	 * @param y
	 * @return boolean
	 */
	protected boolean isMovePossible(final int x, final int y) {
		return (this.getModel().getElements(x, y).getPermeability() == Permeability.PENETRABLE);
	}

	/**
	 * move Up
	 * @return boolean
	 */
	public boolean moveUp() {
		boolean bool = false;
		if (this.isMovePossible(this.getX(), this.getY() - 1)) {
			this.setY(this.getY() - 1);
			bool = true;
		}
		return bool;
	}

	/**
	 * move Left
	 * @return boolean
	 */
	public boolean moveLeft() {
		boolean bool = false;
		if (this.isMovePossible(this.getX() - 1, this.getY())) {
			this.setX(this.getX() - 1);
			bool = true;
		}
		return bool;
	}

	/**
	 * move Down
	 * @return boolean
	 */
	public boolean moveDown() {
		boolean bool = false;
		if (this.isMovePossible(this.getX(), this.getY() + 1)) {
			this.setY(this.getY() + 1);
			bool = true;
		}
		return bool;
	}

	/**
	 * move Right
	 * @return boolean
	 */
	public boolean moveRight() {
		boolean bool = false;
		if (this.isMovePossible(this.getX() + 1, this.getY())) {
			this.setX(this.getX() + 1);
			bool = true;
		}
		return bool;
	}

	/**
	 * move Up Left
	 * @return boolean
	 */
	public boolean moveUpLeft() {
		boolean bool = false;
		if (this.isMovePossible(this.getX() - 1, this.getY() - 1)) {
			this.setX(this.getX() - 1);
			this.setY(this.getY() - 1);
			bool = true;
		}
		return bool;
	}

	/**
	 * move Up Right
	 * @return boolean
	 */
	public boolean moveUpRight() {
		boolean bool = false;
		if (this.isMovePossible(this.getX() + 1, this.getY() - 1)) {
			this.setX(this.getX() + 1);
			this.setY(this.getY() - 1);
			bool = true;
		}
		return bool;
	}

	/**
	 * move Down Left
	 * @return boolean
	 */
	public boolean moveDownLeft() {
		boolean bool = false;
		if (this.isMovePossible(this.getX() - 1, this.getY() + 1)) {
			this.setX(this.getX() - 1);
			this.setY(this.getY() + 1);
			bool = true;
		}
		return bool;
	}

	/**
	 * move Down Right
	 * @return boolean
	 */
	public boolean moveDownRight() {
		boolean bool = false;
		if (this.isMovePossible(this.getX() + 1, this.getY() + 1)) {
			this.setX(this.getX() + 1);
			this.setY(this.getY() + 1);
			bool = true;
		}
		return bool;
	}
}
