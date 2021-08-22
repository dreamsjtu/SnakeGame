package main;

import control.Controller;
import model.Board;
import view.SnakeGameGUI;

public class Main {
	public static void main(String[] args) {
		//create the game board, 20 rows, 20 cols, 3 is the length of the snake body.
		Board board = new Board(20, 20, 3);
		//create the controller of the game
		Controller control = new Controller(board);
		//create the GUI for the game.
		new SnakeGameGUI(board,control);
		//run the game.
		control.run();
	}
}
