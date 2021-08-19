package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import model.Board;

public class SnakeGameGUI extends JFrame implements Observer{
	private static final int WIDTH = 600;
	private static final int HEIGHT = 600;
	private Board board;
	private List<TileGUI> tileGUIs = new ArrayList<TileGUI>();
	public SnakeGameGUI(Board board) {
		this.board = board;
		this.setSize(WIDTH, HEIGHT);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width-WIDTH)/2;
		int y = (screen.height-HEIGHT)/2;
		this.setLocation(x, y);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	@Override
	public void paint(Graphics g) {
		if(board==null)return;
		int tileWidth = WIDTH/board.getCols();
		int tileHeight =HEIGHT/board.getRows();
		for(int i=0;i<board.getRows();i++) {
			for(int j=0;j<board.getCols();j++) {
				this.tileGUIs.add(new TileGUI(new Point(j,i),tileWidth,tileHeight));
			}
		}
		for(int i=0;i<this.tileGUIs.size();i++) {
			this.tileGUIs.get(i).paint(g);
		}
	}
	@Override
	public void update(Observable o, Object arg) {
		this.board = (Board)o;
		this.repaint();
	}
	
}
