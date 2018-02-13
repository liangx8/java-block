package com.rcgreed.games.block;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.Timer;

public class MainFrame extends JFrame {
	/**
	 * for eliminate complaint
	 */
	private static final long serialVersionUID = 1L;
	private JLabel statusBar=new JLabel("game start");

	public MainFrame() {
		super("游戏");
		Trap trap=new Trap();
		Timer timer=new Timer(250,trap);
		getContentPane().add(trap, BorderLayout.CENTER);
		getContentPane().add(statusBar,BorderLayout.PAGE_END);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setJMenuBar(new MainMenuBar(this::newGame,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(timer.isRunning()) 
					timer.stop();
				else
					timer.start();
				
			}
		
			
		}));
		setSize(500, 540);
		setLocationRelativeTo(null);// center main frame on the screen
		setResizable(false);
		this.addKeyListener(trap);
		
	}
	private void newGame(ActionEvent e) {
		statusBar.setText(" New Game");
	}
	private static class MainMenuBar extends JMenuBar{
		public MainMenuBar(ActionListener newGame,ActionListener pauseGame) {
			super();
			JMenu menuFile=new JMenu("Game");
			JMenu menuOption=new JMenu("Option");
			add(menuFile);
			add(menuOption);
			menuFile.setMnemonic(KeyEvent.VK_G);
			menuOption.setMnemonic(KeyEvent.VK_O);
			menuFile.getAccessibleContext().setAccessibleDescription("File menu");
			JMenuItem menuItem=new JMenuItem("New Game",KeyEvent.VK_N);
			JMenuItem menuPause=new JMenuItem("Pause",KeyEvent.VK_P);
			menuFile.add(menuItem);
			menuFile.add(menuPause);
			menuItem.addActionListener(newGame);
			menuPause.addActionListener(pauseGame);
		}
	}
}
