package com.me.ui.controls;

import java.lang.annotation.Annotation;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.Action;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.me.annotations.MenuPath;
import com.me.factories.IFactory;
import com.me.factories.types.ActionType;
import com.me.utils.Actions;

public class XMenuBar extends JMenuBar
{
	// --------------------------------------------------
	// Constants
	// --------------------------------------------------
	private static final long serialVersionUID = 1L;

	// --------------------------------------------------
	// Private Members
	// --------------------------------------------------
	private Map<String, JMenu> menus;

	// --------------------------------------------------
	// Constructors
	// --------------------------------------------------
	public XMenuBar()
	{
		menus = new Hashtable<String, JMenu>();

		initialize();
	}
	// --------------------------------------------------
	// Overridden Methods
	// --------------------------------------------------

	// --------------------------------------------------
	// Public Methods
	// --------------------------------------------------

	// --------------------------------------------------
	// Private Methods
	// --------------------------------------------------
	private void initialize()
	{
		IFactory<Action> factory = Actions.factory();

		for (ActionType actionType : ActionType.values())
		{
			for (Annotation annotation : actionType.getClass().getAnnotations())
			{
				if (annotation instanceof MenuPath)
				{
					String menuPath = ((MenuPath) annotation).Path();
					JMenu menu = menus.get(menuPath);

					if (menu == null)
					{

					}

					menu.add(new JMenuItem(factory.create(actionType)));
				}
			}
		}
	}
}
