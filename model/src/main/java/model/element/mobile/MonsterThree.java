package model.element.mobile;

import java.awt.Point;

import model.element.Sprite;

public class MonsterThree implements IBehavior {
	
	private Sprite sprite;

	/* Monstre qui reste près d'un mur */
	public MonsterThree() {
		this.sprite = new Sprite("monster_3.png");
	}

	public void movement(Lorann lorann, Point demons) {
	}

	public Sprite getSprite() {
		return sprite;
	}
}
