import java.util.ArrayList;
public class UpdateBoardTestCases
{
	//Each method depicts different test cases for a 4 x 4 matrix.
	//It is recommended that you create test cases for an 8 x 8 matrix.

	//-----------------------------------------------------------------------------------------
	public static void testCase1(Grid board, String[][] key)
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


		key[1][0] = "W";
		key[1][1] = "W";
		key[1][2] = "W";
		key[1][3] = "W";

	}

	//-----------------------------------------------------------------------------------------
	public static void testCase2(Grid board, String[][] key)
	{
	/*
       			0   1   2   3

   			0   .   .   .   .

   			1   B   W   B   .

  			2   .   .   .   .

   			3   .   .   .   .
		*/

		System.out.println("-----------------------------------------------");
		System.out.println("Test Case #2");

		board.put(new Location(1, 0), "B");
		board.put(new Location(1, 1), "W");
		board.put(new Location(1, 2), "B");


		key[1][0] = "B";
		key[1][1] = "W";
		key[1][2] = "W";
		key[1][3] = "W";

	}


	//-----------------------------------------------------------------------------------------
	public static void testCase3(Grid board, String[][] key)
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


		key[0][0] = "W";
		key[1][1] = "W";
		key[2][2] = "W";
		key[3][3] = "W";


	}

	//-----------------------------------------------------------------------------------------
	public static void testCase4(Grid board, String[][] key)
	{

		/*
       			0   1   2   3

   			0   W   B   B   .

   			1   B   B   .   .

  			2   B   .   B   .

   			3   .   .   .   .
		*/

		System.out.println("-----------------------------------------------");
		System.out.println("Test Case #4");

		board.put(new Location(0, 0), "W");
		board.put(new Location(0, 1), "B");
		board.put(new Location(0, 2), "B");

		board.put(new Location(1, 0), "B");
		board.put(new Location(1, 1), "B");

		board.put(new Location(2, 0), "B");
		board.put(new Location(2, 2), "B");

		key[0][0] = "W";
		key[0][1] = "B";
		key[0][2] = "B";

		key[1][0] = "B";
		key[1][1] = "W";

		key[2][0] = "B";
		key[2][2] = "W";

		key[3][3] = "W";

	}

	//-----------------------------------------------------------------------------------------
	public static void testCase5(Grid board, String[][] key)
	{

		/*
       			0   1   2   3

   			0   .   B   B   W

   			1   B   B   .   .

  			2   B   .   B   .

   			3   W   .   .   W
		*/

		System.out.println("-----------------------------------------------");
		System.out.println("Test Case #5");

		board.put(new Location(0, 1), "B");
		board.put(new Location(0, 2), "B");
		board.put(new Location(0, 3), "W");

		board.put(new Location(1, 0), "B");
		board.put(new Location(1, 1), "B");

		board.put(new Location(2, 0), "B");
		board.put(new Location(2, 2), "B");

		board.put(new Location(3, 0), "W");
		board.put(new Location(3, 3), "W");


		key[0][0] = "W";
		key[0][1] = "W";
		key[0][2] = "W";
		key[0][3] = "W";

		key[1][0] = "W";
		key[1][1] = "W";

		key[2][0] = "W";
		key[2][2] = "W";

		key[3][0] = "W";
		key[3][3] = "W";
	}
	
	//-----------------------------------------------------------------------------------------
	public static void testCase6(Grid board, String[][] key)
	{

		/*
       			0   1   2   3

   			0   .   B   B   .

   			1   B   B   .   .

  			2   .   .   B   .

   			3   .   .   .   W
		*/

		System.out.println("-----------------------------------------------");
		System.out.println("Test Case #6");

		board.put(new Location(0, 1), "B");
		board.put(new Location(0, 2), "B");
		board.put(new Location(1, 0), "B");
		board.put(new Location(1, 1), "B");
		board.put(new Location(2, 2), "B");
		board.put(new Location(3, 3), "W");
		
		key[0][0] = "W";
		key[1][1] = "W";
		key[2][2] = "W";
		key[3][3] = "W";
		
		key[0][1] = "B";
		key[0][2] = "B";
		key[1][0] = "B";

	}
	
	//-----------------------------------------------------------------------------------------
	public static void testCase7(Grid board, String[][] key)
	{
		
		/*
	       		0   1   2   3

	   		0   B   .   .   .

	   		1   .   .   B   B

	  		2   .   W   B   .

	   		3   .   B   .   W
		*/

		System.out.println("-----------------------------------------------");
		System.out.println("Test Case #7");

		board.put(new Location(0, 0), "B");
		board.put(new Location(1, 2), "B");
		board.put(new Location(1, 3), "B");
		board.put(new Location(2, 2), "B");
		board.put(new Location(3, 1), "B");
			
		board.put(new Location(2, 1), "W");
		board.put(new Location(3, 3), "W");

		key[1][1] = "W";
			
		key[0][0] = "B";
		key[1][2] = "B";
		key[1][3] = "B";
		key[3][1] = "B";
			
		key[2][2] = "W";
		key[2][1] = "W";
		key[3][3] = "W";
	}
	
	//-----------------------------------------------------------------------------------------
	public static void testCase8(Grid board, String[][] key)
	{
		
		/*
	       		0   1   2   3	4	5	6	7

	   		0   W   .   .   W	.	.	B	.	

	   		1   .   B	.   B	.	W	B	.	

	  		2   B   .   B   W	W	.	.	.	

	   		3   B   B   W   o	B	B	W	B
	   		
	   		4	B	.	B	B	W	.	.	.
	   		
	   		5	.	W	.	B	.	W	.	.
	   		
	   		6	B	B	.	B	.	.	W	.	
	   		
	   		7	.	.	.	W	.	.	.	W
		*/

		System.out.println("-----------------------------------------------");
		System.out.println("Test Case #8");
		
		//Bs
		board.put(new Location(0, 6), "B");
		board.put(new Location(1, 1), "B");
		board.put(new Location(1, 3), "B");
		board.put(new Location(1, 6), "B");
		board.put(new Location(2, 0), "B");
		board.put(new Location(2, 2), "B");
		board.put(new Location(3, 0), "B");
		board.put(new Location(3, 1), "B");
		board.put(new Location(3, 4), "B");
		board.put(new Location(3, 5), "B");
		board.put(new Location(3, 7), "B");
		board.put(new Location(4, 0), "B");
		board.put(new Location(4, 2), "B");
		board.put(new Location(4, 3), "B");
		board.put(new Location(5, 3), "B");
		board.put(new Location(6, 0), "B");
		board.put(new Location(6, 1), "B");
		board.put(new Location(6, 3), "B");
		//Ws
		board.put(new Location(0, 0), "W");
		board.put(new Location(0, 3), "W");
		board.put(new Location(1, 5), "W");
		board.put(new Location(2, 3), "W");
		board.put(new Location(2, 4), "W");
		board.put(new Location(3, 2), "W");
		board.put(new Location(3, 6), "W");
		board.put(new Location(4, 4), "W");
		board.put(new Location(5, 1), "W");
		board.put(new Location(5, 5), "W");
		board.put(new Location(6, 6), "W");
		board.put(new Location(7, 3), "W");
		board.put(new Location(7, 7), "W");
		
		//theTarget
		key[3][3] = "W";
		
		//set Ws
		key[0][0] = "W";
		key[0][3] = "W";
		key[1][5] = "W";
		key[2][3] = "W";
		key[2][4] = "W";
		key[3][2] = "W";
		key[3][6] = "W";
		key[4][4] = "W";
		key[5][1] = "W";
		key[5][5] = "W";
		key[6][6] = "W";
		key[7][3] = "W";
		key[7][7] = "W";
		
		//flipped Ws
		key[1][1] = "W";
		key[2][2] = "W";
		key[3][4] = "W";
		key[3][5] = "W";
		key[4][3] = "W";
		key[5][3] = "W";
		key[6][3] = "W";
		key[4][2] = "W";
		
		//final Bs
		key[0][6] = "B";
		key[1][3] = "B";
		key[1][6] = "B";
		key[2][0] = "B";
		key[3][0] = "B";
		key[3][1] = "B";
		key[3][7] = "B";
		key[4][0] = "B";
		key[6][0] = "B";
		key[6][1] = "B";
		
	}
}