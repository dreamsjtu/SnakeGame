package view;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import control.Controller;
import model.Board;
import model.Direction;

public class PanelManager extends JPanel implements KeyListener {
	private Board board;
	private snakeGUI snakeGUI;
	private BoardGUI BoardGUI;
	private Controller control;
	public PanelManager(Board board,Controller control,int tileWidth,int tileHeight) {
		setLayout(new BorderLayout());
//		setLayout(null); //TODO why null layout not working here
//		setBounds(0, 0, SnakeGameGUI.WIDTH, SnakeGameGUI.HEIGHT);
		this.board = board;
		this.snakeGUI = new snakeGUI(0,0,SnakeGameGUI.WIDTH,SnakeGameGUI.HEIGHT,this.board,tileWidth,tileHeight);
		this.BoardGUI = new BoardGUI(0,0,SnakeGameGUI.WIDTH,SnakeGameGUI.HEIGHT,this.board,tileWidth,tileHeight);
		this.control = control;
		control.addObserver(snakeGUI);
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setLayout(null);
		int add =1;
		layeredPane.add(snakeGUI,add++);
		layeredPane.add(BoardGUI,add++);
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
		switch(key) {
		case KeyEvent.VK_W:
		case KeyEvent.VK_UP:
			control.setCurrentDirection(Direction.Up);
			System.out.println("Up");
			break;
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			control.setCurrentDirection(Direction.Down);
			System.out.println("Down");
			break;
		case KeyEvent.VK_A:
		case KeyEvent.VK_LEFT:
			control.setCurrentDirection(Direction.Left);
			System.out.println("Left");
			break;
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT:
			control.setCurrentDirection(Direction.Right);
			System.out.println("Right");
			break;
		default:
			break;
			
		}
		
	}
	
}
