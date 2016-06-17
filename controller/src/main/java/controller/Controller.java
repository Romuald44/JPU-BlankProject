package controller;

import java.util.ArrayList;
import java.util.Scanner;

import contract.ControllerOrder;
import contract.IController;
import contract.IMobile;
import contract.IModel;
import contract.IView;
import contract.IActionOnLorann;

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
		this.selectLevel();
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
	
	public void selectLevel() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please select a level :");
		int str = scanner.nextInt();
		this.model.loadMap(str);
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
		if(this.model.getTheadFireball().getState() == Thread.State.NEW) {
			this.model.startThreadsMobiles();
		}
		if((this.model.getTheadFireball().getState() == Thread.State.RUNNABLE) ||
		(this.model.getTheadFireball().getState() == Thread.State.TIMED_WAITING)) {
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
			this.getElementAnswer();
			this.getMobilesAnswer();
		}
	}
	
	private void getElementAnswer() {
		final IActionOnLorann element = (IActionOnLorann) this.model.getElements(this.model.getLorann().getX(), this.model.getLorann().getY());

		switch (element.getActionOnLorann()) {
			case RECOVERABLE:
				this.model.setPointsPurse();
				this.model.replaceLand(this.model.getLorann().getX(), this.model.getLorann().getY());
				System.out.println("Recuperer Purse");
				break;
			case OPEN_GATE:
				this.model.openTheDoor();
				this.model.replaceLand(this.model.getLorann().getX(), this.model.getLorann().getY());
				System.out.println("Open the door");
				break;
			case KILL:
				this.model.setDeath(true);
				//this.view.printMessage("YOU DIED");
				this.model.setStateThreadFinish();
				System.out.println("You died");
				break;
			case FINISH:
				this.model.setTheEnd(true);
				//this.view.printMessage("FINISH");
				this.model.setStateThreadFinish();
				System.out.println("Finish");
				break;
			case NOP:
			default:
				break;
		}
	}
	
	private void getMobilesAnswer() {
		ArrayList<IMobile> mobiles = this.model.getMobiles();
		for(int i = 0; i < mobiles.size(); i++) {
			if((mobiles.get(i).getPosition().getX() == this.model.getLorann().getX()) &&
					(mobiles.get(i).getPosition().getY() == this.model.getLorann().getY()) &&
					mobiles.get(i) instanceof IActionOnLorann) {
				this.model.setDeath(true);
			}
		}
	}
}
