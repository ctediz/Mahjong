
public class SeasonTile extends PictureTile 
{
	public SeasonTile(String name)
	{
		super(name);
		getFile(name);
	}
	
	private void getFile(String name)
	{
		switch(name)
		{
		case "Spring":
			setImage("images/Spring.png");
			break;
		case "Fall":	
			setImage("images/Fall.png");
			break;
		case "Summer":
			setImage("images/Summer.png");
			break;
		case "Winter":
			setImage("images/Winter.png");
			break;
		default:
			System.err.println("Bad season: " + name);
			break;			
		}
	}
}
