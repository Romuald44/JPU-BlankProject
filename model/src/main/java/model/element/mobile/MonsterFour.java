package model.element.mobile;

import java.awt.Point;
import java.util.Random;

import model.Model;
import model.element.Sprite;
import model.element.motionless.Gate;
import model.element.motionless.Land;
import model.element.motionless.Purse;

public class MonsterFour implements IBehavior {
	
	private Sprite sprite;
	private Point direction = new Point(1,1);

	/* Monstre qui ne se déplace pas en diagonale */
	public MonsterFour() {
		this.sprite = new Sprite("monster_4.png");
	}
	
	public void movement(Lorann lorann, Demons demons, Model model) {
		Random rand = new Random();
		int nombreAleatoire = rand.nextInt(4);
		System.out.println(nombreAleatoire);
		
		if(nombreAleatoire == 1) {
			direction.x *= 1;
		}
		else if(nombreAleatoire == 2) {
			direction.x *= -1;
		}
		else if(nombreAleatoire == 3) {
			direction.y *= 1;
		}
		else if(nombreAleatoire == 4) {
			direction.y *= -1;
		}
		if(demons.isMovePossible((int) demons.getPosition().getX(), (int) demons.getPosition().getY())) {
			if(direction.x == 1) {
				demons.getPosition().x++;
			}
			else if(direction.x == -1) {
				demons.getPosition().x--;
			}
			else if(direction.y == 1) {
				demons.getPosition().y++;
			}
			else if(direction.y == -1) {
				demons.getPosition().y--;
			}
			/*if((model.getElements((int) demons.getPosition().getX()+1, (int) demons.getPosition().getY()) instanceof Land) ||
			(model.getElements((int) demons.getPosition().getX()+1, (int) demons.getPosition().getY()) instanceof Gate)	) {
				demons.getPosition().x += direction.x;
				demons.getPosition().y += direction.y;
			}
			else {
				demons.getPosition().x++;
			}*/
		}
	}

	public Sprite getSprite() {
		return sprite;
	}

	
}
