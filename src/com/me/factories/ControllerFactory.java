package com.me.factories;

import com.me.controllers.ConnectionController;
import com.me.controllers.IController;
import com.me.factories.types.FrameType;
import com.me.factories.types.ObjectType;

public class ControllerFactory implements IFactory<IController>
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

	// --------------------------------------------------
	// Public Methods
	// --------------------------------------------------
	@Override
	public IController create(ObjectType objectType)
	{
		if (objectType instanceof FrameType)
		{
			return create((FrameType) objectType);
		}

		return null;
	}

	public IController create(FrameType frameType)
	{
		IController controller;

		switch (frameType)
		{
			case ConnectionFrame:
				controller = new ConnectionController();
				break;
			default:
				controller = null;
				break;
		}

		return controller;
	}

	// --------------------------------------------------
	// Private Methods
	// --------------------------------------------------
}
