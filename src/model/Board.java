package model;

import java.awt.Point;
import java.util.List;
import java.util.Random;

public class Board {
	/**
	 * Number of rows
	 */
	private int rows;
	/**
	 * Number of columns
	 */
	private int cols;
	/**
	 * An array of Tile
	 */
	private Tile[][] tiles;
	/**
	 * The fruit coordinates
	 */
	private Point fruit;
	/**
	 * Constructor for Board, take rows and columns as parameters
	 * @param rows how many rows in the board
	 * @param cols how many columns in the board
	 */
	public Board(int rows,int cols, int snakeBodyLength) {
		this.rows = rows;
		this.cols = cols;
		this.tiles = new Tile[rows][cols];
		makeNorthWall();
		makeSouthWall();
		makeWestWall();
		makeEastWall();
		makeFruit();
		Snake s = new Snake((int)rows/2,(int)cols/2,snakeBodyLength,Direction.Up);
	}
	/**
	 * Make a fruit at random location.
	 */
	public void makeFruit() {
		int randomRow = (new Random()).nextInt(rows);
		int randomCol = (new Random()).nextInt(cols);
		this.fruit = new Point(randomCol,randomRow);
	}
	/**
	 * Make the north wall, set tile on the north boundary of the board to hasNorthWall
	 */
	private void makeNorthWall() {
		for(int i=0;i<cols;i++) {
			tiles[0][i].setHasNorthWall(true);
		}
	}
	/**
	 * Make the south wall, set tile on the south boundary of the board to hasSouthWall
	 */
	private void makeSouthWall() {
		for(int i=0;i<cols;i++) {
			tiles[rows-1][i].setHasSouthWall(true);
		}
	}
	/**
	 * Make the west wall, set tile on the west boundary of the board to hasWestWall
	 */
	private void makeWestWall() {
		for(int i=0;i<rows;i++) {
			tiles[i][0].setHasWestWall(true);
		}
	}
	/**
	 * Make the east wall, set tile on the east boundary of the board to hasEastWall
	 */
	private void makeEastWall() {
		for(int i=0;i<rows;i++) {
			tiles[i][cols-1].setHasEastWall(true);
		}
	}
	/**
	 * Get the tiles of board
	 */
	public Tile[][] getTiles() {
		return this.tiles;
	}
	/**
	 * Get the coord of fruit
	 */
	public Point getFruit() {
		return this.fruit;
	}
}
