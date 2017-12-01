package com.snapgames.gdj.prototype.rainanddrops.entity;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import com.snapgames.gdj.prototype.rainanddrops.ui.RPanel;

public class Drop {

	public double x0;
	public double y0;
	public double v0; // initial velocity
	public double t; // time
	public double angle;
	public double x;
	public double y;

	RPanel panel;

	public Drop(RPanel panel, double x0, double y0) {
		super();
		this.panel = panel;
		this.x0 = x0;
		this.y0 = y0;

		v0 = panel.mDdropInitialVelocity;
		angle = Math.toRadians(Math.round(Math.random() * 180)); // from 0 - 180 degrees
	}

	public void update() {
		// double g=10;
		t += panel.mRepaintTimeMS / 100f;
		x = x0 + v0 * t * Math.cos(angle);
		y = y0 - (v0 * t * Math.sin(angle) - panel.mGravity * t * t / 2);
	}

	public void draw(Graphics2D g2) {
		Ellipse2D.Double circle = new Ellipse2D.Double(x, y, panel.mDropDiam, panel.mDropDiam);
		g2.fill(circle);
	}
}