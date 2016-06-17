package model.element.mobile;

import java.awt.Point;

import model.element.Sprite;

public class MonsterTwo implements IBehavior {
	
	private Sprite sprite;

	/* Monstre déplacement random */
	public MonsterTwo() {
		this.sprite = new Sprite("monster_2.png");
	}

	public void movement(Lorann lorann, Point demons) {
		// TODO Auto-generated method stub
		
	}

	public Sprite getSprite() {
		return sprite;
	}
}
