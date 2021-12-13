import java.util.List;
import java.util.Scanner;
//Jared Kronyak
public class HumanOthelloPlayer extends OthelloPlayer
{
	public HumanOthelloPlayer(String inName, String inColor)
	{
		super(inName, inColor);
	}
	
	public Location getMove(List <Location> moveList)
	{
		Location userChoice = null;
		if(!(moveList.size() == 0))
		{
			Scanner inputReader = new Scanner(System.in);
			int userRow = 0;
			int userCol = 0;
			boolean isValid = false;
			
			while(isValid == false)
			{
				System.out.println("Enter a row: ");
				userRow = inputReader.nextInt();
				System.out.println("Enter a column: ");
				userCol = inputReader.nextInt();
			
				userChoice = new Location(userRow, userCol);
				//Check if userChoice is valid
				for(int i = 0; i < moveList.size(); i++)
				{
					if(moveList.get(i).equals(userChoice) )
					{
						isValid = true;
					}
				}
				
				if(isValid == false)
				{
					System.out.println("Invalid move. Please re-enter");
				}
			}
		}
		
		return userChoice;
	}
}
