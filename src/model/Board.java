package model;

import java.awt.Point;
import java.util.Observable;
import java.util.Random;

@SuppressWarnings("deprecation")
public class Board extends Observable{
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
	 * The snake
	 */
	private Snake snake;
	/**
	 * Constructor for Board, take rows and columns as parameters
	 * @param rows how many rows in the board
	 * @param cols how many columns in the board
	 * @param snakeBodyLength the length of the snake body.
	 */
	public Board(int rows,int cols, int snakeBodyLength) {
		this.rows = rows;
		this.cols = cols;
		this.tiles = new Tile[rows][cols];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				this.tiles[i][j]= new Tile();
			}
		}
		//set the walls
		makeNorthWall();
		makeSouthWall();
		makeWestWall();
		makeEastWall();
		//create the snake.
		this.snake = new Snake((int)rows/2,(int)cols/2,snakeBodyLength,Direction.Up);
		makeFruit();
	}
	/**
	 * Make a fruit at random location, not overlap with snake.
	 */
	public void makeFruit() {
		int randomRow = (new Random()).nextInt(rows);
		int randomCol = (new Random()).nextInt(cols);
		//fruit couldn't overlap with snake (body and head)
		for(int i=0;i<this.snake.getSnakeBodyEleCoords().size();i++) {
			if((this.snake.getSnakeBodyEleCoords().get(i).x==randomCol&&this.snake.getSnakeBodyEleCoords().get(i).y==randomRow)||(this.snake.getSnakeHeadCoord().x==randomCol&&this.snake.getSnakeHeadCoord().y==randomRow)) {
				makeFruit();
				return;
			}
		}
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
	 * @return return an array of all the tiles
	 */
	public Tile[][] getTiles() {
		return this.tiles;
	}
	/**
	 * Get the coord of fruit
	 * @return the fruit coordinate 
	 */
	public Point getFruit() {
		return this.fruit;
	}
	/**
	 * Get the rows of tiles
	 * @return the rows
	 */
	public int getRows() {
		return this.rows;
	}
	/**
	 * Get the cols of tiles
	 * @return the cols
	 */
	public int getCols() {
		return this.cols;
	}
	/**
	 * Get the snake
	 * @return the snake
	 */
	public Snake getSnake() {
		return this.snake;
	}
}

