package com.me.utils;

import java.awt.TextComponent;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.me.context.Context;
import com.me.frames.IFrame;
import com.me.managers.ResourceManager;

public final class Resources
{
	// --------------------------------------------------
	// Constants
	// --------------------------------------------------

	// --------------------------------------------------
	// Private Members
	// --------------------------------------------------
	private static ResourceManager m_rManager;

	// --------------------------------------------------
	// Constructors
	// --------------------------------------------------
	static
	{
		initialize();
	}

	// --------------------------------------------------
	// Overridden Methods
	// --------------------------------------------------

	// --------------------------------------------------
	// Public Methods
	// --------------------------------------------------
	public static void setString(TextComponent textComponent, String strId)
	{
		textComponent.setText(m_rManager.getString(strId));
	}

	public static void setString(JLabel label, String strId)
	{
		label.setText(m_rManager.getString(strId));
	}

	public static void setString(JButton button, String strId)
	{
		button.setText(m_rManager.getString(strId));
	}

	public static void setString(IFrame frame, String strId)
	{
		frame.setTitle(m_rManager.getString(strId));
	}
	
	// --------------------------------------------------
	// Private Methods
	// --------------------------------------------------
	private static void initialize()
	{
		m_rManager = Context.get().getManager(ResourceManager.class);
	}
}
