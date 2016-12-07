package tiles;
import java.awt.*;

public class Pancake extends CircleTile 
{
	private final static int WIDTH = (int)(SIZE.height*.75);
	public Pancake(int rank)
	{
		super(rank);
	}
	
	@Override public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		draw(g);
	}
	
	private void draw(Graphics g)
	{
		g.setColor(Color.GREEN);
		g.fillOval(SIZE.width/2-WIDTH/2, SIZE.height/2-WIDTH/2, 
				WIDTH, WIDTH);
		g.setColor(Color.BLACK);
		g.drawOval(SIZE.width/2-WIDTH/2, SIZE.height/2-WIDTH/2, 
				WIDTH, WIDTH);
		
		g.setColor(Color.RED);
		g.drawOval(SIZE.width/2-(int)(WIDTH*.5)/2, SIZE.height/2-(int)(WIDTH*.5)/2, 
				(int)(WIDTH*.5), (int)(WIDTH*.5));
		g.fillOval(SIZE.width/2-(int)(WIDTH*.25)/2, SIZE.height/2-(int)(WIDTH*.25)/2, 
				(int)(WIDTH*.25), (int)(WIDTH*.25));
		
		g.setColor(Color.CYAN);
		g.fillOval(SIZE.width/2-(int)(WIDTH*.2)/2, SIZE.height/2-(int)(WIDTH*.2)/2, 
				(int)(WIDTH*.2), (int)(WIDTH*.2));		
	}
}
