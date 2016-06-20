package model.element.mobile;

import java.awt.Point;
import java.util.ArrayList;

import contract.ILorann;
import model.Model;
import model.element.Sprite;

public class Lorann extends Mobile implements ILorann {

	/**
	 * Point lastposition
	 */
	private Point lastPosition;
	
	/**
	 * Fireball fireball
	 */
	private Fireball fireball;
	
	/**
	 * ArrayList sprites
	 */
	private ArrayList<String> sprites;

	/**
	 * Instantiate Lorann
	 * @param x
	 * @param y
	 * @param model
	 */
	public Lorann(int x, int y, Model model) {
		super(new Sprite("lorann_b.png"));
		this.setModel(model);
		this.lastPosition = new Point();
		this.sprites = new ArrayList<String>();
		this.sprites.add("lorann_b.png");
		this.sprites.add("lorann_bl.png");
		this.sprites.add("lorann_l.png");
		this.sprites.add("lorann_ul.png");
		this.sprites.add("lorann_u.png");
		this.sprites.add("lorann_ur.png");
		this.sprites.add("lorann_r.png");
		this.sprites.add("lorann_br.png");
		this.setThreadActive(true);
		try {
			this.setX(x);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			this.setY(y);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * get last position
	 * @return Point
	 */
	public Point getLastPosition() {
		return this.lastPosition;
	}

	/**
	 * set last position
	 * @param lastPosition
	 */
	public void setLastPosition(Point lastPosition) {
		this.lastPosition = lastPosition;
	}

	/**
	 * set last position 
	 * @param x
	 * @param y
	 */
	public void setLastPosition(final int x, final int y) {
		this.lastPosition.x = x;
		this.lastPosition.y = y;
	}

	/**
	 * get fireball
	 * @return Fireball
	 */
	public Fireball getFireball() {
		return this.fireball;
	}

	/**
	 * set Fireball
	 * @param fireball
	 */
	public void setFireball(Fireball fireball) {
		this.fireball = fireball;
	}

	/**
	 * launch Fireball
	 */
	public void launchFireball() {
		this.fireball.reactivate();
	}

	/**
	 * disable Fireball
	 */
	public void disableFireball() {
		this.fireball.deactivate();
	}

	/**
	 * deviate Fireball
	 */
	public void deviateFireball() {
		this.fireball.deviate();
	}

	/**
	 * loop run
	 */
	public void run() {
		int indice = 0;
		while(this.getThreadActive()) {
			this.setSprite(new Sprite(this.sprites.get(indice)));
			indice++;
			if(indice == 7) {
				indice = 0;
			}
			this.getModel().setMobileHasChanged();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
