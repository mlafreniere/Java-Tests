package com.me.utils;

import com.me.context.Context;
import com.me.controllers.IController;
import com.me.factories.ControllerFactory;
import com.me.factories.IFactory;

public class Controllers
{
	// --------------------------------------------------
	// Constants
	// --------------------------------------------------

	// --------------------------------------------------
	// Private Members
	// --------------------------------------------------
	private static ControllerFactory m_factory;

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
	public static IFactory<IController> factory()
	{
		return m_factory;
	}

	// --------------------------------------------------
	// Private Methods
	// --------------------------------------------------
	private static void initialize()
	{
		m_factory = Context.get().getFactory(IController.class);
	}
}
