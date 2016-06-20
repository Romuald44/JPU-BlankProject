package contract;

import javax.swing.JFrame;

/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
 */
public interface IView {

	
	public JFrame getViewFrame();
	public void printMessage(String message);
	public void Swing();
}
