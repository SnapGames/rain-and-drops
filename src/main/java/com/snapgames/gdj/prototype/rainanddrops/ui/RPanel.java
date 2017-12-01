package com.snapgames.gdj.prototype.rainanddrops.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import com.snapgames.gdj.prototype.rainanddrops.entity.Drop;
import com.snapgames.gdj.prototype.rainanddrops.entity.Rain;

public class RPanel extends JPanel {
	/**
	 * internal default SerialUID for serialization mechanism.
	 */
	private static final long serialVersionUID = -3322276669460985202L;

	// *********SETTINGS****************************
	public float mWind = (float) (Math.random() * -1.0f) + 2.0f;
	public float mGravity = 9.8f;
	public double mRainChance = 0.99; // from 0 to 1

	public int mRepaintTimeMS = 1000 / 60;
	public float mRainWidth = 1;
	public double mDdropInitialVelocity = 16;
	public double mDropDiam = 2;
	public Color mColor = new Color(129, 129, 129);
	// *********************************************

	private ArrayList<Rain> rainV;
	private ArrayList<Drop> dropV;
	private UpdateThread mUpdateThread;

	public RPanel() {
		rainV = new ArrayList<>();
		dropV = new ArrayList<>();

		mUpdateThread = new UpdateThread();
		mUpdateThread.start();
	}

	public void stop() {
		mUpdateThread.stopped = true;
	}

	public int getHeight() {
		return this.getSize().height;
	}

	public int getWidth() {
		return this.getSize().width;
	}

	private class UpdateThread extends Thread {
		public volatile boolean stopped = false;

		@Override
		public void run() {
			while (!stopped) {
				RPanel.this.repaint();
				try {
					Thread.sleep(mRepaintTimeMS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		g2.fillRect(0, 0, this.getWidth(), this.getHeight());

		g2.setStroke(new BasicStroke(mRainWidth));
		g2.setColor(mColor);

		// DRAW DROPS
		Iterator<Drop> iterator2 = dropV.iterator();
		while (iterator2.hasNext()) {
			Drop drop = iterator2.next();
			drop.update();
			drop.draw(g2);

			if (drop.y >= getHeight()) {
				iterator2.remove();
			}
		}

		// DRAW RAIN
		Iterator<Rain> iterator = rainV.iterator();
		while (iterator.hasNext()) {
			Rain rain = iterator.next();
			rain.update();
			rain.draw(g2);

			if (rain.y >= getHeight()) {
				// create new drops (2-8)
				long dropCount = 1 + Math.round(Math.random() * 4);
				for (int i = 0; i < dropCount; i++) {
					dropV.add(new Drop(this, rain.x, getHeight()));
				}
				iterator.remove();

			}
		}

		// CREATE NEW RAIN
		if (Math.random() < mRainChance) {
			rainV.add(new Rain(this));
		}
	}
}