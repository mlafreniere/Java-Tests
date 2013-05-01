package com.me.factories;

import com.me.context.Context;
import com.me.factories.types.FrameType;
import com.me.factories.types.ObjectType;
import com.me.frames.IFrame;
import com.me.frames.swing.JConnectionFrame;
import com.me.frames.swing.JLocaleSettingFrame;
import com.me.frames.swing.JMainFrame;

public class SwingFactory implements IFactory<IFrame>
{
	// --------------------------------------------------
	// Constants
	// --------------------------------------------------

	// --------------------------------------------------
	// Private Members
	// --------------------------------------------------

	// --------------------------------------------------
	// Constructors
	// --------------------------------------------------

	// --------------------------------------------------
	// Overridden Methods
	// --------------------------------------------------
	@Override
	public IFrame create(ObjectType objectType)
	{
		if (objectType instanceof FrameType)
		{
			return create((FrameType) objectType);
		}

		Context.getLog().warning("SwingBuilder.build(ObjectType). Wrong type." + objectType.getClass().getName());

		return null;
	}

	public IFrame create(FrameType frameType)
	{
		IFrame frame;

		switch (frameType)
		{
			case ConnectionFrame:
				frame = new JConnectionFrame();
				break;
			case MainFrame:
				frame = new JMainFrame();
				break;
			case LocaleSettingFrame:
				frame = new JLocaleSettingFrame();
				break;
			default:
				Context.getLog().warning("SwingBuilder.build(FrameType). Missing FrameType in Builder." + frameType);
				frame = null;
		}

		return frame;
	}

	// --------------------------------------------------
	// Public Methods
	// --------------------------------------------------

	// --------------------------------------------------
	// Private Methods
	// --------------------------------------------------
}
