package com.rcgreed.games.block;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame {
	/**
	 * for eliminate complaint
	 */
	private static final long serialVersionUID = 1L;
	private JLabel statusBar=new JLabel("game start");

	public MainFrame() {
		super("game");
		getContentPane().add(new Trap(), BorderLayout.CENTER);
		getContentPane().add(statusBar,BorderLayout.PAGE_END);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setJMenuBar(createMenuBar());
		setSize(500, 540);
		setLocationRelativeTo(null);// center main frame of screen
	}
	private JMenuBar createMenuBar() {
		JMenuBar menuBar=new JMenuBar();
		JMenu menuFile=new JMenu("Game");
		JMenu menuOption=new JMenu("Option");
		menuBar.add(menuFile);
		menuBar.add(menuOption);
		menuFile.setMnemonic(KeyEvent.VK_G);
		menuOption.setMnemonic(KeyEvent.VK_O);
		menuFile.getAccessibleContext().setAccessibleDescription("File menu");
		JMenuItem menuItem=new JMenuItem("New Game",KeyEvent.VK_N);
		menuFile.add(menuItem);
		menuItem.addActionListener(this::newAction);
		return menuBar;
	}
	private void newAction(ActionEvent e) {
		statusBar.setText("New selected!");
	}
}
