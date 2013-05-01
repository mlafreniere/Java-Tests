package com.me.utils;

import javax.swing.Action;

import com.me.context.Context;
import com.me.factories.IFactory;

public class Actions
{
	// --------------------------------------------------
	// Constants
	// --------------------------------------------------

	// --------------------------------------------------
	// Private Members
	// --------------------------------------------------
	private static IFactory<Action> m_factory;

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
	public static IFactory<Action> factory()
	{
		return m_factory;
	}

	// --------------------------------------------------
	// Private Methods
	// --------------------------------------------------
	private static void initialize()
	{
		m_factory = Context.get().getFactory(Action.class);
	}
}
