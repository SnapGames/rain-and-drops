package com.snapgames.gdj.prototype.rainanddrops.entity;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.Random;

import com.snapgames.gdj.prototype.rainanddrops.ui.RPanel;

public class Rain {
	public float x;
	public float y;
	public float prevX;
	public float prevY;
	public RPanel panel;

	public Rain(RPanel panel) {
		this.panel = panel;
		Random r = new Random();
		x = r.nextInt(panel.getWidth());
		y = 0;
	}

	public void update() {
		prevX = x;
		prevY = y;

		x += panel.mWind;
		y += panel.mGravity;
	}

	public void draw(Graphics2D g2) {
		Line2D line = new Line2D.Double(x, y, prevX, prevY);
		g2.draw(line);
	}
}