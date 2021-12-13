//Jared Kronyak Period 8
import java.util.List;
public abstract class OthelloPlayer
{
	private String name;
	private String color;
	
	public OthelloPlayer(String inName, String inColor)
	{
		name = inName;
		color = inColor;
	}
	
	public abstract Location getMove(List <Location> moveList);

	public String getName()
	{
		return name;
	}
	
	public String getColor()
	{
		return color;
	}
	
}
