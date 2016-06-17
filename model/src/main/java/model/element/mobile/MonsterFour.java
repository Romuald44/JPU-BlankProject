package model.element.mobile;

import java.awt.Point;

import model.element.Sprite;

public class MonsterFour implements IBehavior {
	
	private Sprite sprite;

	/* Monstre qui ne se déplace pas en diagonale */
	public MonsterFour() {
		this.sprite = new Sprite("monster_4.png");
	}

	public void movement(Lorann lorann, Point demons) {
		// TODO Auto-generated method stub
		
	}

	public Sprite getSprite() {
		return sprite;
	}
}
