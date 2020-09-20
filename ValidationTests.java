import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.awt.Color;
 

import java.util.Random;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

/**
 * 
 * @author Bethany Hellerich, Jay Maglione, Willis Yee
 *		This is the junit test class testing methods across multiple classes. The coverage of the tests is fairly low as most of the methods 
 *		and classes deal with GUI based objects. Doing some research online, we could not find a non-commercialized integrated GUI testing system 
 *		in eclipse.
 */

class ValidationTests {
	
	
	/**
	 * This test add 5 to score and tests returnScore returns the right value. 
	 */
	@Test
	public void testAddScore() {
		GameScore gs = new GameScore();
		gs.addScore(5);
		assertEquals(gs.returnScore(), 5);
	}
	
	/**
	 * This test ensures the Board number constructor instance variable (sum) is set correctly
	 */
	@Test
	public void testBoardNumbersConstructor() {
		Color c = new Color(255);
		BoardNumbers bn = new BoardNumbers(5, 1, c);
		assertEquals(bn.sum, 5);
		
	}
	
	/**
	 * This test ensures the Board Number constructor instance variable (bennyNumber) is set correctly. 
	 */
	@Test
	public void testBoardNumbersConstructor1() {
		Color c = new Color(255);
		BoardNumbers bn = new BoardNumbers(5, 1, c);
		assertEquals(bn.bennyNumber, 1);
		
	}
	
	/**
	 * This test validates when running the resetGame method that a random tile on the Board is not flipped (false)
	 */
	@Test
	public void testBoardFlipped() {
		Board b = new Board();
		b.resetGame();
		assertEquals(b.isBoxFlipped(1, 1), false);
	}
	
	/**
	 * This test validates the starting score is set to after running the resetGame method. 
	 */
	@Test
	public void testStartingScore() {
		Board b = new Board();
		b.resetGame();
		assertEquals(b.getScore(),1);
	}
	
	
	/**
	 * This test ensures getBoxNumber returns a valid number.
	 */
	@Test
	public void testGetBoxNumber() {
		Board b = new Board();
		
		try{
			int returnedValue = b.getBoxNumber(0, 0);
			assertNotNull(returnedValue);
		}
		catch(Exception e) {
			fail("getBoxNumber not returning a value for a valid grid index.");
		}
		
		
	}
	
	/**
	 * Tests if sumArrayRow method returns a value for a valid grid index.  
	 */
	@Test
	public void testSumArrayRow() {
		Board b = new Board();
		
		try{
			int returnedValue = b.sumArrayRow(0);
			assertNotNull(returnedValue);
		}
		catch(Exception e) {
			fail("sumArrayRow not returning a value for a valid grid index.");
		}
		
		
	}
	
	/**
	 * Tests if sumArraColumn method returns a value for a valid grid index.  
	 */
	@Test
	public void testSumArrayColumn() {
		Board b = new Board();
		
		try{
			int returnedValue = b.sumArrayColumn(0);
			assertNotNull(returnedValue);
		}
		catch(Exception e) {
			fail("sumArrayValue not returning a value for a valid grid index.");
		}
		
		
	}
	
	/**
	 * Tests if BennyArraRow method returns a value for a valid grid index.  
	 */
	@Test
	public void testBennyArrayRow() {
		Board b = new Board();
		
		try{
			int returnedValue = b.bennysArrayRow(0);
			assertNotNull(returnedValue);
		}
		catch(Exception e) {
			fail("bennyArrayRow not returning a value for a valid grid index.");
		}
		
		
	}
	
	/**
	 * Tests if BennyArraColumn method returns a value for a valid grid index.  
	 */
	@Test
	public void testBennyArrayColumn() {
		Board b = new Board();
		
		try{
			int returnedValue = b.bennysArrayColumn(0);
			assertNotNull(returnedValue);
		}
		catch(Exception e) {
			fail("bennyArrayValue not returning a value for a valid grid index.");
		}
		
		
	}
	
	/**
	 * Test Benny Constructor. Tests the one parameter passed in sets it's item instance variable to 1. 
	 */
	@Test
	public void testBennyConstructor() {
		BennyDisplay bd = new BennyDisplay(1);
		assertEquals(bd.item, 1);
	}

	/**
	 * Tests when running the reset method that the score is equal to 1. 
	 */
	@Test
	public void testReset() {
		Board b = new Board();
		assertEquals(b.getScore(),1);
	}
	
	
	@Test
	public void testIfFlipped() {
		Board b = new Board();
		
		b.flip(0, 0);
		assertEquals(b.isBoxFlipped(0, 0), true);
	}
	
	/**
	 * Test sets score to 0 and see if the ifOver method returns true
	 */
	@Test
	public void testIfOver0(){
		Board b = new Board();
		
		b.score = 0;
		
		assertEquals(b.isOver(), true);
	}
	/**
	 * Test sets score equal to the winning score and see if the ifOver method returns true
	 */
	@Test
	public void testIfOver324(){
		Board b = new Board();
		
		b.score = 324;
		
		assertEquals(b.isOver(), true);
	}
	
	/**
	 * Test sets score to a non over triggering score (5) and tests if ifOver returns false
	 */
	@Test
	public void testIfOver(){
		Board b = new Board();
		
		b.score = 5;
		
		assertEquals(b.isOver(), false);
	}
	
	/**
	 * Test ifWon based on score equaling 324. Should return true.
	 */
	@Test
	public void testIfWonTrue(){
		Board b = new Board();
		
		b.score = 324;
		
		assertEquals(b.isWon(), true);
	}
	
	/**
	 * Test ifWon based on a non winning score of 324. Should return false. 
	 */
	@Test
	public void testIfWonFalse(){
		Board b = new Board();
		
		b.score = 3;
		
		assertEquals(b.isWon(), false);
	}
	
}
