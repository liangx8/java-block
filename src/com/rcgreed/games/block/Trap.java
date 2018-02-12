package com.rcgreed.games.block;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class Trap extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		drawDonut((Graphics2D) g);
	}

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
}
