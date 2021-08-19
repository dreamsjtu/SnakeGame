package snakeGame.main;

import snakeGame.model.Board;
import snakeGame.view.SnakeGameGUI;

public class Main {
	public static void main(String[] args) {
		Board board = new Board(20, 20, 3);
		SnakeGameGUI gui = new SnakeGameGUI();
		board.addObserver(gui);
	}
}
