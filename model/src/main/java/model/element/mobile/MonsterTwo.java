package model.element.mobile;

import java.awt.Point;

import model.element.Sprite;

public class MonsterTwo implements IBehavior {
	
	private Sprite sprite;

	/* Monster random movement */
	public MonsterTwo() {
		this.sprite = new Sprite("monster_2.png");
	}

	public Point movement(Lorann lorann, Point demons) {
		int rand = (int)(Math.random() * 8) + 1; 
		switch(rand) {
		case 1:
			demons.x++;
			return demons;
		case 2:
			demons.x--;
			return demons;
		case 3:
			demons.y++;
			return demons;
		case 4:
			demons.y--;
			return demons;
		case 5:
			demons.x++;
			demons.y++;
			return demons;
		case 6:
			demons.x--;
			demons.y++;
			return demons;
		case 7:
			demons.x++;
			demons.y--;
			return demons;
		case 8:
			demons.x--;
			demons.y--;
			return demons;
		default :
			return demons;
		}
	}

	public Sprite getSprite() {
		return sprite;
	}
}
