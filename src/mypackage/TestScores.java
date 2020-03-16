package mypackage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class TestScores {
	ScoreCalculator mySC = new ScoreCalculator();
	@Test
	void test() {
		// TODO Auto-generated method 
		System.out.println("Bowling Scores");
		
	    assertEquals(87,  mySC.printScores("John 4 3 10 0 4 5 1 3 0 4 2 5 8 0 9 1 6 2 2 3"),"John failed"); // strike and spares in the middle frames - 87
	    assertEquals(100, mySC.printScores("Erin 4 3 10 0 4 5 1 3 0 4 2 5 8 0 9 1 6 2 10 0 2 6"),"Erin failed");  // strike in the 10th - 100
	    assertEquals(108, mySC.printScores("Snickers 4 3 10 0 4 5 1 3 0 4 2 5 8 0 9 1 6 2 10 0 10 6"),"Snickers failed");  // strike in the 10th and 11 - 108
	    assertEquals(102, mySC.printScores("Bell 4 3 10 0 4 5 1 3 0 4 2 5 8 0 9 1 6 2 10 0 6 4"),"Belle failed");  // strike in the 10th and spare in 11 -102
	    assertEquals(102, mySC.printScores("Alex 4 3 10 0 4 5 1 3 0 4 2 5 8 0 9 1 6 2 2 8 10"),"Alex failed");  // spare in the 10th strike in 11 - 102 
	    assertEquals(98,  mySC.printScores("Fluff 4 3 10 0 4 5 1 3 0 4 2 5 8 0 9 1 6 2 2 8 6 4"),"Fluff failed");  // spare in the 10th spare in 11 - 98
	    assertEquals(300, mySC.printScores("Tim 10 0 10 0 10 0 10 0 10 0 10 0 10 0 10 0 10 0 10 0 10 10"),"Tim failed");  // all strikes - 300
	}

}
