package contract;

import java.awt.Image;
import java.awt.Point;

public interface IMobile {

	public int getX();
	public int getY();
	public Image getImage();
	public Point getPosition();
	public Thread getThread();
	public void setThread(Runnable mobile);
	public void startThread();
	public void setThreadActive(boolean active);
}
