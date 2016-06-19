package model.element.mobile;

import java.awt.Point;

import model.Model;
import model.element.Sprite;

public class MonsterTwo implements IBehavior {
	
	private Sprite sprite;

	/* Monster random movement */
	public MonsterTwo() {
		this.sprite = new Sprite("monster_2.png");
	}

	public Point movement(Lorann lorann, Point demons, Model model) {
		int rand = (int)(Math.random() * 8) + 1; 
		switch(rand){
		case 1:
			demons.x = demons.x + 1;
			return demons;
		case 2:
			demons.x = demons.x - 1;
			return demons;
		case 3:
			demons.y = demons.y + 1;
			return demons;
		case 4:
			demons.y = demons.y - 1;
			return demons;
		case 5:
			demons.x = demons.x + 1;
			demons.y = demons.y + 1;
			return demons;
		case 6:
			demons.x = demons.x - 1;
			demons.y = demons.y + 1;
			return demons;
		case 7:
			demons.x = demons.x + 1;
			demons.y = demons.y - 1;
			return demons;
		case 8:
			demons.x = demons.x - 1;
			demons.y = demons.y - 1;
			return demons;
		default :
			return demons;
		}
	}

	public Sprite getSprite() {
		return sprite;
	}
}
