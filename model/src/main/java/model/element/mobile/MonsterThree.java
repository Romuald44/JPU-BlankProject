package model.element.mobile;

import java.awt.Point;

import model.Model;
import model.element.Sprite;

public class MonsterThree implements IBehavior {
	
	private Sprite sprite;

	/* Monstre qui reste près d'un mur */
	public MonsterThree() {
		this.sprite = new Sprite("monster_3.png");
	}

	public Point movement(Lorann lorann, Point demons) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
}
