package backend;

import java.io.Serializable;

public class PlayerFeedback implements Serializable {

	private static final long serialVersionUID = -3445887382336801372L;
	
	private String precedingPlayer;
	private int scoreDelta;
	private int position;
	private boolean wasCorrect;
	private Question question;
	
	/**
	 * Create new instance
	 * @param player Nickname of player ahead of this player
	 * @param delta Score difference between this player and the player ahead
	 * @param wasCorrect Whether the player answered this question correctly
	 * @param position Player's current position in the leaderboard
	 * @param question The question that was just answered
	 */
	public PlayerFeedback(String player, int delta, boolean wasCorrect, int position, Question question) {
		precedingPlayer = player;
		scoreDelta = delta;
		this.wasCorrect = wasCorrect;
		this.position = position;
		this.question = question;
	}
	
	public Question getQuestion() {
		return question;
	}
	
	public int getPosition() {
		return position;
	}
	
	public boolean answerWasCorrect() {
		return wasCorrect;
	}
	
	public String getPrecedingPlayer() {
		return precedingPlayer;
	}
	
	public int getScoreDelta() {
		return scoreDelta;
	}

}