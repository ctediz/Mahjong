import javax.swing.*;

import java.awt.*;

abstract public class PictureTile extends Tile
{
	private String name;
	private ImageIcon img;
	//private GetPicture gp;

	private static final int SCALE_HEIGHT = (int)(SIZE.height*.85);
	private static final int SCALE_WIDTH = (int)(SIZE.width*.85);
	
	public PictureTile(String name)
	{
		this.name = name;
		setToolTipText(toString());
	}
	
	public String toString()
	{
		return name;
	}
	
	public void setImage(String file)
	{
		img = (new GetPicture(file).getImage());
		
		
		// Scale images to size of tile
		if(img.getIconHeight() > img.getIconWidth())
			img = new ImageIcon(img.getImage().getScaledInstance(-1, SCALE_HEIGHT, Image.SCALE_SMOOTH));
		else
			img = new ImageIcon(img.getImage().getScaledInstance(SCALE_WIDTH, -1, Image.SCALE_SMOOTH));
	}
	
	@Override public void paintComponent(Graphics g)
	{
		super.paintComponent(g);		
		
		img.paintIcon(this, g, SIZE.width/2-SCALE_WIDTH/2, SIZE.height/2-SCALE_HEIGHT/2);
	}	
	
	
}
