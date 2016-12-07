import	java.util.*;
import	java.awt.*;
import	javax.swing.*;


public class TileScrollPane extends JScrollPane
{
	private	JPanel[]	discard = new JPanel[2];
	private	Stack<Tile>	undoStack = new Stack<Tile>();
	//private	Stack<Tile>	redoStack = new Stack<Tile>();		// optional
	private		int		width = 71;
	private		int		height = 71;
	private		int		count = 0;

	public TileScrollPane()
	{
		setPreferredSize(new Dimension(0, 2 * height + 33));
		setBorder(BorderFactory.createRaisedBevelBorder());

		discard[0] = new JPanel(new FlowLayout(FlowLayout.LEFT));
		discard[1] = new JPanel(new FlowLayout(FlowLayout.LEFT));
		discard[0].setPreferredSize(new Dimension(0, height));
		discard[1].setPreferredSize(new Dimension(0, height));

		setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		JPanel	panel = new JPanel(new BorderLayout());
		setViewportView(panel);

		panel.add(discard[0], BorderLayout.NORTH);
		panel.add(discard[1], BorderLayout.SOUTH);

		discard[0].setBackground(new Color(254, 205, 33));
		discard[1].setBackground(new Color(254, 205, 33));
		panel.setBackground(new Color(254, 205, 33));
	}
	
	public Tile getRemoved() 
	{		
		if(!(undoStack.isEmpty()))
			return undoStack.pop();
		else
			return null;
	}

	public void addToUndo(Tile t1, Tile t2)
	{
		undoStack.push(t1);
		undoStack.push(t2);

		Dimension	size = new Dimension(++count * width, height + 6);
		discard[0].setPreferredSize(size);
		discard[1].setPreferredSize(size);

		// This version puts the most recently added tiles on the right and scrolls
		// a scroll pane so that the most recently added tiles are visible.

		/*
		discard[0].add(t1);
		discard[1].add(t2);
		*/

		Rectangle	r = new Rectangle(count * width, 0, width, height + 6);
		getViewport().scrollRectToVisible(r);


		// This version puts the most recently added tiles on the left - it doesn't
		// need to scroll - the most recently added tiles are always visible.

		discard[0].add(t1, 0);
		discard[1].add(t2, 0);

		revalidate();
		repaint();
	}

	public static void main(String[] args)
	{
		TileScrollPane	demo = new TileScrollPane();
		JFrame		frame = new JFrame();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(demo);
		frame.setSize(400, 250);
		frame.setVisible(true);

		try
		{
			int	pause = 1000;

			demo.addToUndo(new FlowerTile("Chrysanthemum"), new FlowerTile("Orchid"));
			Thread.sleep(pause);
			demo.addToUndo(new FlowerTile("Plum"), new FlowerTile("Bamboo"));
			Thread.sleep(pause);
			demo.addToUndo(new SeasonTile("Spring"), new SeasonTile("Summer"));
			Thread.sleep(pause);
			demo.addToUndo(new SeasonTile("Fall"), new SeasonTile("Winter"));
			Thread.sleep(pause);

			demo.addToUndo(new CharacterNumberTile('1'), new CharacterNumberTile('2'));
			Thread.sleep(pause);
			demo.addToUndo(new CharacterNumberTile('3'), new CharacterNumberTile('4'));
			Thread.sleep(pause);
			demo.addToUndo(new CharacterNumberTile('5'), new CharacterNumberTile('6'));
			Thread.sleep(pause);
			demo.addToUndo(new CharacterNumberTile('7'), new CharacterNumberTile('8'));
		}
		catch (InterruptedException ie)
		{
			System.out.println(ie);
		}
	}
}
