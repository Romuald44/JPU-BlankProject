package view;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class View.
 */
public class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
	}

	/**
	 * Show window
	 */
	public void Swing() {
		SwingUtilities.invokeLater(this);
	}
	
	/**
	 * get ViewFrame
	 * @return ViewFrame
	 */
	public ViewFrame getViewFrame() {
		return this.viewFrame;
	}
	
	/**
	 * print message
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_UP:
				return ControllerOrder.UP;
			case KeyEvent.VK_DOWN:
				return ControllerOrder.DOWN;
			case KeyEvent.VK_LEFT:
				return ControllerOrder.LEFT;
			case KeyEvent.VK_RIGHT:
				return ControllerOrder.RIGHT;
			case KeyEvent.VK_SPACE:
				return ControllerOrder.SPACE;
			case KeyEvent.VK_NUMPAD1:
				return ControllerOrder.ONE;
			case KeyEvent.VK_NUMPAD2:
				return ControllerOrder.TWO;
			case KeyEvent.VK_NUMPAD3:
				return ControllerOrder.THREE;
			case KeyEvent.VK_NUMPAD4:
				return ControllerOrder.FOUR;
			case KeyEvent.VK_NUMPAD5:
				return ControllerOrder.FIVE;
			default:
				return ControllerOrder.NOP;
		}
	}

	/**
	 * set Visible the window
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}
