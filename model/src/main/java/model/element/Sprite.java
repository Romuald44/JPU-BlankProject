package model.element;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	private Image picture;

	public Sprite(final String picture) {
		try {
			this.picture = ImageIO.read(new File("../view/src/main/resources/" + picture));
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	public Image getImage() {
		return this.picture;
	}
}
