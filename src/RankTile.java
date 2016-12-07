
abstract public class RankTile extends Tile
{
	protected int rank;
	
	public RankTile(int rank)
	{
		this.rank = rank;
	}

	@Override public boolean matches(Tile other)
	{
		if(!super.matches(other))	//if not same class
			return false;
		
		RankTile o = (RankTile) other;
		if(rank != o.rank)
			return false;
		
		return true;
	}
}
