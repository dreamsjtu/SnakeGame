package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

public class TileGUI{
	private Point loc;
	private int width;
	private int height;
	public TileGUI(Point loc,int width,int height) {
		this.loc = loc;
		this.width = width;
		this.height = height;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(loc.x*width, loc.y*height, width, height);
	}
}
