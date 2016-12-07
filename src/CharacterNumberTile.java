import java.awt.*;

public class CharacterNumberTile extends CharacterTile
{
	private char chineseNumber;
	private static final char WAN_CHAR = '\u842C';
	
	public CharacterNumberTile(char number)
	{
		super(number);
		
		switch(number)
		{
		case '1':
			chineseNumber = '\u4E00';
			break;
		case '2':
			chineseNumber = '\u4E8C';
			break;
		case '3':
			chineseNumber = '\u4E09';
			break;
		case '4':
			chineseNumber = '\u56DB';
			break;
		case '5':
			chineseNumber = '\u4E94';
			break;
		case '6':
			chineseNumber = '\u516D';
			break;
		case '7':
			chineseNumber = '\u4E03';
			break;
		case '8':
			chineseNumber = '\u516B';
			break;
		case '9':
			chineseNumber = '\u4E5D';
			break;
		default:
			System.err.println("Bad number: " + number);
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
		// Draw wan
		Font f = g.getFont();
		f = f.deriveFont((SIZE.height*.35F));
		g.setFont(f);
		FontMetrics fm = g.getFontMetrics();
		int chineseWidth = fm.stringWidth(Character.toString(WAN_CHAR));
		int chineseHeight = fm.getHeight();
		
		g.setColor(Color.RED);
		g.drawString(Character.toString(WAN_CHAR), (SIZE.width-chineseWidth)/2, SIZE.height-chineseHeight/3);
		
		// Draw Chinese number char
		
		
		g.setColor(Color.BLACK);
		g.drawString(Character.toString(chineseNumber), (SIZE.width-chineseWidth)/2, SIZE.height/2-chineseHeight/4);
	}
	
}
