package controller;

import java.util.ArrayList;
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
	
	private boolean[] touches;
	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 * @throws Exception
	 */
	public Controller(final IView view, final IModel model) throws Exception {
		this.setView(view);
		this.setModel(model);
		this.touches = new boolean[4];
		this.control();
		this.model.loadMap(1);
		this.view.Swing();
	}

	/**
	 * Message select level.
	 */
	public void control() {
		this.view.printMessage("Please press key between 1 and 5 to choose the level");
	}
	
	/**
	 * select level.
	 *
	 * @param ControllerOrder
	 *          controllerOrder
	 * @throws Exception
	 */
	public void selectLevel(final ControllerOrder controllerOrder) throws Exception {
		this.model.setDeath(false);
		this.model.setTheEnd(false);
		this.model.getMobiles().clear();
		this.model.closeGate();
		this.model.setPointsPurseZero();
		switch (controllerOrder) {
			case ONE:
				this.model.loadMap(1);
				break;
			case TWO:
				this.model.loadMap(2);
				break;
			case THREE:
				this.model.loadMap(3);
				break;
			case FOUR:
				this.model.loadMap(4);
				break;
			case FIVE:
				this.model.loadMap(5);
				break;
			default:
				break;
		}
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

	/**
	 * Move Lorann.
	 *
	 * @param ControllerOrder
	 *          controllerOrder
	 * @throws Exception
	 */
	public void orderPerform(final ControllerOrder controllerOrder) throws Exception {
		if(this.model.getThreadFireball().getState() == Thread.State.NEW) {
			this.model.startThreadsMobiles();//Start all threads
		}
		if((this.model.getThreadFireball().getState() == Thread.State.RUNNABLE) ||
		(this.model.getThreadFireball().getState() == Thread.State.TIMED_WAITING)) {
			switch (controllerOrder) {
				case UP:
					this.touches[0] = true;
					break;
				case DOWN:
					this.touches[1] = true;
					break;
				case LEFT:
					this.touches[2] = true;
					break;
				case RIGHT:
					this.touches[3] = true;
					break;
				case SPACE:
					this.model.launchFireball();// Launch Fireball
					break;
				default:
					break;
			}
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int i = 0; i < 4; i++) {
				if(this.touches[i]) {
					temp.add(i);
				}
			}
			if(temp.size() == 1) {
				switch(temp.get(0)) {
				case 0:
					this.model.moveUp();// Lorann MoveUp
					break;
				case 1:
					this.model.moveDown();// Lorann MoveDown
					break;
				case 2:
					this.model.moveLeft();// Lorann MoveLeft
					break;
				case 3:
					this.model.moveRight();// Lorann MoveRight
					break;
				}
			}
			else if(temp.size() >= 2) {
				switch(temp.get(0)) {
				case 0:
					switch(temp.get(1)) {
					case 2:
						this.model.moveUpLeft();
						break;
					case 3:
						this.model.moveUpRight();
						break;
					}
					break;
				case 1:
					switch(temp.get(1)) {
					case 2:
						this.model.moveDownLeft();
						break;
					case 3:
						this.model.moveDownRight();
						break;
					}
					break;
				}
			}
			this.getElementAnswer();// Check element on map
			this.getMobilesAnswer();// Check mobiles on map
		}
	}
	
	/**
	 * Remove a key.
	 */
	public void removeKey(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
		case UP:
			this.touches[0] = false;
			break;
		case DOWN:
			this.touches[1] = false;
			break;
		case LEFT:
			this.touches[2] = false;
			break;
		case RIGHT:
			this.touches[3] = false;
			break;
		default:
			break;
		}
	}
	
	/**
	 * Get element on map.
	 * @throws Exception
	 */
	private void getElementAnswer() throws Exception {
		final IActionOnLorann element = (IActionOnLorann) this.model.getElements(this.model.getLorann().getX(), this.model.getLorann().getY());
		if(this.model.getLorann() != null) {
			switch (element.getActionOnLorann()) {
				case RECOVERABLE:
					this.model.setPointsPurse();//Set Points in Score
					this.model.replaceLand(this.model.getLorann().getX(), this.model.getLorann().getY());
					System.out.println("Recuperer Purse");
					break;
				case OPEN_GATE:
					this.model.openTheDoor();//Open the door
					this.model.replaceLand(this.model.getLorann().getX(), this.model.getLorann().getY());
					System.out.println("Open the door");
					break;
				case KILL:
					this.model.setStateThreadFinish();
					this.model.setDeath(true);//Lorann dead
					System.out.println("You died");
					break;
				case FINISH:
					this.model.setStateThreadFinish();
					this.model.setTheEnd(true);//Finish the game
					System.out.println("Finish");
					break;
				case NOP:
				default:
					break;
			}
		}
		
	}
	
	/**
	 * Get mobiles on map.
	 */
	private void getMobilesAnswer() {
		if(this.model.getLorann() != null) {
			ArrayList<IMobile> mobiles = this.model.getMobiles();
			for(int i = 0; i < mobiles.size(); i++) {
				if((mobiles.get(i).getPosition().getX() == this.model.getLorann().getX()) &&
						(mobiles.get(i).getPosition().getY() == this.model.getLorann().getY()) &&
						(mobiles.get(i) instanceof IActionOnLorann) && mobiles.get(i).getThreadActive()) {
					this.model.setStateThreadFinish();
					this.model.setDeath(true);
				}
			}
		}
	}
}
