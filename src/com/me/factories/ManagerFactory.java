package com.me.factories;

import com.me.context.Context;
import com.me.factories.types.ManagerType;
import com.me.factories.types.ObjectType;
import com.me.managers.ActionManager;
import com.me.managers.FrameManager;
import com.me.managers.IManager;
import com.me.managers.ResourceManager;
import com.me.managers.SettingManager;
import com.me.managers.StyleManager;

public class ManagerFactory implements IFactory<IManager>
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
	public IManager create(ObjectType objectType)
	{
		if (objectType instanceof ManagerType)
		{
			return create((ManagerType) objectType);
		}

		Context.getLog().warning(getClass().getSimpleName() + ".build(ObjectType). Wrong type." + objectType.getClass().getName());

		return null;
	}

	public IManager create(ManagerType managerType)
	{
		IManager manager;

		switch (managerType)
		{
			case ActionManager:
				manager = new ActionManager();
				break;
			case FrameManager:
				manager = new FrameManager();
				break;
			case ResourceManager:
				manager = new ResourceManager();
				break;
			case SettingManager:
				manager = new SettingManager();
				break;
			case StyleManager:
				manager = new StyleManager();
				break;
			default:
				manager = null;
				break;
		}

		return manager;
	}
	// --------------------------------------------------
	// Public Methods
	// --------------------------------------------------

	// --------------------------------------------------
	// Private Methods
	// --------------------------------------------------

}
