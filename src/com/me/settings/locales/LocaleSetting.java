package com.me.settings.locales;

import java.util.Locale;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import com.me.context.Context;
import com.me.settings.ISetting;

public class LocaleSetting implements ISetting
{
	// --------------------------------------------------
	// Constants
	// --------------------------------------------------
	private String ID_LOCALE = getClass().getName() + ".locale";

	// --------------------------------------------------
	// Private Members
	// --------------------------------------------------
	private Locale m_currentLocale;

	private Preferences m_prefs;

	// --------------------------------------------------
	// Constructors
	// --------------------------------------------------
	public LocaleSetting()
	{
		m_prefs = Preferences.userNodeForPackage(LocaleSetting.class);
	}

	// --------------------------------------------------
	// Overridden Methods
	// --------------------------------------------------
	@Override
	public void load()
	{
		m_currentLocale = Locale.forLanguageTag(m_prefs.get(ID_LOCALE, Locale.getDefault().toLanguageTag()));
		Locale.setDefault(m_currentLocale);
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
		m_prefs.put(ID_LOCALE, m_currentLocale.toLanguageTag());

		Context.getLog().information(getClass().getSimpleName() + ".save(). " + ID_LOCALE + ": " + m_currentLocale.toLanguageTag());

		Locale.setDefault(m_currentLocale);
	}

	// --------------------------------------------------
	// Public Methods
	// --------------------------------------------------
	public void setLocale(Locale locale)
	{
		m_currentLocale = locale;
	}

	// --------------------------------------------------
	// Private Methods
	// --------------------------------------------------
}
