package com.me.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.me.frames.IFrame;
import com.me.frames.swing.JConnectionFrame;

public class ConnectionController implements IController
{
	// --------------------------------------------------
	// Constants
	// --------------------------------------------------

	// --------------------------------------------------
	// Private Members
	// --------------------------------------------------
	private JConnectionFrame m_frame;

	private ConnectButtonListener m_connectButtonListener;
	private CancelButtonListener m_cancelButtonListener;

	// --------------------------------------------------
	// Constructors
	// --------------------------------------------------
	public ConnectionController()
	{
		m_connectButtonListener = new ConnectButtonListener();
		m_cancelButtonListener = new CancelButtonListener();
	}

	// --------------------------------------------------
	// Overridden Methods
	// --------------------------------------------------
	@Override
	public void bind(IFrame frame)
	{
		if (frame instanceof JConnectionFrame)
		{
			unbind();

			m_frame = (JConnectionFrame) frame;

			m_frame.getConnectButton().addActionListener(m_connectButtonListener);
			m_frame.getCancelButton().addActionListener(m_cancelButtonListener);
		}

	}

	@Override
	public void unbind()
	{
		if (m_frame != null)
		{
			m_frame.getConnectButton().removeActionListener(m_connectButtonListener);
			m_frame.getCancelButton().removeActionListener(m_cancelButtonListener);
		}
	}

	// --------------------------------------------------
	// Public Methods
	// --------------------------------------------------

	// --------------------------------------------------
	// Private Methods
	// --------------------------------------------------

	// --------------------------------------------------
	// Nested Classes
	// --------------------------------------------------
	private class ConnectButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			m_frame.dispose();
		}
	}

	private class CancelButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			m_frame.getUsernameField().setText("");
			m_frame.getPasswordField().setText("");
		}
	}
}
