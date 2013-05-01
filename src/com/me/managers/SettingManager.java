package com.me.managers;

import java.util.ArrayList;
import java.util.List;

import com.me.context.Context;
import com.me.factories.types.ManagerType;
import com.me.settings.ISetting;
import com.me.settings.frames.FrameSetting;
import com.me.settings.locales.LocaleSetting;


public class SettingManager implements IManager
{
	// --------------------------------------------------
	// Constants
	// --------------------------------------------------

	// --------------------------------------------------
	// Private Members
	// --------------------------------------------------
	private boolean m_initialized;

	private List<ISetting> m_settings;

	// --------------------------------------------------
	// Constructors
	// --------------------------------------------------
	public SettingManager()
	{

	}

	// --------------------------------------------------
	// Overridden Methods
	// --------------------------------------------------
	@Override
	public void dispose()
	{
		for (ISetting setting : m_settings)
		{
			setting.save();
		}
	}

	@Override
	public ManagerType getType()
	{
		return ManagerType.SettingManager;
	}

	@Override
	public void initialize()
	{
		if (!m_initialized)
		{
			Context.getLog().information(getClass().getSimpleName() + ".initialize()");

			m_settings = new ArrayList<ISetting>();

			m_settings.add(new LocaleSetting());
			m_settings.add(new FrameSetting());

			for (ISetting setting : m_settings)
			{
				setting.load();
			}

			m_initialized = true;
		}
		else
		{
			Context.getLog().warning(getClass().getSimpleName() + ".initialize(). Already initialized.");
		}
	}

	// --------------------------------------------------
	// Public Methods
	// --------------------------------------------------
	@SuppressWarnings("unchecked")
	public <T extends ISetting> T getSetting(Class<T> settingClass)
	{
		for (ISetting setting : m_settings)
		{
			if (settingClass.isInstance(setting))
			{
				return (T) setting;
			}
		}

		return null;
	}
	// --------------------------------------------------
	// Private Methods
	// --------------------------------------------------
}
