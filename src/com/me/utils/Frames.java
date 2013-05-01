package com.me.utils;

import com.me.context.Context;
import com.me.factories.IFactory;
import com.me.factories.types.FrameType;
import com.me.frames.IFrame;
import com.me.managers.FrameManager;

public class Frames
{
	// --------------------------------------------------
	// Constants
	// --------------------------------------------------

	// --------------------------------------------------
	// Private Members
	// --------------------------------------------------
	private static FrameManager m_fManager;

	private static IFactory<IFrame> m_factory;

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
	public static IFactory<IFrame> factory()
	{
		return m_factory;
	}

	public static void open(FrameType frameType)
	{
		m_fManager.open(frameType);
	}

	// --------------------------------------------------
	// Private Methods
	// --------------------------------------------------
	private static void initialize()
	{
		m_fManager = Context.get().getManager(FrameManager.class);

		m_factory = Context.get().getFactory(IFrame.class);
	}
}
