import java.awt.*;

public class WhiteDragonTile extends Tile
{	
	// Drawing borders of white dragon tile
	private static Dimension innerBorder, outerBorder;
	{
		outerBorder = new Dimension((int)(SIZE.width*.75),(int)(SIZE.height*.75));
		innerBorder = new Dimension((int)(SIZE.width*.5),(int)(SIZE.height*.5));
	}
	
	public WhiteDragonTile()
	{
		setToolTipText(toString());
	}
	
	public String toString()
	{
		return "White Dragon";
	}
	
	@Override public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		draw(g);
	}
	
	private void draw(Graphics g)
	{
		// Decorations
		g.setColor(Color.BLUE);
		// Left
		g.fillRect((SIZE.width-outerBorder.width)/2, (SIZE.height-outerBorder.height), (outerBorder.width-innerBorder.width)/2+1, (outerBorder.height-innerBorder.height)+1);
		g.fillRect((SIZE.width-outerBorder.width)/2, (SIZE.height-outerBorder.height/2-1), (outerBorder.width-innerBorder.width)/2+1, (outerBorder.height-innerBorder.height)+1);
		// Right
		g.fillRect((SIZE.width+innerBorder.width)/2, (SIZE.height/2-outerBorder.height/2), (outerBorder.width-innerBorder.width)/2+1, (outerBorder.height-innerBorder.height)+1);
		g.fillRect((SIZE.width+innerBorder.width)/2, (SIZE.height-innerBorder.height), (outerBorder.width-innerBorder.width)/2+1, (outerBorder.height-innerBorder.height)+1);		
		// Top
		g.fillRect((SIZE.width-outerBorder.width), (SIZE.height-outerBorder.height)/2, (outerBorder.width-innerBorder.width)+1, (outerBorder.height-innerBorder.height)/2+1);
		// Bottom
		g.fillRect((SIZE.width-outerBorder.width)*2, (SIZE.height+innerBorder.height)/2, (outerBorder.width-innerBorder.width)+1, (outerBorder.height-innerBorder.height)/2+1);		
		
		// Borders
		g.setColor(Color.BLACK);
		g.drawRect((SIZE.width-innerBorder.width)/2, (SIZE.height-innerBorder.height)/2, innerBorder.width, innerBorder.height);
		g.drawRect((SIZE.width-outerBorder.width)/2, (SIZE.height-outerBorder.height)/2, outerBorder.width, outerBorder.height);
	}
}
