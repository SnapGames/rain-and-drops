package com.snapgames.gdj.prototype.rainanddrops;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.snapgames.gdj.prototype.rainanddrops.ui.RPanel;

/**
 * The main Class to start the RainAndDrops prototype.
 * 
 * @author Frédéric Delorme
 *
 */
public class RainAndDropsApp {

	/*
	 * THe main method.
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(800, 600);
		final RPanel rPanel = new RPanel();
		frame.add(rPanel);
		frame.setVisible(true);
		frame.setBackground(Color.BLACK);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				rPanel.stop();
				System.exit(0);
			}
		});
	}
}