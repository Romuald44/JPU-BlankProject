package model.element.mobile;

import model.Model;
import model.element.Sprite;
import model.element.motionless.Gate;
import model.element.motionless.Purse;

public class MonsterFour implements IBehavior {
	
	private Sprite sprite;

	/* Monstre qui ne se déplace pas en diagonale */
	public MonsterFour() {
		this.sprite = new Sprite("monster_4.png");
	}
	
	public void movement(Lorann lorann, Demons demons, Model model) {
		if(demons.isMovePossible((int) demons.getPosition().getX()+1, (int) demons.getPosition().getY())) {
			if((model.getElements((int) demons.getPosition().getX()+1, (int) demons.getPosition().getY()) instanceof Purse) ||
			(model.getElements((int) demons.getPosition().getX()+1, (int) demons.getPosition().getY()) instanceof Gate)	) {
				demons.getPosition().x--;
			}
			else {
				demons.getPosition().x++;
			}
		}
	}

	public Sprite getSprite() {
		return sprite;
	}

	
}
