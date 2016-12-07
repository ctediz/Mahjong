import java.awt.*;

//Vertical offset of (English) symbols is hard coded

abstract public class CharacterTile extends Tile
{
	// Hard coded vertical offset
	private static final int ENGLISH_HEIGHT_OFFSET = 15;
	
	protected char symbol;
		
	public CharacterTile(char symbol)
	{
		this.symbol = symbol;
		setToolTipText(toString());
	}
	
	@Override public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		FontMetrics fm = g.getFontMetrics();
		int englishWidth = fm.stringWidth(Character.toString(symbol));
		int offset = (int)(englishWidth*1.5);

		// Draw English char
		g.setColor(Color.RED);
		g.drawString(Character.toString(symbol), (int) (SIZE.width-offset), ENGLISH_HEIGHT_OFFSET);	
	}
	
	@Override public boolean matches(Tile other)
	{
		if(!super.matches(other))	//if not same class
			return false;
		
		CharacterTile o = (CharacterTile) other;		
		if(symbol != o.symbol)
			return false;
		
		return true;
	}
	
	public String toString()
	{
		switch (symbol)
		{
		case 'N':
		case 'n':
			return "North Wind";
		case 'E':
		case 'e':
			return "East Wind";
		case 'W':
		case 'w':
			return "West Wind";
		case 'S':
		case 's':
			return "South Wind";
		case 'C':
		case 'c':
			return "Red Dragon";
		case 'F':
		case 'f':
			return "Green Dragon";
		default:	// number characters
			return "Character " + symbol;
		}
	}	
}
