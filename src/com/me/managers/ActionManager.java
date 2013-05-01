package com.me.managers;

import java.util.Hashtable;

import javax.swing.Action;

import com.me.context.Context;
import com.me.factories.IFactory;
import com.me.factories.types.ActionType;
import com.me.factories.types.ManagerType;
import com.me.utils.Actions;

public class ActionManager implements IManager
{
	// --------------------------------------------------
	// Constants
	// --------------------------------------------------

	// --------------------------------------------------
	// Private Members
	// --------------------------------------------------
	private Hashtable<ActionType, Action> m_actions;

	private boolean m_initialized;

	// --------------------------------------------------
	// Constructors
	// --------------------------------------------------
	public ActionManager()
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
	public void initialize()
	{
		if (!m_initialized)
		{
			Context.getLog().information(getClass().getSimpleName() + ".initialize()");

			m_actions = new Hashtable<ActionType, Action>();

			IFactory<Action> factory = Actions.factory();

			for (ActionType type : ActionType.values())
			{
				registerAction(type, factory.create(type));
			}

			m_initialized = true;
		}
		else
		{
			Context.getLog().warning(getClass().getSimpleName() + ".initialize(). Already initialized.");
		}
	}

	@Override
	public ManagerType getType()
	{
		return ManagerType.ActionManager;
	}

	// --------------------------------------------------
	// Public Methods
	// --------------------------------------------------
	public Action getAction(ActionType commandType)
	{
		return m_actions.get(commandType);
	}

	// --------------------------------------------------
	// Private Methods
	// --------------------------------------------------
	private void registerAction(ActionType actionType, Action action)
	{
		m_actions.put(actionType, action);
	}
}
