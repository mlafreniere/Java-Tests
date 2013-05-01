package com.me.frames;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.WindowListener;

import javax.swing.WindowConstants;

import com.me.controllers.IController;

public interface IFrame extends WindowConstants
{
	// --------------------------------------------------
	// Abstract methods
	// --------------------------------------------------
	public void addWindowListener(WindowListener l);

	public Point getLocation();

	public void removeWindowListener(WindowListener l);

	public void setDefaultCloseOperation(int operation);

	public void setLocation(Point p);

	public void setLocation(int x, int y);

	public void setLocationRelativeTo(Component c);

	public void setSize(int width, int heigth);

	public void setSize(Dimension size);

	public void setTitle(String title);

	public void setVisible(boolean visible);

	public <T extends IFrame> void setController(IController controller);

	public IController getController();
}
