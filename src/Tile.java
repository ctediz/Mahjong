import javax.swing.*;
import java.awt.*;

abstract public class Tile extends JPanel
{
	protected static final Dimension SIZE = new Dimension(60,60);		// surface of tile
	private static Polygon farRight, closeRight, farBottom, closeBottom;
	private static GradientPaint tileGradient, layerGradient;
	{		
		closeRight = new Polygon(new int[]{SIZE.width,SIZE.width,SIZE.width+5,SIZE.width+5}, new int[]{SIZE.height,0,5,SIZE.height+5}, 4);
		closeBottom = new Polygon(new int[]{5,SIZE.width+5,SIZE.width,0}, new int[]{SIZE.height+5,SIZE.height+5,SIZE.height,SIZE.height}, 4);
		farRight = new Polygon(new int[]{SIZE.width+5,SIZE.width+5,SIZE.width+10,SIZE.width+10}, new int[]{SIZE.height+5,5,10,SIZE.height+10}, 4);
		farBottom = new Polygon(new int[]{10,SIZE.width+10,SIZE.width+5,5}, new int[]{SIZE.height+10,SIZE.height+10,SIZE.height+5,SIZE.height+5}, 4);
		
		tileGradient = new GradientPaint(0F,0F, new Color(150,205,205), (float)SIZE.width, (float)SIZE.height, new Color(187,255,255));
		layerGradient = new GradientPaint(0F,0F, new Color(50,205,50), (float)SIZE.width, (float)SIZE.height, new Color(193,255,193));
	}
	
	// Tile positioning
	private int xPos;
	private int yPos;
	private int zPos;
	private int zOrder;
	
	public Tile()
	{
		setOpaque(false);
		setSize(71,71);
		setPreferredSize(SIZE);
	}
	
	public boolean matches(Tile other)
	{
		if((getClass() == other.getClass()))	//Same class
			return true;
		
		return false;
	}
	
	@Override public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		// Fill tile colors
		g2.setPaint(tileGradient);
		g2.fillRect(0,0, SIZE.height, SIZE.width);
		g.fillPolygon(closeRight);
		g.fillPolygon(closeBottom);	
		
		g2.setPaint(layerGradient);
		g.fillPolygon(farRight);
		g.fillPolygon(farBottom);	
		
		// Draw borders
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, SIZE.height, SIZE.width);
		g.drawPolygon(farRight);
		g.drawPolygon(farBottom);
		g.drawPolygon(closeRight);
		g.drawPolygon(closeBottom);		
	}
	
	public void setPos(int x, int y, int z)
	{
		// offset logic done in TileBoard
		xPos = x;
		yPos = y;
		zPos = z;
	}
	
	public void setZOrder() { zOrder = getParent().getComponentZOrder(this); }
	public void resetZOrder() { getParent().setComponentZOrder(this, zOrder); }
	public int getZOrder() { return zOrder; }
	
	public int getXPos(){ return xPos; }	
	public int getYPos(){ return yPos; }	
	public int getZPos(){ return zPos; }
	
}
