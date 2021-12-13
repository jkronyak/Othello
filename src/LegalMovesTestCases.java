import java.util.ArrayList;
public class LegalMovesTestCases
{

	//Each method depicts different test cases for a 4 x 4 matrix.
	//It is recommended that you create test cases for an 8 x 8 matrix.
	public static void testCase1(Grid board, ArrayList<Location> answers)
	{
		/*
       			0   1   2   3

   			0   .   .   .   .

   			1   W   B   B   .

  			2   .   .   .   .

   			3   .   .   .   .
		*/

		System.out.println("-----------------------------------------------");
		System.out.println("Test Case #1");

		board.put(new Location(1, 0), "W");
		board.put(new Location(1, 1), "B");
		board.put(new Location(1, 2), "B");

		answers.add(new Location(1, 3));
		board.display();

	}
	//--------------------------------------------------------------------------
	public static void testCase2(Grid board, ArrayList<Location> answers)
	{
		/*
       			0   1   2   3

   			0   .   .   .   .

   			1   W   B   W   .

  			2   .   .   .   .

   			3   .   .   .   .
		*/

		System.out.println("-----------------------------------------------");
		System.out.println("Test Case #2");

		board.put(new Location(1, 0), "W");
		board.put(new Location(1, 1), "B");
		board.put(new Location(1, 2), "W");

		board.display();
	}

	//--------------------------------------------------------------------------
	public static void testCase3(Grid board, ArrayList<Location> answers)
	{
		/*
       			0   1   2   3

   			0   W   .   .   .

   			1   .   B   .   .

  			2   .   .   B   .

   			3   .   .   .   .
		*/

		System.out.println("-----------------------------------------------");
		System.out.println("Test Case #3");

		board.put(new Location(0, 0), "W");
		board.put(new Location(1, 1), "B");
		board.put(new Location(2, 2), "B");

		answers.add(new Location(3, 3));
		board.display();
	}






	//--------------------------------------------------------------------------
	public static void testCase4(Grid board, ArrayList<Location> answers)
	{
		/*
       			0   1   2   3

   			0   .   .   B   W

   			1   W   B   B   B

  			2   W   W   B   .

   			3   W   W   W   .
		*/

		System.out.println("-----------------------------------------------");
		System.out.println("Test Case #4");

		board.put(new Location(0, 2), "B");
		board.put(new Location(0, 3), "W");

		board.put(new Location(1, 0), "W");
		board.put(new Location(1, 1), "B");
		board.put(new Location(1, 2), "B");
		board.put(new Location(1, 3), "B");

		board.put(new Location(2, 0), "W");
		board.put(new Location(2, 1), "W");
		board.put(new Location(2, 2), "B");

		board.put(new Location(3, 0), "W");
		board.put(new Location(3, 1), "W");
		board.put(new Location(3, 2), "W");

		answers.add(new Location(0, 1));
		answers.add(new Location(2, 3));
		board.display();

	}
	//--------------------------------------------------------------------------
	public static void testCase5(Grid board, ArrayList<Location> answers)
	{
		/*
       			0   1   2   3

   			0   W   B   B   .

   			1   B   B   .   .

  			2   B   .   B   .

   			3   .   .   .   .
		*/

		System.out.println("-----------------------------------------------");
		System.out.println("Test Case #5");

		board.put(new Location(0, 0), "W");
		board.put(new Location(0, 1), "B");
		board.put(new Location(0, 2), "B");

		board.put(new Location(1, 0), "B");
		board.put(new Location(1, 1), "B");

		board.put(new Location(2, 0), "B");
		board.put(new Location(2, 2), "B");

		answers.add(new Location(3, 3));
		answers.add(new Location(3, 0));
		answers.add(new Location(0, 3));
		board.display();

	}
	public static void testCase6(Grid board, ArrayList<Location> answers)
	{
		/*
       			0   1   2   3   4   5   6   7

   			0   W   B   B   B   W   B   B   .

   			1   B   .   .   .   .   .   .   .

  			2   B   .   .   .   .   .   .   .

   			3   B   .   .   .   .   .   .   .
   			
   			4   B   .   .   .   .   .   .   .
   			
   			5   B   .   .   .   .   .   .   .
   			
   			6   B   .   .   .   .   .   .   .
   			
   			7   .   .   .   .   .   .   .   .
   			
		*/

		System.out.println("-----------------------------------------------");
		System.out.println("Test Case #6");

		board.put(new Location(0, 0), "W");
		for (int col = 1; col < board.getNumCols() - 1; col++)
			board.put(new Location(0, col), "B");
		for (int row = 1; row < board.getNumRows() - 1; row++)
			board.put(new Location(row, 0), "B");
		
		
		answers.add(new Location(0,7));
		answers.add(new Location(7,0));
		board.display();
			

	}
	
	public static void testCase7(Grid board, ArrayList<Location> answers)
	{
		/*
       			0   1   2   3   4   5   6   7

   			0   W   .   .   .   .   .   .   .

   			1   .   B   .   .   .   .   .   .

  			2   .   .   B   .   .   .   .   .

   			3   .   .   .   B   .   .   .   .
   			
   			4   .   .   .   .   W   .   .   .
   			
   			5   .   .   .   .   .   B   .   .
   			
   			6   .   .   .   .   .   .   B   .
   			
   			7   .   .   .   .   .   .   .   .
   			
		*/
		
		System.out.println("-----------------------------------------------");
		System.out.println("Test Case #7");

		board.put(new Location(0, 0), "W");
		int row = 1;
		for (int col = 1; col < board.getNumCols() - 1; col++)
		{
			board.put(new Location(row, col), "B");
			row++;
		}
		board.put(new Location(4, 4), "W");
		
		answers.add(new Location(7,7));
		board.display();
	}
	
	public static void testCase8(Grid board, ArrayList<Location> answers)
	{
		/*
       			0   1   2   3   4   5   6   7

   			0   .   .   .   .   B   .   .   .

   			1   .   .   .   W   B   W   .   .

  			2   .   .   .   W   B   .   .   .

   			3   .   .   .   W   B   W   .   .
   			
   			4   .   .   B   W   B   B   .   .
   			
   			5   .   .   .   W   .   .   .   .
   			
   			6   .   .   .   .   .   .   .   .
   			
   			7   .   .   .   .   .   .   .   .
   			
		*/
		System.out.println("-----------------------------------------------");
		System.out.println("Test Case #8");

		
		board.put(new Location(0, 4), "B");
		
		board.put(new Location(1, 3), "W");
		board.put(new Location(1, 4), "B");
		board.put(new Location(1, 5), "W");
		
		board.put(new Location(2, 3), "W");
		board.put(new Location(2, 4), "B");
		
		board.put(new Location(3, 3), "W");
		board.put(new Location(3, 4), "B");
		board.put(new Location(3, 5), "W");
		
		board.put(new Location(4, 2), "B");
		board.put(new Location(4, 3), "W");
		board.put(new Location(4, 4), "B");
		board.put(new Location(4, 5), "B");
		
		board.put(new Location(5, 3), "W");
				
		answers.add(new Location(0, 6));
		answers.add(new Location(0, 2));
		answers.add(new Location(6, 4));
		answers.add(new Location(6, 2));
		answers.add(new Location(2, 5));
		answers.add(new Location(1, 2));
		answers.add(new Location(1, 6));
		answers.add(new Location(2, 2));
		answers.add(new Location(2, 6));
		answers.add(new Location(3, 2));
		answers.add(new Location(3, 6));  
		answers.add(new Location(4, 6));
		answers.add(new Location(5, 2));
		
	
		board.display();
	}


}