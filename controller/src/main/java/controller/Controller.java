package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller implements IController {

	/** The view. */
	private IView view;

	/** The model. */
	private IModel model;
	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
		model.loadMap(1);
		this.view.Swing();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see contract.IController#control()
	 */
	public void control() {
		//this.view.printMessage("Appuyer sur les touches 'E', 'F', 'D' ou 'I', pour afficher Hello world dans la langue de votre choix.");
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 *          the new view
	 */
	private void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
			case UP:
				this.model.moveUp();
				break;
			case DOWN:
				this.model.moveDown();
				break;
			case LEFT:
				this.model.moveLeft();
				break;
			case RIGHT:
				this.model.moveRight();
				break;
			case SPACE:
				this.model.launchFireball();
				break;
			default:
				break;
		}
	}

}
