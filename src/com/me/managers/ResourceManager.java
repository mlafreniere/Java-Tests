package com.me.managers;

import java.util.ResourceBundle;

import com.me.context.Context;
import com.me.factories.types.ManagerType;

public class ResourceManager implements IManager
{
	// --------------------------------------------------
	// Constants
	// --------------------------------------------------

	// --------------------------------------------------
	// Private Members
	// --------------------------------------------------
	private boolean m_initialized;
	private ResourceBundle m_strings;

	// --------------------------------------------------
	// Getters
	// --------------------------------------------------

	// --------------------------------------------------
	// Setters
	// --------------------------------------------------

	// --------------------------------------------------
	// Constructors
	// --------------------------------------------------

	// --------------------------------------------------
	// Overridden Methods
	// --------------------------------------------------
	@Override
	public void dispose()
	{

	}

	@Override
	public ManagerType getType()
	{
		return ManagerType.ResourceManager;
	}

	@Override
	public void initialize()
	{
		if (!m_initialized)
		{
			Context.getLog().information(getClass().getSimpleName() + ".initialize()");

			m_strings = ResourceBundle.getBundle("com/me/strings/strings");

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
	public String getString(String key)
	{
		key = key.toLowerCase();

		if (m_strings.containsKey(key))
		{
			return m_strings.getString(key);
		}

		Context.getLog().warning(getClass().getSimpleName() + ".getString(String). Couldn't find key " + key);

		return key;
	}
	// --------------------------------------------------
	// Private Methods
	// --------------------------------------------------
}
