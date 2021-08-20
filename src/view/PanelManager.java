package view;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import control.Controller;
import model.Board;
import model.Direction;

public class PanelManager extends JPanel implements Observer, KeyListener {
	private Board board;
	private snakeGUI snakeGUI;
	private BoardGUI BoardGUI;
	private Controller control;

	public PanelManager(Board board, Controller control, int tileWidth, int tileHeight) {
		setLayout(new BorderLayout());
//		setLayout(null); //TODO why null layout not working here
//		setBounds(0, 0, SnakeGameGUI.WIDTH, SnakeGameGUI.HEIGHT);
		this.board = board;
		this.snakeGUI = new snakeGUI(0, 0, SnakeGameGUI.WIDTH, SnakeGameGUI.HEIGHT, this.board, tileWidth, tileHeight);
		this.BoardGUI = new BoardGUI(0, 0, SnakeGameGUI.WIDTH, SnakeGameGUI.HEIGHT, this.board, tileWidth, tileHeight);
		this.control = control;
		control.addObserver(snakeGUI);
		control.addObserver(this);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setLayout(null);
		int add = 1;
		layeredPane.add(snakeGUI, add++);
		layeredPane.add(BoardGUI, add++);
		add(layeredPane);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch (key) {
		case KeyEvent.VK_W:
		case KeyEvent.VK_UP:
			control.addCurrentDirection(Direction.Up);
			System.out.println("Up");
			break;
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			control.addCurrentDirection(Direction.Down);
			System.out.println("Down");
			break;
		case KeyEvent.VK_A:
		case KeyEvent.VK_LEFT:
			control.addCurrentDirection(Direction.Left);
			System.out.println("Left");
			break;
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT:
			control.addCurrentDirection(Direction.Right);
			System.out.println("Right");
			break;
		default:
			break;
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if (control.isGameCompleted()) {
			int n = JOptionPane.showConfirmDialog(
				    this,
				    "New Game? ",
				    "Game over",
				    JOptionPane.YES_NO_OPTION);//TODO how to only show yes button? ps: YES_OPTION not working.
			if(n==JOptionPane.NO_OPTION){  
			    System.exit(0); 
			}else if(n==JOptionPane.YES_OPTION){
				Board board = new Board(20, 20, 3);
				Controller control = new Controller(board);
				SnakeGameGUI gui = new SnakeGameGUI(board,control);
				control.run();
			} 
			}
	}

}
