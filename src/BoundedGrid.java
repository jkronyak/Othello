//Jared Kronyak Period 8
import java.util.ArrayList;

public class BoundedGrid implements Grid
{
	private String[][] board;

	//----------------------------------------------------------------------------
	public BoundedGrid(int size)
	{
		board = new String[size][size];
	}
	//----------------------------------------------------------------------------
	//Precondition:
	//Postcondition: Returns the number of rows in this grid.
	public int getNumRows()
	{
		return board.length;
	}

	//----------------------------------------------------------------------------
	//Precondition:
	//Postcondition: Returns the number of columns in this grid.
	public int getNumCols()
	{
		return board[0].length;
	}

	//----------------------------------------------------------------------------
	//Precondition:  loc is not null
	//Postcondition: Returns true if loc is valid in this grid, false otherwise
	public boolean isValid(Location loc)
	{
		if(loc.getRow() < 0 || loc.getRow() >= board.length || loc.getCol() < 0 || loc.getCol() >= board[0].length)
		{
			return false;
		}
		return true;
	}
	//----------------------------------------------------------------------------
	//Precondition:  (1) loc is valid in this grid
	//				 (2) theColor is not null
	//Postcondition:  Puts the String object at loc.
	//				  Returns the object previously at that location.
	public String put(Location loc, String theColor)
	{
		String toReturn = board[loc.getRow()][loc.getCol()];
		board[loc.getRow()][loc.getCol()] = theColor;
		
		return toReturn;
	}
	//----------------------------------------------------------------------------
	//Precondition:  (1) loc is valid in this grid
    //Postcondition: Removes the object at loc.
    //				 returns the object that was removed or null if the location is unoccupied
    public String remove(Location loc)
    {
    	String toReturn = board[loc.getRow()][loc.getCol()];
    	board[loc.getRow()][loc.getCol()] = null;
    	
    	return toReturn;
    }

	//----------------------------------------------------------------------------
	//Precondition:  loc is valid in this grid
	//Postcondition: Returns the String at loc or null if the location is unoccupied.
	public String get(Location loc)
	{
		return board[loc.getRow()][loc.getCol()];
	}
	//----------------------------------------------------------------------------
	//Precondition:
	//Postcondition:  returns an ArrayList of all occupied locations in this grid
    public ArrayList<Location> getOccupiedLocs()
	{
    	ArrayList<Location> occupied = new ArrayList<Location>();
    	
		for(int row = 0; row < board.length; row++)
		{
			for(int col = 0; col < board[0].length; col++)
			{
				if(board[row][col] != null)
				{
					occupied.add(new Location(row, col));
				}
			}
		}
		return occupied;
	}

	//----------------------------------------------------------------------------
	//Precondition:  loc is valid in this grid
	//Postcondition: returns an ArrayList of valid locations adjacent to loc in
	//				 all eight compass directions (north, northeast, east, southeast,
	//				 south, southwest,west, and northwest).
	public ArrayList<Location> getValidAdjacentLocations(Location loc)
    {
		ArrayList<Location> validAdjacent = new ArrayList<Location>();
		for(int i = 0; i < 8; i ++)
		{
			Location newLoc = loc.getAdjacentLoc(i * 45);
			if(isValid(newLoc))
			{
				validAdjacent.add(newLoc);
			}
		}
		return validAdjacent;
    }

	//----------------------------------------------------------------------------

    //Precondition:  loc is valid in this grid
	//Postcondition: returns an ArrayList of valid empty locations adjacent to loc
	//				 in all eight compass directions (north, northeast, east,
	//				 southeast, south, southwest, west, and northwest).
    public ArrayList<Location> getEmptyAdjacentLocations(Location loc)
    {
    	ArrayList<Location> validEmptyAdj = new ArrayList<Location>();
    	validEmptyAdj = getValidAdjacentLocations(loc);
    	
    	for(int i = 0; i < validEmptyAdj.size(); i++)
    	{
    		if(get(validEmptyAdj.get(i)) != null)
    		{
    			validEmptyAdj.remove(i);
    			i--;
    		}
    	}
    	
    	return validEmptyAdj;
    }


	//----------------------------------------------------------------------------
	//Precondition:	  loc is valid in this grid
	//Postcondition:  returns an ArrayList of valid occupied locations adjacent to
	//				  loc in all eight compass directions (north, northeast, east,
	//				  southeast, south, southwest, west, and northwest).
   	public ArrayList<Location> getOccupiedAdjacentLocs(Location loc)
	{
    	ArrayList<Location> validOccAdj = new ArrayList<Location>();
    	validOccAdj = getValidAdjacentLocations(loc);
    	
    	for(int i = 0; i < validOccAdj.size(); i++)
    	{
    		if(get(validOccAdj.get(i)) == null)
    		{
    			validOccAdj.remove(i);
    			i--;
    		}
    	}
    	
    	return validOccAdj;
	}

	//----------------------------------------------------------------------------
	//Postcondition: displays the board and its values onto the screen.
	public void display()
	{
		System.out.println();
		System.out.print(String.format("%4s", " "));
		for (int i = 0; i < board[0].length; i++)
			System.out.print(String.format("%4d", i));

		System.out.println("\n");

		for (int i = 0; i < board[0].length; i++)
		{
			System.out.print(String.format("%4d", i));
			for (int j = 0; j < board.length; j++)
			{
				if (board[i][j] != null)
					System.out.print(String.format("%4s", board[i][j]));
				else
					System.out.print(String.format("%4s", "."));
			}
			System.out.println("\n");
		}

		System.out.println();
	}

	//----------------------------------------------------------------------------
}