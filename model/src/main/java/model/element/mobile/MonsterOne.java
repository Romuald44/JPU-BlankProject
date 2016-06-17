package model.element.mobile;

import java.awt.Point;

import model.element.Sprite;

public class MonsterOne implements IBehavior {
	
	private Sprite sprite;

	/* Monstre déplacement vers Lorann*/
	public MonsterOne() {
		this.sprite = new Sprite("monster_1.png");
	}

	public void movement(Lorann lorann, Point demons) {
		// TODO Auto-generated method stub
		
	}

	public Sprite getSprite() {
		return sprite;
	}
}
