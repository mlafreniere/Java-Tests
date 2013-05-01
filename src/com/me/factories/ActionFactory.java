package com.me.factories;

import javax.swing.Action;

import com.me.actions.CopyAction;
import com.me.actions.CutAction;
import com.me.actions.OpenLocaleSettingAction;
import com.me.actions.PasteAction;
import com.me.context.Context;
import com.me.factories.types.ActionType;
import com.me.factories.types.ObjectType;

public class ActionFactory implements IFactory<Action>
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
	public Action create(ObjectType objectType)
	{
		if (objectType instanceof ActionType)
		{
			return create((ActionType) objectType);
		}

		Context.getLog().warning("ActionBuilder.build(ObjectType). Wrong type." + objectType.getClass().getName());

		return null;
	}

	public Action create(ActionType actionType)
	{
		Action action;

		switch (actionType)
		{
			case CopyAction:
				action = new CopyAction();
				break;
			case CutAction:
				action = new CutAction();
				break;
			case OpenLocaleSettingAction:
				action = new OpenLocaleSettingAction();
				break;
			case PasteAction:
				action = new PasteAction();
				break;
			default:
				Context.getLog().warning("ActionBuilder.build(CommandType). Missing ActionType in Builder. " + actionType);
				action = null;
		}

		return action;
	}

	// --------------------------------------------------
	// Public Methods
	// --------------------------------------------------

	// --------------------------------------------------
	// Private Methods
	// --------------------------------------------------
}
