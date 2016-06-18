package model.element.mobile;

import model.Model;
import model.element.Sprite;

public class MonsterThree implements IBehavior {
	
	private Sprite sprite;

	/* Monstre qui reste près d'un mur */
	public MonsterThree() {
		this.sprite = new Sprite("monster_3.png");
	}

	public void movement(Lorann lorann, Demons demons, Model model) {
		// TODO Auto-generated method stub
		
	}
	
	public Sprite getSprite() {
		return sprite;
	}
}
