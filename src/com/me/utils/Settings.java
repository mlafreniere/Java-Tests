package com.me.utils;

import java.awt.Point;

import com.me.context.Context;
import com.me.managers.SettingManager;
import com.me.settings.ISetting;
import com.me.settings.frames.FrameSetting;

public class Settings
{
	// --------------------------------------------------
	// Constants
	// --------------------------------------------------

	// --------------------------------------------------
	// Private Members
	// --------------------------------------------------
	private static SettingManager m_sManager;

	private static FrameSetting m_fSetting;

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
	public static Point getFrameLocation(String frameName)
	{
		Point location = new Point();
		location.x = m_fSetting.getX(frameName, Integer.MIN_VALUE);
		location.y = m_fSetting.getY(frameName, Integer.MIN_VALUE);

		return location;
	}

	public static ISetting setFrameLocation(String frameName, Point location)
	{
		m_fSetting.setLocation(frameName, location);
		return m_fSetting;
	}

	// --------------------------------------------------
	// Private Methods
	// --------------------------------------------------
	private static void initialize()
	{
		if (m_sManager == null)
		{
			m_sManager = Context.get().getManager(SettingManager.class);

			m_fSetting = m_sManager.getSetting(FrameSetting.class);
		}
	}
}
