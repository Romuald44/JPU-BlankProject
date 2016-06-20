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
	 * @throws Exception
	 */
	protected void setX(final int x) throws Exception {
		if ((x >= 0) && (x < this.getModel().getWidth())) {
			this.position.x = x;
			this.getModel().setMobileHasChanged();
		}
		else {
			throw new Exception("Out of range");
		}
	}

	/**
	 * set position Y
	 * @param y
	 * @throws Exception
	 */
	protected void setY(final int y) throws Exception {
		if ((y >= 0) && (y < this.getModel().getHeight())) {
			this.position.y = y;
			this.getModel().setMobileHasChanged();
		}
		else {
			throw new Exception("Out of range");
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
	 * @throws Exception
	 */
	protected boolean isMovePossible(final int x, final int y) throws Exception {
		return (this.getModel().getElements(x, y).getPermeability() == Permeability.PENETRABLE);
	}

	/**
	 * move Up
	 * @return boolean
	 */
	public boolean moveUp() {
		boolean bool = false;
		try {
			if (this.isMovePossible(this.getX(), this.getY() - 1)) {
				this.setY(this.getY() - 1);
				bool = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}

	/**
	 * move Left
	 * @return boolean
	 */
	public boolean moveLeft() {
		boolean bool = false;
		try {
			if (this.isMovePossible(this.getX() - 1, this.getY())) {
				this.setX(this.getX() - 1);
				bool = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}

	/**
	 * move Down
	 * @return boolean
	 */
	public boolean moveDown() {
		boolean bool = false;
		try {
			if (this.isMovePossible(this.getX(), this.getY() + 1)) {
				this.setY(this.getY() + 1);
				bool = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}

	/**
	 * move Right
	 * @return boolean
	 */
	public boolean moveRight() {
		boolean bool = false;
		try {
			if (this.isMovePossible(this.getX() + 1, this.getY())) {
				this.setX(this.getX() + 1);
				bool = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}

	/**
	 * move Up Left
	 * @return boolean
	 */
	public boolean moveUpLeft() {
		boolean bool = false;
		try {
			if (this.isMovePossible(this.getX() - 1, this.getY() - 1)) {
				this.setX(this.getX() - 1);
				this.setY(this.getY() - 1);
				bool = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}

	/**
	 * move Up Right
	 * @return boolean
	 */
	public boolean moveUpRight() {
		boolean bool = false;
		try {
			if (this.isMovePossible(this.getX() + 1, this.getY() - 1)) {
				this.setX(this.getX() + 1);
				this.setY(this.getY() - 1);
				bool = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}

	/**
	 * move Down Left
	 * @return boolean
	 */
	public boolean moveDownLeft() {
		boolean bool = false;
		try {
			if (this.isMovePossible(this.getX() - 1, this.getY() + 1)) {
				this.setX(this.getX() - 1);
				this.setY(this.getY() + 1);
				bool = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}

	/**
	 * move Down Right
	 * @return boolean
	 */
	public boolean moveDownRight() {
		boolean bool = false;
		try {
			if (this.isMovePossible(this.getX() + 1, this.getY() + 1)) {
				this.setX(this.getX() + 1);
				this.setY(this.getY() + 1);
				bool = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bool;
	}
}
