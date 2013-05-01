package com.me.frames.swing;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

import com.me.actions.CopyAction;
import com.me.actions.CutAction;
import com.me.actions.OpenLocaleSettingAction;
import com.me.actions.PasteAction;
import com.me.controllers.IController;
import com.me.factories.types.FrameType;
import com.me.frames.IFrame;
import com.me.utils.Frames;
import com.me.utils.Resources;

public class JMainFrame extends JFrame implements IFrame
{
	// --------------------------------------------------
	// Constants
	// --------------------------------------------------
	private static final long serialVersionUID = 1L;

	// --------------------------------------------------
	// String IDs
	// --------------------------------------------------
	private final String ID_TITLE = getClass().getName() + ".window.title";
	// --------------------------------------------------
	// Private Members
	// --------------------------------------------------
	private IController m_controller;

	private JMenuBar menuBar;
	private JMenu m_menuSettings;
	private JMenu m_menuEdit;

	// --------------------------------------------------
	// Constructors
	// --------------------------------------------------
	public JMainFrame()
	{
		initializeComponents();

		Frames.open(FrameType.ConnectionFrame);
	}

	// --------------------------------------------------
	// Overridden Methods
	// --------------------------------------------------
	@Override
	public void setVisible(boolean visible)
	{
		setLocationRelativeTo(null);

		super.setVisible(visible);
	}

	@Override
	public void setController(IController controller)
	{
		if (controller != null)
		{
			controller.bind(this);
		}

		if (m_controller != null)
		{
			m_controller.unbind();
		}

		m_controller = controller;
	}

	@Override
	public IController getController()
	{
		return m_controller;
	}
	// --------------------------------------------------
	// Public Methods
	// --------------------------------------------------

	// --------------------------------------------------
	// Private Methods
	// --------------------------------------------------
	private void initializeComponents()
	{
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		m_menuSettings = new JMenu("Settings");
		menuBar.add(m_menuSettings);

		Action action = new OpenLocaleSettingAction();
		action.setEnabled(true);
		m_menuSettings.add(action);

		m_menuEdit = new JMenu("Edit");
		menuBar.add(m_menuEdit);
		action = new CopyAction();
		action.setEnabled(true);
		m_menuEdit.add(action);

		action = new CutAction();
		action.setEnabled(true);
		m_menuEdit.add(action);

		action = new PasteAction();
		action.setEnabled(true);
		m_menuEdit.add(action);

		getContentPane().setBackground(Color.WHITE);
		setSize(new Dimension(1200, 800));

		Resources.setString(this, ID_TITLE);
	}
}
