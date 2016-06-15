package contract;

import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Load the message.
	 *
	 * @param key
	 *          the key
	 */
	void loadMap(int id);
	
	public void moveUp();
	public void moveDown();
	public void moveLeft();
	public void moveRight();
	
	public void setMobileHasChanged();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
}
