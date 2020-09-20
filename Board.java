/**
 * 
 * @author Bethany Hellerich, Jay Maglione, Willis Yee
 * 
 *         This class sets up the logic behind how the game board works.
 * 
 */

public class Board {

	private int[][] board;
	private boolean[][] isFlipped;
	int score;

	public Board() {
		board = new int[5][5];
		isFlipped = new boolean[5][5];
		score = 1;
	}

	/**
	 * resets the is isFlipped 2d array so every spot is set to false
	 */
	public void resetGame() {
		fillGameboard();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				isFlipped[i][j] = false;
			}
		}
		score = 1;
	}

	/**
	 * this method fills the board that the user will see to determine where they
	 * want to flip.
	 */
	public void fillGameboard() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				board[i][j] = 1;
			}
		}
		// Currently this only adds 3 Ben Franklins
		for (int i = 0; i < 3; i++) {
			int x, y;
			do {
				x = (int) (Math.random() * 5);
				y = (int) (Math.random() * 5);
			} while (board[x][y] == 0);
			board[x][y] = 0; // checks to see if the tile is occupied
		}
		// Adds two 2s to the grid behind the cards
		for (int i = 0; i < 2; i++) {
			int x, y;
			do {
				x = (int) (Math.random() * 5);
				y = (int) (Math.random() * 5);
			} while (board[x][y] == 0 || board[x][y] == 2);
			board[x][y] = 2;
		}
		// Adds four 3s to the grid behind the cards
		for (int i = 0; i < 4; i++) {
			int x, y;
			do {
				x = (int) (Math.random() * 5);
				y = (int) (Math.random() * 5);
			} while (board[x][y] == 0 || board[x][y] == 2 || board[x][y] == 3);
			board[x][y] = 3;
		}
	}

	/**
	 * returns place on board for [x][y]
	 * @param x int for row designation
	 * @param y int for column designation
	 * @return board place for board[x][y]
	 */
	public int getBoxNumber(int x, int y) {
		return board[x][y];

	}
	
	/**
	 * returns place on isFlipped for [x][y]
	 * @param x int for row designation
	 * @param y int for column designation
	 * @return 2D array placement for isFlipped[x][y]
	 */
	public boolean isBoxFlipped(int x, int y) {
		return isFlipped[x][y];
	}
	
	/**
	 * determines if isFlipped[x][y] is true, and if not, 
	 * makes it so and multiplies the score by the board placement
	 * @param x int for row designation
	 * @param y int for column designation
	 */
	public void flip(int x, int y) {
		if (!isFlipped[x][y]) {
			isFlipped[x][y] = true;
			score *= board[x][y];
		}
	}
	

	public int getScore() {
		return score;
	}

	/**
	 * when the game is over, the score will either be 0 or 324
	 * @return score as 0 or 324
	 */
	public boolean isOver() {
		return score == 0 || score == 324;
	}
	
	/**
	 * when the player wins the score will be 324
	 * @return score as 324
	 */
	public boolean isWon() {
		return score == 324;
	}

	/**
	 * adds the numbers across the board row
	 * @param row int to designate which row on board
	 * @return sum for all numbers on row
	 */
	public int sumArrayRow(int row) {
		int sum = 0;
		for (int i = 0; i < board[row].length; i++) {
			sum += board[row][i];
		}
		return sum;
	}

	/**
	 * adds the numbers down the board column
	 * @param column int to designate which column on board
	 * @return sum for all numbers on column
	 */
	public int sumArrayColumn(int column) {
		int sum = 0;
		for (int i = 0; i < board.length; i++) {
			sum += board[i][column];
		}
		return sum;
	}

	/**
	 * counts the number of zeroes per row and adds the count to sum
	 * @param row int to designate which row on board
	 * @return sum for 0 column count on row
	 */
	public int bennysArrayRow(int row) {
		int sum = 0;
		for (int i = 0; i < board[row].length; i++) {
			if (board[row][i] == 0)
				sum++;
		}
		return sum;
	}

	/**
	 * counts the number of zeroes per column and adds the count to sum
	 * @param column int to designate which column on board
	 * @return sum for 0 column count
	 */
	public int bennysArrayColumn(int column) {
		int sum = 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i][column] == 0)
				sum++;
		}
		return sum;
	}

}
