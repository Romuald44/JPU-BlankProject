package model.element.mobile;

import model.element.Sprite;

public class MonsterThree implements IBehavior {
	
	private Sprite sprite;

	/* Monstre qui reste près d'un mur */
	public MonsterThree() {
		this.sprite = new Sprite("monster_3.png");
	}

	public void movement() {
	}

	public Sprite getSprite() {
		return sprite;
	}
}
