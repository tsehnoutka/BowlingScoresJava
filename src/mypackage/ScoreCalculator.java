package mypackage;
import static java.lang.System.out;

public class ScoreCalculator {
	private String[] iss;
		
		public ScoreCalculator ()
			{
			}  //  end constructor

		public int printScores(String in)
		{
			iss = in.split(" ");
			int iTotalScore=0;
			int frameScore=0;
			int ball1=0;
			int ball2 = 0;
			int x=0;
			int iFrame=1;
			int iArrayLength=iss.length;
			Boolean print11thFrame=false;
			Boolean strikeIn10th =false;
			out.println("Name: " + iss[0]);
			out.println("Frame\tBall 1\tBall2\tScore");
			
			for ( x=1; x< iArrayLength && 11 > iFrame; ) //   Starting at 1 because the first element contained the name
			{
				//  print frame
				System.out.format("%d\t", iFrame);
				
				ball1 = Integer.parseInt(iss[x]);
				ball2 = Integer.parseInt(iss[x+1]);
				
				if ( 10==ball1)  //  STRIKE
				{
					out.print("X\t\t");  // print ball
					frameScore+=10;
					int ball3= Integer.parseInt(iss[x+2]);
					if (10==ball3 && 10 != iFrame)  // another strike,  need to move to the NEXT frame  (unless if I am in the 10th frame)
						frameScore+=10+Integer.parseInt(iss[x+4]);
					else
						frameScore+=ball3+Integer.parseInt(iss[x+3]);
					
					//  if 10th Frame
					if (10 == iFrame)
					{
						print11thFrame=true;
						strikeIn10th=true;
					}
				
				}  //  end if STRIKE
				else if (10 == ball1+ball2)  // SPARE
				{
					out.format("%d\t\\\t",ball1);  // print ball
					frameScore= 10 + Integer.parseInt(iss[x+2]);

					//  if 10th Frame
					if (10 == iFrame)
					{
						print11thFrame=true;
					}
				}  //  end if SPARE
				else
				{
					out.format("%d\t%d\t",ball1,ball2);  // print ball
					frameScore = ball1+ball2;
				}
				
				iTotalScore = iTotalScore+frameScore;
				frameScore = 0;
				iFrame++; //  keep track of frames	
				x=x+2; // move to the next frame in the array 2 balls at a time
				out.format("%d\n", iTotalScore); //  finish up the line 
				
			}  //  end going through array
			if (print11thFrame)
			{
				out.print("11\t");
				ball1 = Integer.parseInt(iss[x]);
				out.format("%d\t", ball1);
				if (strikeIn10th)
				{
					ball2 = Integer.parseInt(iss[x+1]);
					out.format("%d\t", ball2);
				}
				out.println("");
			}//  end if 10th frame
			
			out.format("%s's score was: %d\n\n\n", iss[0], iTotalScore );
			return iTotalScore;
		} //  end Print Scores
		
		
	public static void main(String[] args) 
	{
		// TODO Auto-generated method 
		System.out.println("Bowling Scores");
		ScoreCalculator sJohn = new ScoreCalculator();     // strike and spares in the middle frames - 87
	    ScoreCalculator sErin = new ScoreCalculator();	   // strike in the 10th - 100
	    ScoreCalculator sSnickers = new ScoreCalculator(); // strike in the 10th and 11 - 108
	    ScoreCalculator sBell = new ScoreCalculator();	   // strike in the 10th and spare in 11 -102
	    ScoreCalculator sAlex = new ScoreCalculator();	   // spare in the 10th strike in 11 - 102    
	    ScoreCalculator sFluff = new ScoreCalculator();	   // spare in the 10th spare in 11 - 98
	    ScoreCalculator sTim = new ScoreCalculator();	   // all strikes - 300
		
	    sJohn.printScores("John 4 3 10 0 4 5 1 3 0 4 2 5 8 0 9 1 6 2 2 3");
	    sErin.printScores("Erin 4 3 10 0 4 5 1 3 0 4 2 5 8 0 9 1 6 2 10 0 2 6");
	    sSnickers.printScores("Snickers 4 3 10 0 4 5 1 3 0 4 2 5 8 0 9 1 6 2 10 0 10 6");
	    sBell.printScores("Bell 4 3 10 0 4 5 1 3 0 4 2 5 8 0 9 1 6 2 10 0 6 4");
	    sAlex.printScores("Alex 4 3 10 0 4 5 1 3 0 4 2 5 8 0 9 1 6 2 2 8 10");
	    sFluff.printScores("Fluff 4 3 10 0 4 5 1 3 0 4 2 5 8 0 9 1 6 2 2 8 6 4");
	    sTim.printScores("Tim 10 0 10 0 10 0 10 0 10 0 10 0 10 0 10 0 10 0 10 0 10 10");
	
	} //  end main
}
