// TODO: Figure out why opening tsp JFrame messes with positioning of tiles (redraws top left)
// Z-Positioning when returning tiles is not always correct
// Implement sound (chap. 14)

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.EventHandler;

import javax.swing.*;

public class Mahjong extends JFrame
{
	private	static	Dimension boardSize = new Dimension(950, 570);
	private static String title = "Mahjong";
	private PlayBoard pb;
	private long seed;
	private boolean running;
	
	public Mahjong()
	{
		running = false;
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);	// ask user confirmation
		addWindowListener(new WindowAdapter()
		{ public void windowClosing(WindowEvent e)
			{ exit(); }
		});
		
		setTitle(title);
		setLayout(new BorderLayout());
		setPreferredSize(boardSize);
		pb = new PlayBoard();
		add(pb);
		makeMenuBar();
		pack();
		setVisible(true);
	}
	
	public void exit()
	{
		if(!running)
			System.exit(0);
		else if (JOptionPane.showConfirmDialog(this,
				"Do you want to end this program?", "End Program",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
			System.exit(0);
	}
		
	//public Dimension getDimension() { return boardSize; }
	
	public void playAction() 
	{
		if(running)
		{
			if(JOptionPane.showConfirmDialog(this,
					"Do you want to start a new game?", "New Game",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
			{

				// reset title in case numbered was clicked before
				setTitle(title);
				running = true;
				pb.start();
			}
		}
		else		
		{
			// reset title in case numbered was clicked before
			setTitle(title);
			running = true;
			pb.start(); 
		}
	}
	
	public void restartAction() 
	{
		if(running)
		{
			if(JOptionPane.showConfirmDialog(this,
					"Do you want to restart this game?", "Restart",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
			{
				pb.restart();
			}
		}
		else
		{
			running = true;
			pb.restart();
		}
	}
	
	public void numberAction()
	{
		if(running)
		{
			if(JOptionPane.showConfirmDialog(this,
				"Do you want to start a new numbered game?", "New Numbered Game",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
			{
				promptUser();
			}
		}
		else
			promptUser();
		
		// set title to seeded game
		setTitle(title + " " + pb.getSeed());
	}
	
	public void undoAction() { pb.undo(); }	
	public void showRemovedAction(){ pb.displayRemoved(); }
	
	public void soundOn() {pb.setSound(true);}
	public void soundOff() {pb.setSound(false);}
		
	public void rulesAction() { pb.displayRules(); }
	
	private void makeMenuBar()
	{
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		// menus
		JMenu gameMenu = makeMenu("Game", 'G');
		menuBar.add(gameMenu);
		JMenu soundMenu = makeMenu("Sound", 'S');
		menuBar.add(soundMenu);
		JMenu moveMenu = makeMenu("Move", 'M');
		menuBar.add(moveMenu);
		JMenu helpMenu = makeMenu("Help", 'H');
		menuBar.add(helpMenu);
		
		// game menu items
		gameMenu.add(makeMenuItem("Play", 'P', "playAction", this));
		gameMenu.add(makeMenuItem("Restart", 'R', "restartAction", this));
		gameMenu.add(makeMenuItem("Numbered", 'N', "numberAction", this));
		
		// move menu
		moveMenu.add(makeMenuItem("Undo", 'U', "undoAction", this));
		moveMenu.add(makeMenuItem("Removed Tiles", 'R', "showRemovedAction", this));
		
		// help menu
		helpMenu.add(makeMenuItem("Game Rules", 'R', "rulesAction", this));		

		// sound menu
		ButtonGroup soundGroup = new ButtonGroup();
		JRadioButtonMenuItem on = makeMenuRadioItem("On", 'n', "soundOn", this);
		soundMenu.add(on);
		JRadioButtonMenuItem off = makeMenuRadioItem("Off", 'f', "soundOff", this);
		soundMenu.add(off);		
		off.setSelected(true);
		soundGroup.add(on);
		soundGroup.add(off);	
	}
	
	private JMenu makeMenu(String label, char mnemonic)
	{
		JMenu	menu = new JMenu(label);
		menu.setMnemonic(mnemonic);
		return menu;
	}
	
	private JMenuItem makeMenuItem(String label, char mnemonic, String method, Object target)
	{
		JMenuItem	menuItem = new JMenuItem(label, mnemonic);

		// sets up event handling: "method" is called when "menuItem" is selected
		menuItem.addActionListener((ActionListener)EventHandler.create(ActionListener.class,
					target, method));

		return menuItem;
	}
	
	private JRadioButtonMenuItem makeMenuRadioItem(String label, char mnemonic, String method, Object target)
	{
		JRadioButtonMenuItem radioItem = new JRadioButtonMenuItem(label);
		radioItem.setMnemonic(mnemonic);
		
		radioItem.addActionListener((ActionListener)EventHandler.create(ActionListener.class, 
				target, method));
		
		
		return radioItem;
	}
	
	private void promptUser()
	{		
		if(JOptionPane.showConfirmDialog(this,
			"Do you want to enter a custom seed?", "Custom Seed",
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
		{
			String input;
			do
			{
				input = JOptionPane.showInputDialog(this, "Enter seed");
				try
				{
					if(input != null)
					{
						seed = Long.parseLong(input);
						pb.start(seed);
					}
					else
						return;
				}
				catch (NumberFormatException e)
				{
					seed = -1;
					JOptionPane.showMessageDialog(this, 
							"Bad seed", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} while(seed == -1);
		}
		else
		{
			// user chose to not supply seed
			pb.start();
		}
		
		
	}
	
	public static void main(String[] args)
	{
		new Mahjong();
	}	
}
