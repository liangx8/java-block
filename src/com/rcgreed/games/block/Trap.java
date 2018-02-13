package com.rcgreed.games.block;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class Trap extends JPanel implements KeyListener,ActionListener {
	/**
	 * 
	 */
	final private static int GAP=2;
	private static final long serialVersionUID = 1L;
	final private static int MX = 10;
	final private static int MY = 25;
	final private boolean[][] matrix=new boolean[MY][MX];
	public Trap() {
		super();
		for(int x=0;x<MX;x++) {
			for(int y=0;y<MY;y++) {
				matrix[y][x]=false;
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D) g;
		//drawDonut(g2d);
		drawMatrix(g2d);
	}

	private void drawMatrix(Graphics2D g2d) {
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		g2d.setRenderingHints(rh);

		Dimension size = getSize();
		double w = size.getWidth();
		double h = size.getHeight();
		int boxHeight=(((int)h-GAP)-MY*GAP)/MY;
		int xstart=((int)w - (boxHeight + GAP)*10)/2;
		g2d.setColor(Color.GRAY);
		for(int x=0;x<MX;x++) {
			for(int y=0;y<MY;y++) {
				if(matrix[y][x])
					g2d.fillRect(xstart+x*(boxHeight+GAP),GAP+y * (boxHeight+ GAP), boxHeight, boxHeight);
				else
					g2d.drawRect(xstart+x*(boxHeight+GAP),GAP+y * (boxHeight+ GAP), boxHeight, boxHeight);
				
			}
		}
		
		
	}
	private int pos;

	private void drawDonut(Graphics2D g2d) {

		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		g2d.setRenderingHints(rh);

		Dimension size = getSize();
		double w = size.getWidth();
		double h = size.getHeight();

		Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130);
		g2d.setStroke(new BasicStroke(1));
		g2d.setColor(Color.gray);

		for (double deg = 0; deg < 360; deg += 15) {
			AffineTransform at = AffineTransform.getTranslateInstance(w / 2, h / 2);
			at.rotate(Math.toRadians(deg));
			g2d.draw(at.createTransformedShape(e));
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	// for timer use
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		int x=pos % MX;
		int y=pos / MX;
		matrix[y][x]=false;
		pos++;
		if(pos >=MY*MX)pos=0;
		x=pos % MX;
		y=pos / MX;
		matrix[y][x]=true;
		repaint();
	}
}
