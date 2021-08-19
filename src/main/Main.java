package main;

import model.Board;
import view.SnakeGameGUI;

public class Main {
	public static void main(String[] args) {
		Board board = new Board(20, 20, 3);
		SnakeGameGUI gui = new SnakeGameGUI(board);
		board.addObserver(gui);
	}
}
