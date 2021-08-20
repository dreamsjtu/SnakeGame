package view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import model.Board;
import model.Snake;

public class snakeGUI extends JPanel implements Observer {
	private Snake snake;
	private int tileWidth;
	private int tileHeight;
	private Board board;


	public snakeGUI(int x,int y, int width, int height,Board board,int tileWidth, int tileHeight) {
		
		this.setBounds(x,y,width,height);
		this.board = board;
		this.snake = board.getSnake();
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		setOpaque(false);
	}

	@Override
	public void paint(Graphics g) {
		// draw fruit
		g.setColor(Color.red);
		g.fillOval(board.getFruit().x * tileWidth,
				board.getFruit().y * tileHeight, tileWidth, tileHeight);
		// draw snake head
		g.setColor(Color.blue);
		g.fillOval(snake.getSnakeHeadCoord().x * tileWidth,
				snake.getSnakeHeadCoord().y * tileHeight, tileWidth, tileHeight);
		// draw snake body
		g.setColor(Color.green);
		for (int i = 0; i < snake.getSnakeBodyEleCoords().size(); i++) {
			g.fillOval(snake.getSnakeBodyEleCoords().get(i).x * tileWidth,
					snake.getSnakeBodyEleCoords().get(i).y * tileHeight, tileWidth, tileHeight);
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		this.repaint();
	}

}
