package model.element.mobile;

import java.awt.Point;

import model.Model;
import model.element.Sprite;

public interface IBehavior {

	public void movement(Lorann lorann, Demons demons, Model model);

	public Sprite getSprite();
}
