package tests;
import	java.awt.*;
//import	java.awt.event.*;
//import	java.util.*;
import	javax.swing.*;

import tiles.Bamboo1Tile;
import tiles.BambooTile;
import tiles.CharacterNumberTile;
import tiles.CircleTile;
import tiles.DragonWindCharacterTile;
import tiles.FlowerTile;
import tiles.Pancake;
import tiles.SeasonTile;
import tiles.WhiteDragonTile;


public class Lab5 extends JFrame
{
	private	GridBagLayout		layout = new GridBagLayout();
	private	GridBagConstraints	constraints = new GridBagConstraints();
	private	JPanel			tilePanel = new JPanel(layout);


	public Lab5()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Mah Jong Tiles Demo");

		constraints.ipadx = 70;
		constraints.ipady = 70;
		constraints.insets = new Insets(5, 5, 5, 5);
		add(new JScrollPane(tilePanel));

		// CharacterNumberTile extends CharacterTile (abstract)
		addComponent(new CharacterNumberTile('1'), 0, 0);
		addComponent(new CharacterNumberTile('2'), 0, 1);
		addComponent(new CharacterNumberTile('3'), 0, 2);
		addComponent(new CharacterNumberTile('4'), 0, 3);
		addComponent(new CharacterNumberTile('5'), 0, 4);
		addComponent(new CharacterNumberTile('6'), 0, 5);
		addComponent(new CharacterNumberTile('7'), 0, 6);
		addComponent(new CharacterNumberTile('8'), 0, 7);
		addComponent(new CharacterNumberTile('9'), 0, 8);

		addComponent(new Pancake(1), 1, 0);
		addComponent(new CircleTile(2), 1, 1);
		addComponent(new CircleTile(3), 1, 2);
		addComponent(new CircleTile(4), 1, 3);
		addComponent(new CircleTile(5), 1, 4);
		addComponent(new CircleTile(6), 1, 5);
		addComponent(new CircleTile(7), 1, 6);
		addComponent(new CircleTile(8), 1, 7);
		addComponent(new CircleTile(9), 1, 8);

		addComponent(new Bamboo1Tile(), 2, 0);
		addComponent(new BambooTile(2), 2, 1);
		addComponent(new BambooTile(3), 2, 2);
		addComponent(new BambooTile(4), 2, 3);
		addComponent(new BambooTile(5), 2, 4);
		addComponent(new BambooTile(6), 2, 5);
		addComponent(new BambooTile(7), 2, 6);
		addComponent(new BambooTile(8), 2, 7);
		addComponent(new BambooTile(9), 2, 8);

		// DragonWindCharacterTile extends CharacterTile (abstract)
		addComponent(new DragonWindCharacterTile('N'), 3, 0);
		addComponent(new DragonWindCharacterTile('E'), 3, 1);
		addComponent(new DragonWindCharacterTile('W'), 3, 2);
		addComponent(new DragonWindCharacterTile('S'), 3, 3);

		addComponent(new DragonWindCharacterTile('C'), 4, 0);
		addComponent(new DragonWindCharacterTile('F'), 4, 1);
		addComponent(new WhiteDragonTile(), 4, 2);

		addComponent(new FlowerTile("Chrysanthemum"), 5, 0);
		addComponent(new FlowerTile("Orchid"), 5, 1);
		addComponent(new FlowerTile("Plum"), 5, 2);
		addComponent(new FlowerTile("Bamboo"), 5, 3);

		addComponent(new SeasonTile("Spring"), 6, 0);
		addComponent(new SeasonTile("Summer"), 6, 1);
		addComponent(new SeasonTile("Fall"), 6, 2);
		addComponent(new SeasonTile("Winter"), 6, 3);

		pack();
		setVisible(true);
	}


	private void addComponent(Component c, int row, int col)
	{
		constraints.gridx = col;
		constraints.gridy = row;
		layout.setConstraints(c, constraints);
		tilePanel.add(c);
	}


	public static void main(String[] args)
	{
		new Lab5();
	}
}
