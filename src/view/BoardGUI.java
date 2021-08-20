package view;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import model.Board;

public class BoardGUI extends JPanel {
	private Board board;
	private int tileWidth;
	private int tileHeight;
	private TileGUI[][] tileGUIs;
	
	
	public BoardGUI(int x,int y, int width,int height,Board board, int tileWidth, int tileHeight) {
		this.setBounds(x, y, width,height);
		this.board = board;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
	}
	@Override
	public void paint(Graphics g) {
		this.tileGUIs = new TileGUI[board.getRows()][board.getCols()];
		for(int i=0;i<board.getRows();i++) {
			for(int j=0;j<board.getCols();j++) {
				this.tileGUIs[i][j]=new TileGUI(new Point(j,i),tileWidth,tileHeight);
			}
		}
		//draw frame.
		for(int i=0;i<board.getRows();i++) {
			for(int j=0;j<board.getCols();j++) {
				this.tileGUIs[i][j].paint(g);
			}
		}
	}

}
