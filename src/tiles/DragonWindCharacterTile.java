package tiles;
import java.awt.*;

public class DragonWindCharacterTile extends CharacterTile 
{
	char chinese;
	public DragonWindCharacterTile(char symbol)
	{
		super(symbol);
		
		switch(symbol)
		{
		case 'N':
			chinese = '\u5317';
			break;
		case 'E':
			chinese = '\u6771';
			break;
		case 'S':
			chinese = '\u5357';
			break;
		case 'W':
			chinese = '\u897F';
			break;
		case 'C':
			chinese = '\u4E2D';
			break;
		case 'F':
			chinese = '\u767C';
			break;
		default:
			System.err.println("Bad character:" + symbol);
			break;
		}
	}
	
	@Override public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		draw(g);
	}
	
	private void draw(Graphics g)
	{		
		FontMetrics fm = g.getFontMetrics();

		// Set Chinese font size
		Font f = g.getFont();
		f = f.deriveFont((SIZE.height*.70F));
		g.setFont(f);
		fm = g.getFontMetrics();
		int chineseWidth = fm.stringWidth(Character.toString(chinese));
		int chineseHeight = fm.getHeight();
		
			
		// Draw Chinese char
		if(chinese == '\u4E2D')
			g.setColor(Color.RED);
		else if(chinese == '\u767C')
			g.setColor(Color.GREEN);
		else			
			g.setColor(Color.BLACK);
		g.drawString(Character.toString(chinese), (SIZE.width-chineseWidth)/2, SIZE.height-chineseHeight/3);	//SIZE.height-chineseHeight/3 works?
	}	
}
