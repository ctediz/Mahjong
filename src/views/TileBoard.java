package views;
import java.util.*;

import tiles.Bamboo1Tile;
import tiles.BambooTile;
import tiles.CharacterNumberTile;
import tiles.CircleTile;
import tiles.DragonWindCharacterTile;
import tiles.FlowerTile;
import tiles.Pancake;
import tiles.SeasonTile;
import tiles.Tile;
import tiles.WhiteDragonTile;

public class TileBoard 
{
	// Constants
	private static final int MAX_HEIGHT = 4;
	private static final int MAX_COLUMN_LENGTH = 14;
	private static final int MAX_ROW_LENGTH = 7;
	
	private Tile tileArray[][][] = new Tile[MAX_ROW_LENGTH+1][MAX_COLUMN_LENGTH+1][MAX_HEIGHT+1];	// row, column, layer
	private ArrayList<Tile> deck = new ArrayList<Tile>();		// holds tiles
	private Random r;
	private long time = 0;
	private int tileCount;
	
	public TileBoard(long seed)
	{
		time = seed;
		r = new Random(time);
		tileCount = 0;
		initializeBoard();
		createDeck();
		positionTile();
	}
	
	public int getTileCount() { return tileCount; }
	
	public boolean isTileOpen(int row, int column, int layer)
	{
		if(layer == MAX_HEIGHT)
		{
			// top layer is always free
			return true;
		}
		else if(layer == MAX_HEIGHT-1)
		{
			// check if top layer has a value
			return(tileArray[3][6][MAX_HEIGHT] == null);
		}
		else if(layer == 0)
		{
			if(column == 0 || column == MAX_COLUMN_LENGTH)
			{
				// always free
				return true;
			}
			else if(row == 0 || row == MAX_ROW_LENGTH)
			{
				// above is free, check left/right
				return(tileArray[row][column-1][layer] == null || tileArray[row][column+1][layer] == null);
			}
			else if(column == 1 && (row == 3 || row == 4))
			{
				// left check special case
				return(tileArray[3][column-1][layer] == null  || tileArray[row][column+1][layer] == null);
			}
			else if(column == 12 && (row == 3 || row == 4))
			{
				// right check special case
				return(tileArray[row][column-1][layer] == null  || tileArray[3][column+1][layer] == null);
			}
			else
			{
				// no more out of bounds can occur, free to check all neighbors
				// check above * left + right
				return(tileArray[row][column][layer+1] == null && 
						(tileArray[row][column-1][layer] == null || tileArray[row][column+1][layer] == null));				
			}
		}
		else
		{
			// no out of bounds can occur, free to check all neighbors
			// check above * left + right
			return(tileArray[row][column][layer+1] == null && 
					(tileArray[row][column-1][layer] == null || tileArray[row][column+1][layer] == null));
		}
	}
	
	public void removeTile(int row, int column, int layer)
	{
		//tileArray[row][column][layer].setPos(-1, -1, -1);
		tileArray[row][column][layer] = null;
	}
	
	public void addTile(Tile t)
	{
		tileArray[t.getYPos()][t.getXPos()][t.getZPos()] = t;
		tileCount++;
	}
	
	public void removeTile(Tile toRemove)
	{	
		tileArray[toRemove.getYPos()][toRemove.getXPos()][toRemove.getZPos()] = null;
		tileCount--;
	}
	
	public Tile[][][] getDeck()
	{
		return tileArray;
	}
	
	public void positionTile()
	{
		// layer 4
		loopAssign(3,3, 6,6, 4);
		
		// layer 3
		loopAssign(3,4, 6,7, 3);
				
		// layer 2
		loopAssign(2,5, 5,8, 2);
		
		// layer 1
		loopAssign(1,6, 4,9, 1);
				
		//layer 0
		// row 1
		loopAssign(0,0, 1,12, 0);		
		// row 2
		loopAssign(1,1, 3,10, 0);		
		// row 3
		loopAssign(2,2, 2,11, 0);		
		// row 4
		loopAssign(3,3, 0,14, 0);		
		// row 5
		loopAssign(4,4, 1,12, 0);		
		// row 6
		loopAssign(5,5, 2,11, 0);		
		// row 7
		loopAssign(6,6, 3,10, 0);		
		// row 8
		loopAssign(7,7, 1,12, 0);
	}
	
	private void loopAssign(int rowStart, int rowEnd, int columnStart, int columnEnd, int layer)
	{
		for(int row = rowStart; row <= rowEnd; row++)
		{
			for(int column = columnStart; column <= columnEnd; column++)
			{
				// set position in tile array
				tileArray[row][column][layer] = deck.get(deck.size()-1);
				// set position in tile object
				//deck.get(deck.size()-1).setPos((column)*60-layer*10, (row)*60-layer*10, layer);
				deck.get(deck.size()-1).setPos(column, row, layer);
				
				// remove from deck
				deck.remove(deck.size()-1);
				tileCount++;
			}
		}
	}
	
	private void initializeBoard()
	{
		for(int layer = 0; layer < MAX_HEIGHT; layer++)
		{
			for(int column = 0; column < MAX_COLUMN_LENGTH; column++)
			{
				for(int row = 0; row < MAX_ROW_LENGTH; row++)
				{
					tileArray[row][column][layer] = null;
				}
			}
		}
	}
	
	private void createDeck()
	{
		for(int i = 0; i < 4; i++)
		{
			deck.add(new CharacterNumberTile('1'));
			deck.add(new CharacterNumberTile('2'));
			deck.add(new CharacterNumberTile('3'));
			deck.add(new CharacterNumberTile('4'));
			deck.add(new CharacterNumberTile('5'));
			deck.add(new CharacterNumberTile('6'));
			deck.add(new CharacterNumberTile('7'));
			deck.add(new CharacterNumberTile('8'));
			deck.add(new CharacterNumberTile('9'));

			deck.add(new Pancake(1));
			deck.add(new CircleTile(2));
			deck.add(new CircleTile(3));
			deck.add(new CircleTile(4));
			deck.add(new CircleTile(5));
			deck.add(new CircleTile(6));
			deck.add(new CircleTile(7));
			deck.add(new CircleTile(8));
			deck.add(new CircleTile(9));

			deck.add(new Bamboo1Tile());
			deck.add(new BambooTile(2));
			deck.add(new BambooTile(3));
			deck.add(new BambooTile(4));
			deck.add(new BambooTile(5));
			deck.add(new BambooTile(6));
			deck.add(new BambooTile(7));
			deck.add(new BambooTile(8));
			deck.add(new BambooTile(9));

			// DragonWindCharacterTile extends CharacterTile (abstract)
			deck.add(new DragonWindCharacterTile('N'));
			deck.add(new DragonWindCharacterTile('E'));
			deck.add(new DragonWindCharacterTile('W'));
			deck.add(new DragonWindCharacterTile('S'));

			deck.add(new DragonWindCharacterTile('C'));
			deck.add(new DragonWindCharacterTile('F'));
			deck.add(new WhiteDragonTile());
		}
		
		deck.add(new FlowerTile("Chrysanthemum"));
		deck.add(new FlowerTile("Orchid"));
		deck.add(new FlowerTile("Plum"));
		deck.add(new FlowerTile("Bamboo"));

		deck.add(new SeasonTile("Spring"));
		deck.add(new SeasonTile("Summer"));
		deck.add(new SeasonTile("Fall"));
		deck.add(new SeasonTile("Winter"));
		
		Collections.shuffle(deck, r);
	}
}
