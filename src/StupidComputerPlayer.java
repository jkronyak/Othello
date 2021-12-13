import java.util.List;
import java.util.List;
//Jared Kronyak Period 8
public class StupidComputerPlayer extends OthelloPlayer
{
	public StupidComputerPlayer(String inName, String inColor)
	{
		super(inName, inColor);
	}
	
	public Location getMove(List <Location> moveList)
	{
		return moveList.get( (int) (Math.random() * (moveList.size())) );
	}
}
