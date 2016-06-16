package model.element.mobile;

import java.awt.Point;
import java.util.ArrayList;

import contract.ILorann;
import model.Model;
import model.element.Sprite;

public class Lorann extends Mobile implements ILorann, Runnable {

	private Point lastPosition;
	private Fireball fireball;
	private ArrayList<String> sprites;

	public Lorann(int x, int y, Model model) {
		super(new Sprite("lorann_b.png"));
		this.setModel(model);
		this.lastPosition = new Point();
		this.fireball = new Fireball(this, model);
		this.sprites = new ArrayList<String>();
		this.sprites.add("lorann_b.png");
		this.sprites.add("lorann_bl.png");
		this.sprites.add("lorann_l.png");
		this.sprites.add("lorann_ul.png");
		this.sprites.add("lorann_u.png");
		this.sprites.add("lorann_ur.png");
		this.sprites.add("lorann_r.png");
		this.sprites.add("lorann_br.png");
		this.setX(x);
		this.setY(y);
		this.getModel().startThreadLorann(this);
	}

	public Point getLastPosition() {
		return this.lastPosition;
	}

	public void setLastPosition(Point lastPosition) {
		this.lastPosition = lastPosition;
	}

	public void setLastPosition(final int x, final int y) {
		this.lastPosition.x = x;
		this.lastPosition.y = y;
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

	public void death() {
	}

	public void run() {
		int indice = 0;
		while(true) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.setSprite(new Sprite(this.sprites.get(indice)));
			indice++;
			if(indice == 7) {
				indice = 0;
			}
			this.getModel().setMobileHasChanged();
		}
	}
}
