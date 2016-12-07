
public class FlowerTile extends PictureTile
{
	public FlowerTile(String name)
	{
		super(name);
		getFile(name);
	}

	private void getFile(String name)
	{
		switch(name)
		{
		case "Chrysanthemum":
			setImage("images/Chrysanthemum.png");
			break;
		case "Plum":
			setImage("images/Plum.png");
			break;
		case "Orchid":
			setImage("images/Orchid.png");
			break;
		case "Bamboo":
			setImage("images/Bamboo.png");
			break;
		default:
			System.err.println("Bad flower: " + name);
			break;
		}
	}
}
