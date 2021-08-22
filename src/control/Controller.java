package control;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import model.Board;
import model.Direction;
import model.Snake;

@SuppressWarnings("deprecation")
public class Controller extends Observable {
	private Board board;
	private Snake snake;
	private boolean isGameCompleted;
	private Direction currentDirection;
	private List<Direction> directions = new ArrayList<>();

	/**
	 * Game controller, run the game, observe changes in GUI.
	 * 
	 * @param board
	 */
	public Controller(Board board) {
		this.board = board;
		this.snake = board.getSnake();
		this.currentDirection = snake.getCurrentDirection();
	}

	/**
	 * Run the game, until game finished.
	 */
	public void run() {
		this.directions.add(currentDirection);
		while (!isGameCompleted) {
			int oldHeadX = snake.getSnakeHeadCoord().x;
			int oldHeadY = snake.getSnakeHeadCoord().y;
			if (this.directions.size() > 0) {
				this.currentDirection = this.directions.remove(0);
			}
			switch (this.currentDirection) {
			case Up:
				tick(oldHeadX, oldHeadY, oldHeadX, oldHeadY - 1);
				break;
			case Down:
				tick(oldHeadX, oldHeadY, oldHeadX, oldHeadY + 1);
				break;
			case Left:
				tick(oldHeadX, oldHeadY, oldHeadX - 1, oldHeadY);
				break;
			case Right:
				tick(oldHeadX, oldHeadY, oldHeadX + 1, oldHeadY);
				break;
			}
			setChanged();
			notifyObservers();
			try {
				//speed of the snake movement
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println("Failed to pause");
				e.printStackTrace();
			}
		}
		// game over, notify all observers , (PanelManager) to show option pane
		setChanged();
		notifyObservers();
	}

	/**
	 * 
	 * A tick for the game.
	 * 
	 * @param oldHeadX the old x coordinate of snake head
	 * @param oldHeadY the old y coordinate of snake head
	 * @param newHeadX the new x coordinate of snake head
	 * @param newHeadY the new y coordinate of snake head
	 */
	private void tick(int oldHeadX, int oldHeadY, int newHeadX, int newHeadY) {
		snake.setDirection(this.currentDirection);
		Point oldHeadLoc = new Point(oldHeadX, oldHeadY);
		if (board.getTiles()[oldHeadY][oldHeadX].hasWall(this.currentDirection)) {
			this.isGameCompleted = true;
			return;
		}
		// add the location of original head to the snake body elements coordinates
		// list.
		snake.addBodyElemCoordFront(oldHeadLoc);
		// check if new snake head overlapped with snake body elements coordinates.
		for (int i = 0; i < snake.getSnakeBodyEleCoords().size(); i++) {
			if (snake.getSnakeBodyEleCoords().get(i).x == newHeadX
					&& snake.getSnakeBodyEleCoords().get(i).y == newHeadY) {
				this.isGameCompleted = true;
				return;
			}
		}
		// set the location of snake head
		snake.setSnakeHeadCoord(new Point(newHeadX, newHeadY));
		// check if there is a fruit on the new head location.
		// if there is nothing on this location, remove the tail element from list,
		// otherwise make another fruit.
		if (newHeadX != board.getFruit().x || newHeadY != board.getFruit().y) {
			snake.removeBodyElemCoordEnd();
		} else {
			board.makeFruit();
		}
	}

	/**
	 * Add current direction to the directions list.
	 * @param direction -the direction enum.
	 */
	public void addCurrentDirection(Direction direction) {
		if (this.directions.size() != 0) {
			//check if new direction is opposed to the las direction, if yes, do nothing.
			//otherwise add the direction to the direction list.
			switch (this.directions.get(this.directions.size() - 1)) {
			case Up:
				if (direction == Direction.Down)
					return;
				break; // TODO don't understand why break still necessary here.
			case Down:
				if (direction == Direction.Up)
					return;
				break;
			case Left:
				if (direction == Direction.Right)
					return;
				break;
			case Right:
				if (direction == Direction.Left)
					return;
				break;
			default:
				break;
			}
		}
		this.directions.add(direction);
	}
	/**
	 * return the completion status of the game.
	 * @return return true if game completed, false if not.
	 */
	public boolean isGameCompleted() {
		return isGameCompleted;
	}
}
