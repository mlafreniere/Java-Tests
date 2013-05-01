package com.me.settings.frames;

import java.awt.Point;
import java.util.Hashtable;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import com.me.context.Context;
import com.me.settings.ISetting;

public class FrameSetting implements ISetting
{
	// --------------------------------------------------
	// Constants
	// --------------------------------------------------
	private String ID_LOCATION_X = ".x";
	private String ID_LOCATION_Y = ".y";

	// --------------------------------------------------
	// Private Members
	// --------------------------------------------------
	private Preferences m_prefs;

	private Hashtable<String, Integer> m_settings;

	// --------------------------------------------------
	// Constructors
	// --------------------------------------------------
	public FrameSetting()
	{
		m_prefs = Preferences.userNodeForPackage(FrameSetting.class);

		m_settings = new Hashtable<String, Integer>();
	}

	// --------------------------------------------------
	// Overridden Methods
	// --------------------------------------------------
	@Override
	public void load()
	{
		m_settings.clear();

		try
		{
			for (String key : m_prefs.keys())
			{
				m_settings.put(key, m_prefs.getInt(key, -1));
			}
		}
		catch (BackingStoreException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void reset()
	{
		try
		{
			m_prefs.clear();
		}
		catch (BackingStoreException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void save()
	{
		for (String key : m_settings.keySet())
		{
			int value = m_settings.get(key);

			Context.getLog().information(getClass().getSimpleName() + ".save(). " + key + ": " + value);

			m_prefs.putInt(key, value);
		}
	}

	// --------------------------------------------------
	// Public Methods
	// --------------------------------------------------
	public void setX(String frameName, int value)
	{
		m_settings.put(frameName + ID_LOCATION_X, value);
	}

	public void setY(String frameName, int value)
	{
		m_settings.put(frameName + ID_LOCATION_Y, value);
	}

	public void setLocation(String frameName, int x, int y)
	{
		setX(frameName, x);
		setY(frameName, y);
	}

	public void setLocation(String frameName, Point p)
	{
		setX(frameName, p.x);
		setY(frameName, p.y);
	}

	public int getX(String frameName, int def)
	{
		String key = frameName + ID_LOCATION_X;

		if (m_settings.containsKey(key))
		{
			return m_settings.get(key);
		}

		return def;
	}

	public int getY(String frameName, int def)
	{
		String key = frameName + ID_LOCATION_Y;

		if (m_settings.containsKey(key))
		{
			return m_settings.get(key);
		}

		return def;
	}
	// --------------------------------------------------
	// Private Methods
	// --------------------------------------------------
}
