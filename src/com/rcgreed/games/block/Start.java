package com.rcgreed.games.block;

import javax.swing.SwingUtilities;

public class Start {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(Start::gui);
	}
	private static void gui() {

		new MainFrame().setVisible(true);
		
	}
	

}
