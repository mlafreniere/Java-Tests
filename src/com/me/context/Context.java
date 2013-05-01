package com.me.context;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.Action;

import com.me.controllers.IController;
import com.me.factories.ActionFactory;
import com.me.factories.ControllerFactory;
import com.me.factories.IFactory;
import com.me.factories.ManagerFactory;
import com.me.factories.SwingFactory;
import com.me.factories.types.FrameType;
import com.me.factories.types.ManagerType;
import com.me.frames.IFrame;
import com.me.logs.ConsoleLog;
import com.me.logs.ILog;
import com.me.managers.IManager;
import com.me.utils.Frames;

public class Context
{
	// --------------------------------------------------
	// Constants
	// --------------------------------------------------
	private static Context m_instance;

	// --------------------------------------------------
	// Private Members
	// --------------------------------------------------
	private Map<Class<?>, IFactory<?>> m_factories;

	private IManager[] m_managers;

	private static ILog m_log;

	// --------------------------------------------------
	// Constructors
	// --------------------------------------------------
	private Context()
	{

	}

	// --------------------------------------------------
	// Overloaded Methods
	// --------------------------------------------------

	// --------------------------------------------------
	// Public Methods
	// --------------------------------------------------
	@SuppressWarnings({ "unchecked" })
	public <T extends IFactory<T2>, T2> T getFactory(Class<T2> productType)
	{
		return (T) m_factories.get(productType);
	}

	public static Context get()
	{
		if (m_instance == null)
		{
			m_instance = new Context();
			m_instance.initialize();
		}

		return m_instance;
	}

	public static ILog getLog()
	{
		if (m_log == null)
		{
			m_log = new ConsoleLog();
		}

		return m_log;
	}

	@SuppressWarnings("unchecked")
	public <T extends IManager> T getManager(Class<T> managerClass)
	{
		for (IManager manager : m_managers)
		{
			if (managerClass.isInstance(manager))
			{
				return (T) manager;
			}
		}

		return null;
	}

	public void start()
	{
		getLog().information("App.start()");

		Frames.open(FrameType.MainFrame);
	}

	public void stop()
	{
		getLog().information("App.stop()");

		for (IManager manager : m_managers)
		{
			manager.dispose();
		}

		System.exit(0);
	}

	// --------------------------------------------------
	// Private Methods
	// --------------------------------------------------
	private void createFactories()
	{
		m_factories = new Hashtable<Class<?>, IFactory<?>>(3);

		m_factories.put(IManager.class, new ManagerFactory());
		m_factories.put(IFrame.class, new SwingFactory());
		m_factories.put(Action.class, new ActionFactory());
		m_factories.put(IController.class, new ControllerFactory());
	}

	private void createManagers()
	{
		IFactory<IManager> factory = getFactory(IManager.class);

		m_managers = new IManager[ManagerType.values().length];

		int index = 0;

		for (ManagerType type : ManagerType.values())
		{
			m_managers[index++] = factory.create(type);
		}

		Arrays.sort(m_managers, ManagerType.comparator());
	}

	private void initialize()
	{
		createFactories();
		createManagers();

		for (IManager manager : m_managers)
		{
			manager.initialize();
		}
	}

	// --------------------------------------------------
	// Internal Classes
	// --------------------------------------------------
}
