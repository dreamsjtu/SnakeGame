package model;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Snake {
	/**
	 * Current coordinate of the snake's head
	 */
	private Point snakeHeadCoord;
	/**
	 * Current coordinates of the snake's body
	 */
	private List<Point> snakeBodyEleCoords = new ArrayList<>();
	/**
	 * Body length of current snake
	 */
	private int bodyLength;
	/**
	 * current direction of the snake
	 */
	private Direction currentDirection;
	/**
	 * previous direction of the snake
	 */
	private Direction previousDirection;
	/**
	 * Constructor of Snake object
	 * @param snakeHeadRow 
	 * @param snakeHeadCol
	 * @param bodyLength
	 * @param direction
	 */
	
	public Snake(int snakeHeadRow, int snakeHeadCol, int bodyLength,Direction direction) {
		this.snakeHeadCoord = new Point(snakeHeadRow,snakeHeadCol);
		this.bodyLength = bodyLength;
		this.currentDirection = direction;
		switch(direction) {
		case Up:
			for(int i=1;i<=bodyLength;i++) {
			snakeBodyEleCoords.add(new Point(snakeHeadCol,snakeHeadRow+i));
			}
			break;
		case Down:
			for(int i=1;i<=bodyLength;i++) {
				snakeBodyEleCoords.add(new Point(snakeHeadCol,snakeHeadRow-i));
				}
				break;
		case Left:
			for(int i=1;i<=bodyLength;i++) {
				snakeBodyEleCoords.add(new Point(snakeHeadCol+i,snakeHeadRow));
				}
				break;
		case Right:
			for(int i=1;i<=bodyLength;i++) {
				snakeBodyEleCoords.add(new Point(snakeHeadCol-i,snakeHeadRow));
				}
				break;
		default:
			throw new RuntimeException("Please input correct direction");
		}
	}
	/**
	 * Set the direction of snake.
	 * @param direction
	 */
	public void setDirection(Direction direction) {
		this.previousDirection = this.currentDirection;
		this.currentDirection = direction;
		
	}
	/**
	 * Add a new body element coordinate to beginning of the List.
	 * @param newBodyEleCoord
	 */
	public void addBodyElemCoordFront(Point newBodyEleCoord) {
		this.snakeBodyEleCoords.add(0,newBodyEleCoord);
	}
	/**
	 * Remove a new body element coordinate from end of the List.
	 */
	public void removeBodyElemCoordEnd() {
		this.snakeBodyEleCoords.remove(snakeBodyEleCoords.size()-1);
	}
	/**
	 * get the coordinate of snake head
	 * @return coordinate of snake head
	 */
	public Point getSnakeHeadLocation() {
		return snakeHeadCoord;
	}
	/**
	 * get the snake body elements' coordinates.
	 * @return a List of Points
	 */
	public List<Point> getSnakeBodyEleCoords() {
		return snakeBodyEleCoords;
	}
	/**
	 * Get the current Direction of the snake
	 * @return direction
	 */
	public Direction getCurrentDirection() {
		return currentDirection;
	}
	/**
	 * Get the previous direction of the snake
	 * @return direction
	 */
	public Direction getPreviousDirection() {
		return previousDirection;
	}

	/**
	 * set the coordinate of snake head
	 */
	public void setSnakeHeadCoord(Point loc) {
		this.snakeHeadCoord = loc;
	}
}
