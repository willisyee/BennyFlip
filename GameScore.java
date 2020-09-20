public class GameScore {
	
	private int score;
	
	
	/**
	 *Constructor 
	 */
	public GameScore() {
		this.score = 0;
	}
	
	/**
	 * Adds an integer from the parameter to an int variable representing the total points so far gained. 
	 * @param integer from generatePoint()
	 * @return int representing total points earned so far
	 */
	public void addScore(int point) {
		int newScore = score + point;
		score = newScore;
		
	}
	
	/**
	 * displays the total score earned by the player in the current game 
	 */
	public void displayCounter() {
		
		System.out.println(score);
	}
	
	/**
	 * This returns the score rather than prints to the console
	 */
	public int returnScore() {
		return score;
	}
}