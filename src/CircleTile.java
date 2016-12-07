import java.awt.*;

public class CircleTile extends RankTile 
{
	private static final int CIRCLE_RADIUS = (int)(SIZE.height/6)/2;
	
	public CircleTile(int rank)
	{
		super(rank);
		setToolTipText(toString());
	}
	
	public String toString()
	{
		return "Circle " + rank;
	}
	
	@Override public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		draw(g);
	}
	
	private void draw(Graphics g)
	{		
		switch(rank)
		{
		case 1:
			// Should never be called
			// Instead create Pancake class
			break;
		case 2:
			g.setColor(Color.GREEN);
			g.fillOval(SIZE.width/2-CIRCLE_RADIUS, SIZE.height/3-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			g.setColor(Color.RED);
			g.fillOval(SIZE.width/2-CIRCLE_RADIUS, SIZE.height/3*2-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			
			g.setColor(Color.WHITE);
			for(int i = 1; i < 3; i++)
			{
				g.drawOval(SIZE.width/2, SIZE.height/3*i-CIRCLE_RADIUS,
						0, CIRCLE_RADIUS*2);
				g.drawOval(SIZE.width/2-CIRCLE_RADIUS, SIZE.height/3*i,
						CIRCLE_RADIUS*2, 0);
			}			
			break;
		case 3:
			g.setColor(Color.BLUE);
			g.fillOval(SIZE.width/4-CIRCLE_RADIUS, SIZE.height/4-CIRCLE_RADIUS,
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			g.setColor(Color.RED);
			g.fillOval(SIZE.width/4*2-CIRCLE_RADIUS, SIZE.height/4*2-CIRCLE_RADIUS,
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			g.setColor(Color.GREEN);
			g.fillOval(SIZE.width/4*3-CIRCLE_RADIUS, SIZE.height/4*3-CIRCLE_RADIUS,
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			
			g.setColor(Color.WHITE);
			for(int i = 1; i < 4; i++)
			{
				g.drawOval(SIZE.width/4*i, SIZE.height/4*i-CIRCLE_RADIUS,
						0, CIRCLE_RADIUS*2);
				g.drawOval(SIZE.width/4*i-CIRCLE_RADIUS, SIZE.height/4*i,
						CIRCLE_RADIUS*2, 0);
			}	
			break;
		case 5:
			g.setColor(Color.RED);
			g.fillOval(SIZE.width/4*2-CIRCLE_RADIUS, SIZE.height/4*2-CIRCLE_RADIUS,
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			
			g.setColor(Color.WHITE);
			g.drawOval(SIZE.width/4*2-CIRCLE_RADIUS, SIZE.height/4*2, 
					CIRCLE_RADIUS*2, 0);			
			g.drawOval(SIZE.width/4*2, SIZE.height/4*2-CIRCLE_RADIUS, 
					0, CIRCLE_RADIUS*2);		// Fall through to 4
		case 4:
			g.setColor(Color.BLUE);
			g.fillOval(SIZE.width/4-CIRCLE_RADIUS, SIZE.height/4-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);		
			g.fillOval(SIZE.width/4*3-CIRCLE_RADIUS, SIZE.height/4*3-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			
			g.setColor(Color.GREEN);
			g.fillOval(SIZE.width/4*3-CIRCLE_RADIUS, SIZE.height/4-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);	
			g.fillOval(SIZE.width/4-CIRCLE_RADIUS, SIZE.height/4*3-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			
			g.setColor(Color.WHITE);
			for(int i = 1; i < 4; i+=2)
				for(int j = 1; j < 4; j+=2)
				{
					g.drawOval(SIZE.width/4*i, SIZE.height/4*j-CIRCLE_RADIUS, 
							0, CIRCLE_RADIUS*2);
					g.drawOval(SIZE.width/4*i-CIRCLE_RADIUS, SIZE.height/4*j, 
							CIRCLE_RADIUS*2, 0);
				}			
			break;
		case 6:
			g.setColor(Color.GREEN);
			g.fillOval(SIZE.width/3-CIRCLE_RADIUS, SIZE.height/4-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			g.fillOval(SIZE.width/3*2-CIRCLE_RADIUS, SIZE.height/4-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			
			g.setColor(Color.RED);
			g.fillOval(SIZE.width/3-CIRCLE_RADIUS, SIZE.height/4*2-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			g.fillOval(SIZE.width/3*2-CIRCLE_RADIUS, SIZE.height/4*2-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			g.fillOval(SIZE.width/3-CIRCLE_RADIUS, SIZE.height/4*3-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			g.fillOval(SIZE.width/3*2-CIRCLE_RADIUS, SIZE.height/4*3-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			
			g.setColor(Color.WHITE);
			g.drawOval(SIZE.width/3, SIZE.height/4-CIRCLE_RADIUS, 
					0, CIRCLE_RADIUS*2);
			g.drawOval(SIZE.width/3*2, SIZE.height/4-CIRCLE_RADIUS, 
					0, CIRCLE_RADIUS*2);
			g.drawOval(SIZE.width/3, SIZE.height/4*2-CIRCLE_RADIUS, 
					0, CIRCLE_RADIUS*2);
			g.drawOval(SIZE.width/3*2, SIZE.height/4*2-CIRCLE_RADIUS, 
					0, CIRCLE_RADIUS*2);
			g.drawOval(SIZE.width/3, SIZE.height/4*3-CIRCLE_RADIUS, 
					0, CIRCLE_RADIUS*2);
			g.drawOval(SIZE.width/3*2, SIZE.height/4*3-CIRCLE_RADIUS, 
					0, CIRCLE_RADIUS*2);
			
			g.setColor(Color.WHITE);
			for(int i = 1; i < 3; i++)
				for(int j = 1; j < 4; j++)
				{
					g.drawOval(SIZE.width/3*i, SIZE.height/4*j-CIRCLE_RADIUS, 
							0, CIRCLE_RADIUS*2);
					g.drawOval(SIZE.width/3*i-CIRCLE_RADIUS, SIZE.height/4*j, 
							CIRCLE_RADIUS*2, 0);
				}
			break;
		case 7:
			g.setColor(Color.GREEN);
			g.fillOval(SIZE.width/4-CIRCLE_RADIUS, SIZE.height/7-CIRCLE_RADIUS,
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			g.fillOval(SIZE.width/4*2-CIRCLE_RADIUS, SIZE.height/7*2-CIRCLE_RADIUS,
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			g.fillOval(SIZE.width/4*3-CIRCLE_RADIUS, SIZE.height/7*3-CIRCLE_RADIUS,
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);			

			g.setColor(Color.RED);
			g.fillOval(SIZE.width/3-CIRCLE_RADIUS, SIZE.height/7*4-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			g.fillOval(SIZE.width/3*2-CIRCLE_RADIUS, SIZE.height/7*4-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			g.fillOval(SIZE.width/3-CIRCLE_RADIUS, SIZE.height/7*6-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			g.fillOval(SIZE.width/3*2-CIRCLE_RADIUS, SIZE.height/7*6-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			
			g.setColor(Color.WHITE);
			for(int i = 1; i < 4; i++)
			{
				g.drawOval(SIZE.width/4*i, SIZE.height/7*i-CIRCLE_RADIUS,
						0, CIRCLE_RADIUS*2);
				g.drawOval(SIZE.width/4*i-CIRCLE_RADIUS, SIZE.height/7*i,
						CIRCLE_RADIUS*2, 0);
			}
			
			for(int i = 1; i < 3; i++)
				for(int j = 4; j < 7; j++)
				{
					if((j%2)== 0)
					{
						g.drawOval(SIZE.width/3*i, SIZE.height/7*j-CIRCLE_RADIUS,
							0, CIRCLE_RADIUS*2);
						g.drawOval(SIZE.width/3*i-CIRCLE_RADIUS, SIZE.height/7*j, 
							CIRCLE_RADIUS*2, 0);
					}
				}
			break;
		case 8:
			g.setColor(Color.BLUE);
			g.fillOval(SIZE.width/3-CIRCLE_RADIUS, SIZE.height/5-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			g.fillOval(SIZE.width/3*2-CIRCLE_RADIUS, SIZE.height/5-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			g.fillOval(SIZE.width/3-CIRCLE_RADIUS, SIZE.height/5*2-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			g.fillOval(SIZE.width/3*2-CIRCLE_RADIUS, SIZE.height/5*2-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);			
			g.fillOval(SIZE.width/3-CIRCLE_RADIUS, SIZE.height/5*3-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			g.fillOval(SIZE.width/3*2-CIRCLE_RADIUS, SIZE.height/5*3-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			g.fillOval(SIZE.width/3-CIRCLE_RADIUS, SIZE.height/5*4-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			g.fillOval(SIZE.width/3*2-CIRCLE_RADIUS, SIZE.height/5*4-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			
			g.setColor(Color.WHITE);
			for(int i = 1; i < 3; i++)
				for(int j = 1; j < 5; j++)
				{
					g.drawOval(SIZE.width/3*i, SIZE.height/5*j-CIRCLE_RADIUS, 
							0, CIRCLE_RADIUS*2);
					g.drawOval(SIZE.width/3*i-CIRCLE_RADIUS, SIZE.height/5*j, 
							CIRCLE_RADIUS*2, 0);
				}			
			break;
		case 9:
			g.setColor(Color.GREEN);
			g.fillOval(SIZE.width/4-CIRCLE_RADIUS, SIZE.height/4-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			g.fillOval(SIZE.width/4*2-CIRCLE_RADIUS, SIZE.height/4-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			g.fillOval(SIZE.width/4*3-CIRCLE_RADIUS, SIZE.height/4-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
						
			g.setColor(Color.RED);
			g.fillOval(SIZE.width/4-CIRCLE_RADIUS, SIZE.height/4*2-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			g.fillOval(SIZE.width/4*2-CIRCLE_RADIUS, SIZE.height/4*2-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			g.fillOval(SIZE.width/4*3-CIRCLE_RADIUS, SIZE.height/4*2-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			
			g.setColor(Color.BLUE);
			g.fillOval(SIZE.width/4-CIRCLE_RADIUS, SIZE.height/4*3-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			g.fillOval(SIZE.width/4*2-CIRCLE_RADIUS, SIZE.height/4*3-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			g.fillOval(SIZE.width/4*3-CIRCLE_RADIUS, SIZE.height/4*3-CIRCLE_RADIUS, 
					CIRCLE_RADIUS*2, CIRCLE_RADIUS*2);
			
			g.setColor(Color.WHITE);
			for(int i = 1; i < 4; i++)
				for(int j = 1; j < 4; j++)
				{
					g.drawOval(SIZE.width/4*i, SIZE.height/4*j-CIRCLE_RADIUS, 
							0, CIRCLE_RADIUS*2);
					g.drawOval(SIZE.width/4*i-CIRCLE_RADIUS, SIZE.height/4*j, 
							CIRCLE_RADIUS*2, 0);
				}
			break;
		default:
			System.err.println("Bad Rank value: " + rank);
			break;
		}
	}
}
