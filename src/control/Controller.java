package control;

import java.awt.Point;

import model.Board;
import model.Direction;
import model.Snake;

public class Controller {
	private Board board;
	private Snake snake;
	private boolean isGameCompleted;
	private Direction currentDirection;

	/**
	 * Game controller, run the game, observe changes in GUI.
	 * @param board
	 * @param snake
	 */
	public Controller(Board board, Snake snake) {
		this.board = board;
		this.snake = snake;
	}
	/**
	 * Run the game, until game finished.
	 */
	public void run() {
		while(!isGameCompleted) {
			int oldHeadX = snake.getSnakeHeadLocation().x;
			int oldHeadY = snake.getSnakeHeadLocation().y;
			switch(this.currentDirection) {
			case Up:
				tick(oldHeadX, oldHeadY, oldHeadX,oldHeadY-1 );
				break;
			case Down:
				tick(oldHeadX, oldHeadY, oldHeadX,oldHeadY+1 );
				break;
			case Left:
				tick(oldHeadX, oldHeadY, oldHeadX-1,oldHeadY );
				break;
			case Right:
				tick(oldHeadX, oldHeadY, oldHeadX+1,oldHeadY );
				break;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Failed to pause");
				e.printStackTrace();
			}
		}
	}
	/**
	 * A tick for the game.
	 */
	private void tick(int oldHeadX,int oldHeadY, int newHeadX,int newHeadY) {
		snake.setDirection(this.currentDirection);
		Point oldHeadLoc = new Point(oldHeadX,oldHeadY);
		Point newHeadLoc = new Point(newHeadX,newHeadY);
				if(board.getTiles()[oldHeadY][oldHeadX].hasWall(this.currentDirection)) {
					this.isGameCompleted = true;
					return;
				}
				//add the location of original head to the snake body elements coordinates list.
				snake.addBodyElemCoordFront(oldHeadLoc);
				//check if new snake head overlapped with snake body elements coordinates.
				for(int i=0;i<snake.getSnakeBodyEleCoords().size();i++) {
					if(snake.getSnakeBodyEleCoords().get(i).x==newHeadX&&snake.getSnakeBodyEleCoords().get(i).y==newHeadY) {
						this.isGameCompleted = true;
						return;
					}
				}
				//set the location of snake head
				snake.setSnakeHeadCoord(new Point(newHeadX,newHeadY));
				//check if there is a fruit on the new head location.
				//if there is nothing on this location,  remove the tail element from list, otherwise do nothing.
				if(newHeadX!=board.getFruit().x||newHeadY!=board.getFruit().y) {
					snake.removeBodyElemCoordEnd();
				}
		
	}
	
	private void setCurrentDirection(Direction direction) {
		this.currentDirection = direction;
	}
}
