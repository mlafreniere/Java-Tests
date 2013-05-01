package com.me.managers;

import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import com.me.context.Context;
import com.me.controllers.IController;
import com.me.factories.types.FrameType;
import com.me.factories.types.ManagerType;
import com.me.frames.IFrame;
import com.me.settings.ISetting;
import com.me.utils.Controllers;
import com.me.utils.Frames;
import com.me.utils.Settings;

public class FrameManager implements IManager
{
	// --------------------------------------------------
	// Constants
	// --------------------------------------------------

	// --------------------------------------------------
	// Private Members
	// --------------------------------------------------
	List<IFrame> m_frames;

	private boolean m_initialized;

	private WindowListener m_windowListener;

	// --------------------------------------------------
	// Constructors
	// --------------------------------------------------
	public FrameManager()
	{

	}

	// --------------------------------------------------
	// Overridden Methods
	// --------------------------------------------------
	@Override
	public void dispose()
	{
		for (IFrame frame : m_frames)
		{
			saveFrame(frame, true);
		}
	}

	@Override
	public ManagerType getType()
	{
		return ManagerType.FrameManager;
	}

	@Override
	public void initialize()
	{
		if (!m_initialized)
		{
			Context.getLog().information(getClass().getSimpleName() + ".initialize()");

			m_frames = new ArrayList<IFrame>();

			m_windowListener = new FrameListener();

			m_initialized = true;
		}
		else
		{
			Context.getLog().warning(getClass().getSimpleName() + ".initialize(). Already initialized.");
		}
	}

	// --------------------------------------------------
	// Public Methods
	// --------------------------------------------------
	public void open(final FrameType type)
	{
		Context.getLog().information(getClass().getSimpleName() + ".open(FrameType)");

		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				IFrame newFrame = Frames.factory().create(type);

				if (newFrame != null)
				{
					IController controller = Controllers.factory().create(type);
					newFrame.setController(controller);

					initFrame(newFrame);
				}
			}
		});
	}

	private void initFrame(IFrame newFrame)
	{
		newFrame.addWindowListener(m_windowListener);
		newFrame.setDefaultCloseOperation(IFrame.DISPOSE_ON_CLOSE);

		Point location;

		location = Settings.getFrameLocation(newFrame.getClass().getName());

		if (location.x == Integer.MIN_VALUE || location.y == Integer.MIN_VALUE)
		{
			newFrame.setLocationRelativeTo(null);
		}
		else
		{
			newFrame.setLocation(location);
		}

		newFrame.setVisible(true);

		m_frames.add(newFrame);
	}

	// --------------------------------------------------
	// Private Methods
	// --------------------------------------------------
	private void saveFrame(IFrame frame, boolean forceSave)
	{
		ISetting setting = Settings.setFrameLocation(frame.getClass().getName(), frame.getLocation());

		if (forceSave)
		{
			setting.save();
		}
	}

	// --------------------------------------------------
	// Internal Classes
	// --------------------------------------------------
	private class FrameListener implements WindowListener
	{
		@Override
		public void windowActivated(WindowEvent args)
		{

		}

		@Override
		public void windowClosed(WindowEvent args)
		{
			if (m_frames.contains(args.getWindow()))
			{
				IFrame closedFrame = (IFrame) args.getWindow();

				closedFrame.removeWindowListener(this);
				closedFrame.setController(null);

				m_frames.remove(closedFrame);
				saveFrame(closedFrame, false);
			}

			if (m_frames.isEmpty())
			{
				Context.get().stop();
			}
		}

		@Override
		public void windowClosing(WindowEvent args)
		{
		}

		@Override
		public void windowDeactivated(WindowEvent args)
		{
		}

		@Override
		public void windowDeiconified(WindowEvent args)
		{
		}

		@Override
		public void windowIconified(WindowEvent args)
		{
		}

		@Override
		public void windowOpened(WindowEvent args)
		{
		}
	}
}
