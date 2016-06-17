package model.element.mobile;

import java.awt.Point;

import model.element.Sprite;

public interface IBehavior {

	public void movement(Lorann lorann, Point demons);

	public Sprite getSprite();
}
