import java.util.ArrayList;

public class OthelloGame
{
	private OthelloPlayer humanPlayer;		//human Othello player
	private OthelloPlayer compPlayer;		//computer Othello player
	private Grid board;						//board

	//----------------------------------------------------------------------------------
	public OthelloGame()
	{
	
		//testing entire game with a 4 x 4
		board = new BoundedGrid(6);

		//testing entire game with an 8 x8 instead of 4 x 4. Try this after 4 x 4 works.
		//board = new BoundedGrid(8);

		humanPlayer = new HumanOthelloPlayer("Human", "B");
		//humanPlayer = new StupidComputerPlayer("Competer1", "B");
		compPlayer = new StupidComputerPlayer("Computer", "W");

		initializeBoard();
	}
	//----------------------------------------------------------------------------------
	//Description:  This method places the "B"'s and "W"'s in the appropriate 
	// 				place on the game board. Pretend you don't know the size of 
	// 				the board - i.e. write generically.

	//Postcondition: "B"'s and "W"'s are placed in the appropriate place on the
	//				 board.

	private void initializeBoard()
	{
		
		board.put(new Location( board.getNumRows() / 2 , board.getNumCols() / 2 ), "B");
		board.put(new Location( board.getNumRows() / 2 - 1 , board.getNumCols() / 2 - 1 ), "B");
		
		board.put(new Location( board.getNumRows() / 2 - 1 , board.getNumCols() / 2 ), "W");
		board.put(new Location( board.getNumRows() / 2 , board.getNumCols() / 2 - 1 ), "W");
		
	}
	//----------------------------------------------------------------------------------
	/*
	The playGame method (below) has the players alternate moves until the board is filled or both
	players have no legal moves.  A winner is then declared.

	When it's the human's turn, all legal moves are displayed on the screen.  If there are legal
	moves, the human is asked for a move (in another method).  The move is made and the board is
	reconfigured according to the rules of the game.  If there are no legal moves, display a message
	stating there are no legal moves. Switch the player.

	When it's the computer's turn, all legal moves are displayed on the screen.  If there are legal
	moves, a random move is selected (not in this method).   The move is made and the board is
	reconfigured according to the rules of the game.  If there are no legal moves display a message
	stating there are no legal moves. Switch the player.

	This method calls other methods to help do its job.
	*/

	public void playGame()
	{
		boolean hasWon  = false;
		OthelloPlayer curPlayer = humanPlayer;
		OthelloPlayer otherPlayer = compPlayer;
		Location theMove = null;

		while (hasWon == false)	//keep playing while the game is not over
		{
			board.display();
			System.out.println("It is " + curPlayer.getName() + "'s turn.");
			
			ArrayList <Location> legalMoves = getLegalMoves(curPlayer.getColor());
			//System.out.println(legalMoves);
			if(legalMoves.size() == 0)
			{
				System.out.println("There are no moves left");
			}
			else
			{
				System.out.println(legalMoves);
				theMove = curPlayer.getMove(legalMoves);
				System.out.println("MOVING TO: " + theMove);
				updateBoard(theMove, curPlayer.getColor());
			}
			if(getLegalMoves(curPlayer.getColor()).size() == 0 && getLegalMoves(otherPlayer.getColor()).size() == 0 )
			{
				hasWon = true;
			}
			
			if(curPlayer.equals(humanPlayer)  )
			{
				curPlayer = compPlayer;
				otherPlayer = humanPlayer;
			}
			else
			{
				curPlayer = humanPlayer;
				otherPlayer = compPlayer;
			}
		}
		
		board.display();
		if(getColorCount(humanPlayer.getColor()) > getColorCount(compPlayer.getColor()) )
		{
			System.out.println(humanPlayer.getName() + " has won.");
		}
		else
		{
			System.out.println(compPlayer.getName() + " has won.");
		}
	}

	
	//----------------------------------------------------------------------------------
	public ArrayList<Location> getLegalMoves(String curColor)
	{
		ArrayList<Location> legalMoves = new ArrayList <Location>();
		ArrayList<Location> occupied = board.getOccupiedLocs();	//all occupied slots
		ArrayList<Location> curColorLocs = new ArrayList <Location>();
		
		//Find all locations with the current color
		for(int i = 0; i < occupied.size(); i++)
		{
			if( (board.get(occupied.get(i))).equals(curColor)    )
			{
				curColorLocs.add(occupied.get(i));
			}
		}
		//Loops through ArrayList containing all Locations of the current color. 
		for(int i = 0; i < curColorLocs.size(); i++)
		{
			Location original = curColorLocs.get(i);
			ArrayList<Location> occAdj = board.getOccupiedAdjacentLocs(curColorLocs.get(i));	//creates ArrayList of all slots Occupied and Adjacent 
			for(int j = 0; j < occAdj.size(); j++)												//to the current Location. Loops through each of these slots.
			{
				Location curCheck = occAdj.get(j);		//set to slot of initial direction
				int curDir = original.getDirectionToward(curCheck);
				
				//while curCheck is valid AND string in curCheck is not null AND string in curCheck does not equal the current color
				while(board.isValid(curCheck)  && board.get(curCheck) != null &&  !(board.get(curCheck).equals(curColor)) )
				{
					//System.out.println("Current Direction: " + curDir);
					//System.out.println(curCheck);
					if(curCheck == null)
					{
						legalMoves.add(curCheck);
					}
					curCheck = curCheck.getAdjacentLoc(curDir);
					
				}
				if(board.isValid(curCheck) && board.get(curCheck) == null)
				{
					legalMoves.add(curCheck);
				}	
			}
		}
		//Remove Duplicates
		for(int i = 0; i < legalMoves.size(); i++) 
		{
			for(int j = i + 1; j < legalMoves.size(); j++) 
			{
				if(legalMoves.get(i).equals(legalMoves.get(j)))
				{
					legalMoves.remove(j);
					j--;
				}
			}
		}
		
		return legalMoves;

	}
	//----------------------------------------------------------------------------------

	public void updateBoard(Location nextMove, String targetString)
	{
		ArrayList <Location> toFlip = new ArrayList<Location>();
		ArrayList <Location> occAdj = board.getOccupiedAdjacentLocs(nextMove);
		Location curCheck = null;
		
		board.put(nextMove, targetString);
		
		for(int i = 0; i < occAdj.size() ; i++)
		{
			curCheck = occAdj.get(i);
			int curDir = nextMove.getDirectionToward(curCheck);
			//
			while(board.isValid(curCheck) && board.get(curCheck) != null && !(board.get(curCheck).equals(targetString)) )
			{
				toFlip.add(curCheck);
				curCheck = curCheck.getAdjacentLoc(curDir);
			}
			//
			if(board.isValid(curCheck) && board.get(curCheck) != null && board.get(curCheck).equals(targetString) )
			{
				//Flips the appropriate pieces.
				for(int j = 0; j < toFlip.size(); j++)
				{
					board.put(toFlip.get(j), targetString);
				}
			}
			toFlip = new ArrayList<Location>();
		}

	}
	//----------------------------------------------------------------------------------
	
	public int getColorCount(String theTarget)
	{
		int colorCount = 0;
		ArrayList <Location> occupied = board.getOccupiedLocs();
		for(int i = 0; i < occupied.size(); i++)
		{
			if( (board.get(occupied.get(i))).equals(theTarget) )
			{
				colorCount++;
			}
		}
		
		return colorCount;
	}
	
}