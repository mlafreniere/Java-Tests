package com.me.factories.types;

import java.util.Comparator;

import com.me.annotations.Priority;
import com.me.context.Context;
import com.me.managers.IManager;

public enum ManagerType implements ObjectType
{
	ActionManager,

	FrameManager,

	ResourceManager,

	@Priority(Order = 1)
	SettingManager,

	StyleManager;

	public static Comparator<IManager> comparator()
	{
		return new Comparator<IManager>()
		{
			@Override
			public int compare(IManager manager1, IManager manager2)
			{
				int returnValue = 0;

				ManagerType type1 = manager1.getType();
				ManagerType type2 = manager2.getType();

				try
				{
					Priority priority1 = ManagerType.class.getField(type1.name()).getAnnotation(Priority.class);
					Priority priority2 = ManagerType.class.getField(type2.name()).getAnnotation(Priority.class);

					if (priority1 != null && priority2 != null)
					{
						returnValue = priority1.Order() - priority2.Order();
					}
					else if (priority2 != null)
					{
						returnValue = 1;
					}
					else if (priority1 != null)
					{
						returnValue = -1;
					}
				}
				catch (Exception e)
				{
					Context.getLog().error(e.getMessage());
				}

				if (returnValue == 0)
				{
					returnValue = type1.name().compareTo(type2.name());
				}

				return returnValue;
			}
		};
	}
}
