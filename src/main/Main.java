package main;

import control.Controller;
import model.Board;
import view.SnakeGameGUI;

public class Main {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Board board = new Board(20, 20, 3);
		
		Controller control = new Controller(board);
		SnakeGameGUI gui = new SnakeGameGUI(board,control);
//		board.addObserver(gui);
//		control.addObserver(gui);
		control.run();
	}
}
