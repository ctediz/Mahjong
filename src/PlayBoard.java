import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayBoard extends JPanel implements MouseListener
{
	private final static int SEED_MOD = 100000;
	private TileBoard board;
	private ImageIcon background; // = new ImageIcon("images/dragon_bg.png");
	private String file = "images/dragon_bg.png";
	private Tile selected;
	private TileScrollPane tsp;
	private long seed;
	private JFrame tspFrame;
	private Help rules;
	private PlayClip removeClip;
	private Fireworks fw;
	private boolean sound;
	
	// User provided seed
	public PlayBoard(long seed)
	{		
		this.seed = seed;
		selected = null;
		setLayout(null);
		
		background = new ImageIcon(
				new GetPicture(file).getImage().getImage().getScaledInstance(930, 540, Image.SCALE_FAST));
		setVisible(true);	

		rules = new Help("help/rules.html", "Rules");
		
		removeClip = new PlayClip("audio/stone-scraping.wav");
		
		initRemoved();
		initFireworks();
	}
	
	// generates a seed and calls seeded constructor
	public PlayBoard() { this((System.currentTimeMillis()%SEED_MOD)); }
	
	public void displayRules(){ rules.display(); }
	
	// default start, always gets a new seed
	public void start()
	{
		// get new seed
		seed = System.currentTimeMillis() % SEED_MOD;
		
		// clear board if not empty
		board = new TileBoard(seed);
		removeAll();
		repaint();
		
		// clear removed tiles
		tspFrame.dispose();
		initRemoved();
		
		// place new tiles
		placeTurtle();
		setVisible(true);
		selected = null;
	}
	
	// call restarts without resetting seed
	public void restart()
	{ 
		board = new TileBoard(seed);
		removeAll();
		repaint();
		
		// clear removed tiles
		tspFrame.dispose();
		initRemoved();
		
		// place new tiles
		placeTurtle();
		setVisible(true);
		selected = null;
	}
	
	// start with user defined seed
	public void start(long userSeed)
	{
		seed = userSeed;
		restart();
	}
	
	public long getSeed() { return seed; }
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		background.paintIcon(this, g, 0, 0);
	}
	
	public void setSound(boolean b)
	{
		sound = b;
	}

	public void mousePressed(MouseEvent e) 
	{ 		
		Tile clicked = (Tile)e.getSource();
		if(e.getButton() == MouseEvent.BUTTON1)
		{
			// selected tile is free and tile has not been chosen
			if(board.isTileOpen(clicked.getYPos(), clicked.getXPos(), clicked.getZPos()) && selected == null)
			{				
				selected = clicked;
				selected.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
			}
			// selected tile if free and a tile has been chosen before and is not the same tile that has already been selected
			else if(board.isTileOpen(clicked.getYPos(), clicked.getXPos(), clicked.getZPos()) && selected.matches(clicked) && selected != clicked)
			{
				selected.setZOrder();
				remove(selected);
				clicked.setZOrder();
				remove(clicked);
				tsp.addToUndo(selected, clicked);
				board.removeTile(clicked);
				board.removeTile(selected);
				selected.setBorder(null);
				selected = null;
				
				// play sound
				if(sound)
					removeClip.play();
				
				// all tiles removed!
				if(board.getTileCount() == 0)
				{
					fw.setSound(sound);
					fw.fire();
				}
				
				repaint();
			}	
			else if(selected == clicked)	// deselect
			{
				selected.setBorder(null);
				selected = null;
			}
		}
	}
	
	public void mouseClicked(MouseEvent e) { }	
	public void mouseEntered(MouseEvent e) { }
	public void mouseExited(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }

	public void undo()
	{
		Tile t1, t2;
		
		// get last two pairs removed from tsp
		t1 = tsp.getRemoved();
		t2 = tsp.getRemoved();
		
		// nothing to undo
		if(t1 == null)
		{
			System.out.println("Nothing to undo!");
			return;
		}
		
		// readd tiles to PlayBoard
		reAdd(t1, t1.getZOrder());
		reAdd(t2, t2.getZOrder());		

		tsp.repaint();
	}
	
	public void displayRemoved()
	{
		tspFrame.setVisible(true);
	}
	
	private void initFireworks()
	{
		fw = new Fireworks(this);
		fw.setExplosions(0, 1000);
	}
	
	private void initRemoved()
	{
		tsp = new TileScrollPane();		
		tspFrame = new JFrame();
		Dimension size = new Dimension(250,250);
		tspFrame.add(tsp);
		tspFrame.setSize(size);
	}
	
	private void reAdd(Tile t, int order)
	{
		board.addTile(t);		
		
		add(t);
		setComponentZOrder(t, t.getZOrder());
		
		repaint();
	}
	
	private void placeTurtle()
	{
		// start from top layer work down
			// bottom right to top left
		// layer 4
		// special positioning		
		add(board.getDeck()[3][6][4]).setLocation(
				board.getDeck()[3][6][4].getXPos()*60-4*10+30, 
				board.getDeck()[3][6][4].getYPos()*60-4*10+30);
		board.getDeck()[3][6][4].addMouseListener(this);
				
		// layer 3
		reverseLoopPlace(4,3, 7,6, 3);
		
		// layer 2
		reverseLoopPlace(5,2, 8,5, 2);
		
		// layer 1
		reverseLoopPlace(6,1, 9,4, 1);
		
		// layer 0 
		// row 7
		reverseLoopPlace(7,7, 12,1, 0);
		
		// row 6
		reverseLoopPlace(6,6, 10,3, 0);
		
		// row 5
		reverseLoopPlace(5,5, 11,2, 0);
		
		// row 4
		// right side special tiles
		add(board.getDeck()[3][14][0]).setLocation(
				board.getDeck()[3][14][0].getXPos()*60, 
				board.getDeck()[3][14][0].getYPos()*60+30);
		board.getDeck()[3][14][0].addMouseListener(this);
		
		add(board.getDeck()[3][13][0]).setLocation(
				board.getDeck()[3][13][0].getXPos()*60, 
				board.getDeck()[3][13][0].getYPos()*60+30);
		board.getDeck()[3][13][0].addMouseListener(this);		
		
		reverseLoopPlace(4,4, 12,1, 0);
		
		// row 3
		reverseLoopPlace(3,3, 12,1, 0);
		// left side special tile
		add(board.getDeck()[3][0][0]).setLocation(
				board.getDeck()[3][0][0].getXPos()*60, 
				board.getDeck()[3][0][0].getYPos()*60+30);		
		board.getDeck()[3][0][0].addMouseListener(this);
		board.getDeck()[3][0][0].setZOrder();
		
		// row 2
		reverseLoopPlace(2,2, 11,2, 0);
		
		// row 1
		reverseLoopPlace(1,1, 10,3, 0);
		
		// row 0
		reverseLoopPlace(0,0, 12,1, 0);
	}
	
	private void reverseLoopPlace(int rowStart, int rowEnd, int columnStart, int columnEnd, int layer)
	{
		for(int row = rowStart; row >= rowEnd; row--)
		{
			for(int column = columnStart; column >= columnEnd; column--)
			{
				add(board.getDeck()[row][column][layer]).setLocation(
						board.getDeck()[row][column][layer].getXPos()*60-layer*10, board.getDeck()[row][column][layer].getYPos()*60-layer*10);
				
				board.getDeck()[row][column][layer].addMouseListener(this);
			}
		}
	}
}
