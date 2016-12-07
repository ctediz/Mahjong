import java.awt.*;

public class BambooTile extends RankTile 
{
	// For drawing bamboos
	private static final int BAMBOO_WIDTH = (int)(SIZE.width*.25/3);
	private static final int BAMBOO_HEIGHT = (int)(SIZE.height*.75/3);
	private static final int DECORATION_HEIGHT = (int)(BAMBOO_HEIGHT*.75);
	private static final int DECORATION_WIDTH = 1;//DECORATION_HEIGHT/4;
	
	public BambooTile(int rank)
	{
		super(rank);
		setToolTipText(toString());
	}
	
	public String toString()
	{
		return "Bamboo " + rank;
	}
	
	@Override public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		// draw bamboos!
		draw(g);
	}
	
	private void draw(Graphics g)
	{
		switch(rank)
		{
		case 1:
			// Create Bamboo1Tile instead
			break;
		case 2:
			// Top
			g.setColor(Color.BLUE);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*2, 
				(SIZE.height-BAMBOO_HEIGHT)/4, BAMBOO_WIDTH, BAMBOO_HEIGHT);
			// Bottom	
			g.setColor(Color.GREEN);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*2, 
				(SIZE.height-BAMBOO_HEIGHT)/4*3, BAMBOO_WIDTH, BAMBOO_HEIGHT);		
			
			
			// Decoration
			g.setColor(Color.WHITE);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*2 + DECORATION_WIDTH, (SIZE.height-BAMBOO_HEIGHT)/4 + DECORATION_HEIGHT/4, 
					DECORATION_WIDTH, DECORATION_HEIGHT);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*2 + DECORATION_WIDTH, (SIZE.height-BAMBOO_HEIGHT)/4*3 + DECORATION_HEIGHT/4, 
					DECORATION_WIDTH, DECORATION_HEIGHT);
			
			break;
		case 3:
			// Top
			g.setColor(Color.BLUE);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*2, 
				(SIZE.height-BAMBOO_HEIGHT)/4, BAMBOO_WIDTH, BAMBOO_HEIGHT);
			// Bottom
			g.setColor(Color.GREEN);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/3, 
				(SIZE.height-BAMBOO_HEIGHT)/4*3, BAMBOO_WIDTH, BAMBOO_HEIGHT);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/3*2, 
					(SIZE.height-BAMBOO_HEIGHT)/4*3, BAMBOO_WIDTH, BAMBOO_HEIGHT);
			
			// Decoration
			g.setColor(Color.WHITE);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*2 + DECORATION_WIDTH, (SIZE.height-BAMBOO_HEIGHT)/4 + DECORATION_HEIGHT/4, 
					DECORATION_WIDTH, DECORATION_HEIGHT);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/3*1 + DECORATION_WIDTH, (SIZE.height-BAMBOO_HEIGHT)/4*3 + DECORATION_HEIGHT/4, 
					DECORATION_WIDTH, DECORATION_HEIGHT);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/3*2 + DECORATION_WIDTH, (SIZE.height-BAMBOO_HEIGHT)/4*3 + DECORATION_HEIGHT/4, 
					DECORATION_WIDTH, DECORATION_HEIGHT);
			
			break;
		case 4:
			// Blue
			g.setColor(Color.BLUE);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/3, 
				(SIZE.height-BAMBOO_HEIGHT)/4, BAMBOO_WIDTH, BAMBOO_HEIGHT);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/3*2, 
					(SIZE.height-BAMBOO_HEIGHT)/4*3, BAMBOO_WIDTH, BAMBOO_HEIGHT);
			// Green	
			g.setColor(Color.GREEN);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/3, 
				(SIZE.height-BAMBOO_HEIGHT)/4*3, BAMBOO_WIDTH, BAMBOO_HEIGHT);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/3*2, 
					(SIZE.height-BAMBOO_HEIGHT)/4, BAMBOO_WIDTH, BAMBOO_HEIGHT);
			
			// Decoration
			g.setColor(Color.WHITE);
			for(int i = 1; i < 3; i++)
			{
				g.fillRect((SIZE.width-BAMBOO_WIDTH)/3*i + DECORATION_WIDTH, (SIZE.height-BAMBOO_HEIGHT)/4 + DECORATION_HEIGHT/4, 
						DECORATION_WIDTH, DECORATION_HEIGHT);
				g.fillRect((SIZE.width-BAMBOO_WIDTH)/3*i + DECORATION_WIDTH, (SIZE.height-BAMBOO_HEIGHT)/4*3 + DECORATION_HEIGHT/4, 
						DECORATION_WIDTH, DECORATION_HEIGHT);
			}
			break;
		case 5:
			// Green
			g.setColor(Color.GREEN);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4, 
				(SIZE.height-BAMBOO_HEIGHT)/4, BAMBOO_WIDTH, BAMBOO_HEIGHT);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*3, 
					(SIZE.height-BAMBOO_HEIGHT)/4*3, BAMBOO_WIDTH, BAMBOO_HEIGHT);
			// Blue	
			g.setColor(Color.BLUE);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4, 
				(SIZE.height-BAMBOO_HEIGHT)/4*3, BAMBOO_WIDTH, BAMBOO_HEIGHT);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*3, 
					(SIZE.height-BAMBOO_HEIGHT)/4, BAMBOO_WIDTH, BAMBOO_HEIGHT);
			
			// Red Center	
			g.setColor(Color.RED);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*2, 
					(SIZE.height-BAMBOO_HEIGHT)/4*2, BAMBOO_WIDTH, BAMBOO_HEIGHT);
			
			// Decoration
			g.setColor(Color.WHITE);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*2 + DECORATION_WIDTH, (SIZE.height-BAMBOO_HEIGHT)/4*2 + DECORATION_HEIGHT/4, 
					DECORATION_WIDTH, DECORATION_HEIGHT);
			for(int i = 1; i < 4; i+=2)
			{
				g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*i + DECORATION_WIDTH, (SIZE.height-BAMBOO_HEIGHT)/4 + DECORATION_HEIGHT/4, 
						DECORATION_WIDTH, DECORATION_HEIGHT);
				g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*i + DECORATION_WIDTH, (SIZE.height-BAMBOO_HEIGHT)/4*3 + DECORATION_HEIGHT/4, 
						DECORATION_WIDTH, DECORATION_HEIGHT);
			}		
			break;
		case 6:
			// Top
			g.setColor(Color.GREEN);
			for(int i = 1; i < 4; i++)
				g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*i, 
					(SIZE.height-BAMBOO_HEIGHT)/4, BAMBOO_WIDTH, BAMBOO_HEIGHT);
			// Bottom
			g.setColor(Color.BLUE);
			for(int i = 1; i < 4; i++)
				g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*i, 
					(SIZE.height-BAMBOO_HEIGHT)/4*3, BAMBOO_WIDTH, BAMBOO_HEIGHT);	
			
			g.setColor(Color.WHITE);
			for(int i = 1; i < 4; i++)
				for(int j = 1; j < 4; j+=2)
					g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*i + DECORATION_WIDTH, (SIZE.width-BAMBOO_HEIGHT)/4*j + DECORATION_HEIGHT/4, 
							DECORATION_WIDTH, DECORATION_HEIGHT);
			break;
		case 7:
			// Top
			g.setColor(Color.RED);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*2, 
					(SIZE.height-BAMBOO_HEIGHT)/4*2 - (int)(1.2*BAMBOO_HEIGHT), BAMBOO_WIDTH, BAMBOO_HEIGHT);

			// Blue Mid
			g.setColor(Color.BLUE);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*2, 
					(SIZE.height-BAMBOO_HEIGHT)/4*2 + (int)(1.2*BAMBOO_HEIGHT), BAMBOO_WIDTH, BAMBOO_HEIGHT);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*2, 
					(SIZE.height-BAMBOO_HEIGHT)/4*2, BAMBOO_WIDTH, BAMBOO_HEIGHT);		
			
			// Green Outside
			g.setColor(Color.GREEN);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4, 
					(SIZE.height-BAMBOO_HEIGHT)/4*2, BAMBOO_WIDTH, BAMBOO_HEIGHT);				
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*3, 
					(SIZE.height-BAMBOO_HEIGHT)/4*2, BAMBOO_WIDTH, BAMBOO_HEIGHT);		
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4, 
					(SIZE.height-BAMBOO_HEIGHT)/4*2 + (int)(1.2*BAMBOO_HEIGHT), BAMBOO_WIDTH, BAMBOO_HEIGHT);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*3, 
					(SIZE.height-BAMBOO_HEIGHT)/4*2 + (int)(1.2*BAMBOO_HEIGHT), BAMBOO_WIDTH, BAMBOO_HEIGHT);
			
			// Decoration
			g.setColor(Color.WHITE);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*2 + DECORATION_WIDTH, (SIZE.height-BAMBOO_HEIGHT)/4*2 - (int)(1.2*BAMBOO_HEIGHT) + DECORATION_HEIGHT/4, 
					DECORATION_WIDTH, DECORATION_HEIGHT);
			for(int i = 1; i < 4; i++)
			{
				g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*i + DECORATION_WIDTH, (SIZE.height-BAMBOO_HEIGHT)/4*2 + DECORATION_HEIGHT/4, 
						DECORATION_WIDTH, DECORATION_HEIGHT);
				g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*i + DECORATION_WIDTH, (SIZE.height-BAMBOO_HEIGHT)/4*2 + (int)(1.2*BAMBOO_HEIGHT) + DECORATION_HEIGHT/4, 
						DECORATION_WIDTH, DECORATION_HEIGHT);
			}
			break;
		case 8:
			// Top 
			g.setColor(Color.GREEN);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4, 
					(SIZE.height-BAMBOO_HEIGHT)/4*2 - (int)(1.2*BAMBOO_HEIGHT), BAMBOO_WIDTH, BAMBOO_HEIGHT);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*2, 
					(SIZE.height-BAMBOO_HEIGHT)/4*2 - (int)(1.2*BAMBOO_HEIGHT), BAMBOO_WIDTH, BAMBOO_HEIGHT);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*3, 
					(SIZE.height-BAMBOO_HEIGHT)/4*2 - (int)(1.2*BAMBOO_HEIGHT), BAMBOO_WIDTH, BAMBOO_HEIGHT);
			
			// Mid
			g.setColor(Color.RED);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/3, 
					(SIZE.height-BAMBOO_HEIGHT)/4*2, BAMBOO_WIDTH, BAMBOO_HEIGHT);			
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/3*2, 
					(SIZE.height-BAMBOO_HEIGHT)/4*2, BAMBOO_WIDTH, BAMBOO_HEIGHT);
			
			// Bottom
			g.setColor(Color.BLUE);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4, 
					(SIZE.height-BAMBOO_HEIGHT)/4*2 + (int)(1.2*BAMBOO_HEIGHT), BAMBOO_WIDTH, BAMBOO_HEIGHT);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*2, 
					(SIZE.height-BAMBOO_HEIGHT)/4*2 + (int)(1.2*BAMBOO_HEIGHT), BAMBOO_WIDTH, BAMBOO_HEIGHT);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*3, 
					(SIZE.height-BAMBOO_HEIGHT)/4*2 + (int)(1.2*BAMBOO_HEIGHT), BAMBOO_WIDTH, BAMBOO_HEIGHT);
			
			// Decoration
			g.setColor(Color.WHITE);
			for(int i = 1; i < 4; i++)
			{
				g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*i + DECORATION_WIDTH, (SIZE.height-BAMBOO_HEIGHT)/4*2 - (int)(1.2*BAMBOO_HEIGHT) + DECORATION_HEIGHT/4, 
						DECORATION_WIDTH, DECORATION_HEIGHT);
				g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*i + DECORATION_WIDTH, (SIZE.height-BAMBOO_HEIGHT)/4*2 + (int)(1.2*BAMBOO_HEIGHT) + DECORATION_HEIGHT/4, 
						DECORATION_WIDTH, DECORATION_HEIGHT);
			}
			for(int i = 1; i < 3; i++)
				g.fillRect((SIZE.width-BAMBOO_WIDTH)/3*i + DECORATION_WIDTH, (SIZE.height-BAMBOO_HEIGHT)/4*2 + DECORATION_HEIGHT/4, 
						DECORATION_WIDTH, DECORATION_HEIGHT);
			
			break;
		case 9:
			// Left
			g.setColor(Color.RED);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4, 
					(SIZE.height-BAMBOO_HEIGHT)/4*2 - (int)(1.2*BAMBOO_HEIGHT), BAMBOO_WIDTH, BAMBOO_HEIGHT);		
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4, 
					(SIZE.height-BAMBOO_HEIGHT)/4*2, BAMBOO_WIDTH, BAMBOO_HEIGHT);	
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4, 
					(SIZE.height-BAMBOO_HEIGHT)/4*2 + (int)(1.2*BAMBOO_HEIGHT), BAMBOO_WIDTH, BAMBOO_HEIGHT);
			
			// Mid
			g.setColor(Color.BLUE);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*2, 
				(SIZE.height-BAMBOO_HEIGHT)/4*2 - (int)(1.2*BAMBOO_HEIGHT), BAMBOO_WIDTH, BAMBOO_HEIGHT);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*2, 
				(SIZE.height-BAMBOO_HEIGHT)/4*2, BAMBOO_WIDTH, BAMBOO_HEIGHT);			
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*2, 
				(SIZE.height-BAMBOO_HEIGHT)/4*2 + (int)(1.2*BAMBOO_HEIGHT), BAMBOO_WIDTH, BAMBOO_HEIGHT);
			
			// Right
			g.setColor(Color.GREEN);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*3, 
					(SIZE.height-BAMBOO_HEIGHT)/4*2 - (int)(1.2*BAMBOO_HEIGHT), BAMBOO_WIDTH, BAMBOO_HEIGHT);
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*3, 
					(SIZE.height-BAMBOO_HEIGHT)/4*2, BAMBOO_WIDTH, BAMBOO_HEIGHT);		
			g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*3, 
					(SIZE.height-BAMBOO_HEIGHT)/4*2 + (int)(1.2*BAMBOO_HEIGHT), BAMBOO_WIDTH, BAMBOO_HEIGHT);
			
			// Decoration
			g.setColor(Color.WHITE);
			for(int i = 1; i < 4; i++)
			{
				g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*i + DECORATION_WIDTH, (SIZE.height-BAMBOO_HEIGHT)/4*2 - (int)(1.2*BAMBOO_HEIGHT) + DECORATION_HEIGHT/4, 
						DECORATION_WIDTH, DECORATION_HEIGHT);
				g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*i + DECORATION_WIDTH, (SIZE.height-BAMBOO_HEIGHT)/4*2 + DECORATION_HEIGHT/4, 
						DECORATION_WIDTH, DECORATION_HEIGHT);
				g.fillRect((SIZE.width-BAMBOO_WIDTH)/4*i + DECORATION_WIDTH, (SIZE.height-BAMBOO_HEIGHT)/4*2 + (int)(1.2*BAMBOO_HEIGHT) + DECORATION_HEIGHT/4, 
						DECORATION_WIDTH, DECORATION_HEIGHT);
			}
			break;		
		default:
			System.err.println("Bad rank: " + rank);
		}
	}
	
}
