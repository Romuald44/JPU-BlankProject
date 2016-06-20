package model;

public class Score extends Entity {

	/** The Score. */
	private int score;

	/**
	 * Instantiates a new Score.
	 *
	 * @param score
	 *          the Score
	 */
	public Score(final int score) {
		this.setScore(score);
	}

	/**
	 * Instantiates a new score.
	 */
	public Score() {
		this(0);
	}
	
	/**
	 * Gets the Score.
	 *
	 * @return the Score
	 */
	public int getScore() {
		return this.score;
	}

	/**
	 * Sets the Score.
	 *
	 * @param score
	 *          the new Score
	 */
	public void setScore(final int score) {
		this.score = score;
	}
	
	

}
