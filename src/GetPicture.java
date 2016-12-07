import java.net.*;
import javax.swing.*;

public class GetPicture 
{
	private ImageIcon img;
	
	public GetPicture(String file)
	{		
		URL url = GetPicture.class.getResource(file);
		img = new ImageIcon(url);
	}
	public ImageIcon getImage()
	{
		return img;
	}
}
