package model;

import java.awt.Point;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import contract.IMobile;
import contract.IModel;
import contract.IMotionLess;
import model.element.Element;
import model.element.mobile.Demons;
import model.element.mobile.Fireball;
import model.element.mobile.Lorann;
import model.element.mobile.Mobile;
import model.element.mobile.MonsterFour;
import model.element.mobile.MonsterOne;
import model.element.mobile.MonsterThree;
import model.element.mobile.MonsterTwo;
import model.element.motionless.Gate;
import model.element.motionless.MotionlessElement;
import model.element.motionless.MotionlessElements;
import model.element.motionless.Purse;

/**
 * The Class Model.
 */
public class Model extends Observable implements IModel {
	
	/** Array MotionlessElement elements */
	public MotionlessElement elements[][];
	
	/** Array IMobile mobiles */
	public final ArrayList<IMobile> mobiles;
	
	/** the width */
	private int width;
	
	/** the height */
	private int	height;
	
	/** the map */
	private Map map;
	
	/** the score */
	private Score score;
	
	/** the finish */
	private boolean finish = false;
	
	/** the dead */
	private boolean dead = false;
	
	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.mobiles = new ArrayList<IMobile>();
	}
	
	/** 
	 * start Threads Mobiles
	 */
	public void startThreadsMobiles() {
		for(int i = 0; i < this.mobiles.size(); i++) {
			this.mobiles.get(i).startThread();
		}
		this.getLorann().getFireball().startThread();
	}
	
	/** 
	 * get Threads Fireball
	 */
	public Thread getThreadFireball() {
		return this.getLorann().getFireball().getThread();
	}
	
	/** 
	 * set State Threads to Finish
	 */
	public void setStateThreadFinish() {
		for(int i = 0; i < this.mobiles.size(); i++) {
			this.mobiles.get(i).setThreadActive(false);
		}
		this.getLorann().getFireball().setThreadActive(false);
	}
	
	/** 
	 * Move Up
	 */
	public void moveUp() {
		int x = this.getLorann().getX();
		int y = this.getLorann().getY();
		if(this.getLorann().moveUp()) {
			this.getLorann().setLastPosition(x, y);
		}
	}
	
	/** 
	 * Move Down
	 */
	public void moveDown() {
		int x = this.getLorann().getX();
		int y = this.getLorann().getY();
		if(this.getLorann().moveDown()) {
			this.getLorann().setLastPosition(x, y);
		}
	}
	
	/** 
	 * Move Left
	 */
	public void moveLeft() {
		int x = this.getLorann().getX();
		int y = this.getLorann().getY();
		if(this.getLorann().moveLeft()) {
			this.getLorann().setLastPosition(x, y);
		}
	}
	
	/** 
	 * Move Right
	 */
	public void moveRight() {
		int x = this.getLorann().getX();
		int y = this.getLorann().getY();
		if(this.getLorann().moveRight()) {
			this.getLorann().setLastPosition(x, y);
		}
	}
	
	/** 
	 * Move Up Left
	 */
	public void moveUpLeft() {
		Point lastPosition = this.getLorann().getPosition();
		if(this.getLorann().moveUpLeft()) {
			this.getLorann().setLastPosition(lastPosition);
		}
	}
	
	/** 
	 * Move Up Right
	 */
	public void moveUpRight() {
		Point lastPosition = this.getLorann().getPosition();
		if(this.getLorann().moveUpRight()) {
			this.getLorann().setLastPosition(lastPosition);
		}
	}
	
	/** 
	 * Move Down Left
	 */
	public void moveDownLeft() {
		Point lastPosition = this.getLorann().getPosition();
		if(this.getLorann().moveDownLeft()) {
			this.getLorann().setLastPosition(lastPosition);
		}
	}
	
	/** 
	 * Move Down Right
	 */
	public void moveDownRight() {
		Point lastPosition = this.getLorann().getPosition();
		if(this.getLorann().moveDownRight()) {
			this.getLorann().setLastPosition(lastPosition);
		}
	}
	
	/** 
	 * Launch Fireball
	 */
	public void launchFireball() {
		if(!this.getLorann().getFireball().getActive()) {
			this.getLorann().launchFireball();
		}
		else {
			this.getLorann().deviateFireball();
		}
		this.setChanged();
		this.notifyObservers();
	}
	
	/** 
	 * get Map
	 */
	public Map getMap() {
		return this.map;
	}
	
	/** 
	 * add Element
	 * 
	 * @param element
	 * 			the element
	 * 
	 * @param x
	 * 			the x
	 * 
	 * @param y
	 * 			the y
	 * @throws Exception
	 *
	 */
	public void addElement(final IMotionLess element, final int x, final int y) throws Exception {
		if(x < 0 || y < 0 || x >= this.width || y >= this.height) {
			throw new Exception("Out of range");
		}
		else {
			this.elements[x][y] = (MotionlessElement) element;
			if (element != null) {
				((Element) element).setModel(this);
			}
			if(x == 19 && y == 11) {
				this.setChanged();
				this.notifyObservers(this.elements);
			}
		}
	}
	
	/**
	 * Replace position x, y to land
	 */
	public void replaceLand(final int x, final int y) {
		this.elements[x][y] = MotionlessElements.LAND;
		this.setChanged();
		this.notifyObservers(this.elements);
	}
	
	/**
	 * get Points Purse
	 */
	public int getPointsPurse() {
		return Purse.points;
	}
	
	/**
	 * set Points Purse
	 */
	public void setPointsPurse() {
		this.getPurse().setPoints();
	}
	
	/**
	 * set Death
	 * 	@param boolean
	 * 			dead
	 */
	public void setDeath(boolean dead) {
		this.setScore(this.getScore());
		this.dead = dead;
	}
	
	/**
	 * get death
	 */
	public boolean getDeath() {
		return this.dead;
	}
	
	/**
	 * set the end of game
	 * 	@param boolean
	 * 			finish
	 */
	public void setTheEnd(boolean finish) {
		this.setScore(this.getScore());
		this.finish = finish;
	}
	
	/**
	 * get the end
	 */
	public boolean getTheEnd() {
		return this.finish;
	}
	
	/**
	 * get Width
	 */
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * get Height
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * get Element at position x, y
	 * 	@param int
	 * 			x
	 * 	@param int
	 * 			y
	 * @throws Exception
	 */
	public MotionlessElement getElements(final int x, final int y) throws Exception {
		if ((x < 0) || (y < 0) || (x > this.getWidth()) || (y > this.getHeight())) {
			throw new Exception("Out of range");
		}
		return this.elements[x][y];
	}
	
	/**
	 * get Array Element
	 */
	public MotionlessElement[][] getArrayElement() {
		return this.elements;
	}
	
	/**
	 * get Array Mobiles
	 */
	public ArrayList<IMobile> getMobiles() {
		return this.mobiles;
	}
	
	/**
	 * open the door
	 */
	public void openTheDoor() {
		this.getGate().open();	
	}
	
	/**
	 * get Lorann
	 */
	public Lorann getLorann() {
		for(IMobile lorann : mobiles) {
			if(lorann instanceof Lorann) {
				return (Lorann) lorann;
			}
		}
		return null;
	}
	
	/**
	 * get Purse
	 */
	public Purse getPurse() {
		for(int x = 0; x < this.getWidth(); x++) {
			for(int y = 0; y < this.getHeight(); y++) {
				if(this.elements[x][y] instanceof Purse) {
					return (Purse) this.elements[x][y];
				}
			}
		}
		return null;
	}
	
	/**
	 * get Gate
	 */
	private Gate getGate() {
		for(int x = 0; x < this.getWidth(); x++) {
			for(int y = 0; y < this.getHeight(); y++) {
				if(this.elements[x][y] instanceof Gate) {
					return (Gate) this.elements[x][y];
				}
			}
		}
		return null;
	}
	
	/**
	 * close Gate
	 */
	public void closeGate() {
		this.getGate().close();
	}
	
	/**
	 * add mobile
	 * @param mobile
	 * 			the mobile
	 */
	public void addMobile(final Mobile mobile) {
		mobile.setThread(mobile);
		this.mobiles.add(mobile);
		if(mobile instanceof Lorann) {
			Fireball fireball = new Fireball((Lorann)mobile, this);
			((Lorann)mobile).setFireball(fireball);
			fireball.setThread(fireball);
		}
	}
	
	/**
	 * get Score
	 */
	public int getScore() {
		return this.score.getScore()+this.getPointsPurse();
	}
	
	/**
	 * set Score
	 * @param point_score
	 * 			the new score
	 */
	public void setScore(final int point_score) {
		this.score.setScore(point_score);
		try {
			final DAOScore score = new DAOScore(DBConnection.getInstance().getConnection());
			score.update(this.score);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * load Score from database
	 */
	public void loadScore() {
		final DAOScore score;
		try {
			score = new DAOScore(DBConnection.getInstance().getConnection());
			this.score = score.find(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * load map from database
	 * @throws Exception
	 */
	public void loadMap(final int id) throws Exception {
		this.loadScore();
		try {
			final DAOMap Map = new DAOMap(DBConnection.getInstance().getConnection());
			map = Map.find(id);
			String Maptostring = map.getMap();
			this.width = map.getWidth();
			this.height = map.getHeight();
			int numLine = 0;
			this.elements = new MotionlessElement[width][height];
			
			for (int y = 0; y < height; y++) {
				for(int x = 0; x < width; x++) {
					System.out.print(Maptostring.charAt(numLine+x));
					switch(Maptostring.charAt(numLine+x)) {
					case 'l':
						this.addMobile(new Lorann(x, y, this));
						this.addElement(MotionlessElements.LAND, x, y);
						break;
					case '1':
						this.addMobile(new Demons(new MonsterOne(), x, y, this));
						this.addElement(MotionlessElements.LAND, x, y);
						break;
					case '2':
						this.addMobile(new Demons(new MonsterTwo(), x, y, this));
						this.addElement(MotionlessElements.LAND, x, y);
						break;
					case '3':
						this.addMobile(new Demons(new MonsterThree(), x, y, this));
						this.addElement(MotionlessElements.LAND, x, y);
						break;
					case '4':
						this.addMobile(new Demons(new MonsterFour(), x, y, this));
						this.addElement(MotionlessElements.LAND, x, y);
						break;
					default:
						this.addElement(MotionlessElements.getFromSymbol(Maptostring.charAt(numLine+x)), x, y);
						break;
					}
				}
				numLine+=20;
				System.out.println("");
			}
			
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * set changed observer
	 */
	public void setMobileHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
}
