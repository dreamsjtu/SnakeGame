package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import control.Controller;
import model.Board;
import model.Direction;

public class SnakeGameGUI extends JFrame{
	public static final int WIDTH = 600;
	public static final int HEIGHT = 600;
	private int tileWidth;
	private int tileHeight;
	private Board board;
	private TileGUI[][] tileGUIs ;
	private Controller control;
	private PanelManager panelManager;
	private JLayeredPane layeredPane;
	public SnakeGameGUI(Board board, Controller control) {
		//---------------JFrame---------------------
		this.setVisible(true);
		this.board = board;
		this.control = control;
		tileWidth = WIDTH/(board.getCols());
		tileHeight = HEIGHT/(board.getRows()+1);
		this.setSize(WIDTH, HEIGHT);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width-WIDTH)/2;
		int y = (screen.height-HEIGHT)/2;
		this.setLocation(x, y);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//--------------JPanel----------------------------
		this.panelManager = new PanelManager(board, control, tileWidth, tileHeight);
		this.add(panelManager);
		//add the key, mouse, and mouse motion listeners to the panelGame
		this.addKeyListener(this.panelManager);
		//if we don't do this, our player events are never received by the panel
		this.setFocusable(true);
	}
}
