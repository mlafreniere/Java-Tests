package com.me.managers;

import javax.swing.UIManager;

import com.me.context.Context;
import com.me.factories.types.ManagerType;

public class StyleManager implements IManager
{
	// --------------------------------------------------
	// Constants
	// --------------------------------------------------
	public static final String METAL = "javax.swing.plaf.metal.MetalLookAndFeel";
	public static final String MOTIF = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
	public static final String NIMBUS = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
	public static final String WINDOWS = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	public static final String WINDOWS_CLASSIC = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";

	// --------------------------------------------------
	// Private Members
	// --------------------------------------------------

	// --------------------------------------------------
	// Constructors
	// --------------------------------------------------
	public StyleManager()
	{

	}

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
		return ManagerType.StyleManager;
	}

	@Override
	public void initialize()
	{
		Context.getLog().information(getClass().getSimpleName() + ".initialize()");

		setStyle(NIMBUS);
	}

	// --------------------------------------------------
	// Public Methods
	// --------------------------------------------------
	public void setStyle(String styleName)
	{
		try
		{
			UIManager.setLookAndFeel(styleName);
		}
		catch (Exception e)
		{
			try
			{
				UIManager.setLookAndFeel(NIMBUS);
			}
			catch (Exception e1)
			{

			}
		}
	}

	// --------------------------------------------------
	// Private Methods
	// --------------------------------------------------
}
