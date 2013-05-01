package com.me.frames.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.me.controllers.IController;
import com.me.frames.IFrame;
import com.me.utils.Resources;

public class JConnectionFrame extends JDialog implements IFrame
{
	// --------------------------------------------------
	// Constants
	// --------------------------------------------------
	private static final long serialVersionUID = 1L;

	// --------------------------------------------------
	// String IDs
	// --------------------------------------------------
	private final String ID_WELCOME = getClass().getName() + ".label.welcome";
	private final String ID_USERNAME = getClass().getName() + ".label.username";
	private final String ID_PASSWORD = getClass().getName() + ".label.password";

	private final String ID_CONNECT = getClass().getName() + ".button.connect";
	private final String ID_CANCEL = getClass().getName() + ".button.cancel";

	private final String ID_TITLE = getClass().getName() + ".window.title";

	// --------------------------------------------------
	// Private Members
	// --------------------------------------------------
	private IController m_controller;

	private JLabel m_welcomeLabel;
	private JLabel m_usernameLabel;
	private JLabel m_passwordLabel;

	private JTextField m_usernameTextField;

	private JPasswordField m_passwordField;

	private JPanel m_buttonsPanel;

	private JButton m_connectButton;
	private JButton m_cancelButton;

	// --------------------------------------------------
	// Constructors
	// --------------------------------------------------
	public JConnectionFrame()
	{
		initializeComponents();
	}

	// --------------------------------------------------
	// Overridden Methods
	// --------------------------------------------------
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
	public JButton getCancelButton()
	{
		return m_cancelButton;
	}

	public JButton getConnectButton()
	{
		return m_connectButton;
	}

	public JTextField getUsernameField()
	{
		return m_usernameTextField;
	}

	public JPasswordField getPasswordField()
	{
		return m_passwordField;
	}
	// --------------------------------------------------
	// Private Methods
	// --------------------------------------------------
	private void initializeComponents()
	{
		Dimension frameSize = new Dimension(400, 325);
		setSize(frameSize);
		setMinimumSize(frameSize);

		setModal(true);

		setResizable(false);
		setFont(new Font("Tahoma", Font.PLAIN, 12));
		setBackground(Color.WHITE);

		Resources.setString(this, ID_TITLE);

		getContentPane().setBackground(Color.WHITE);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 282, 0 };
		gridBagLayout.rowHeights = new int[] { 37, 0, 40, 0, 40, 20, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		m_welcomeLabel = new JLabel();
		Resources.setString(m_welcomeLabel, ID_WELCOME);
		m_welcomeLabel.setBackground(Color.WHITE);
		m_welcomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		m_welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		GridBagConstraints gbc_m_welcomeLabel = new GridBagConstraints();
		gbc_m_welcomeLabel.insets = new Insets(10, 30, 5, 0);
		gbc_m_welcomeLabel.anchor = GridBagConstraints.NORTH;
		gbc_m_welcomeLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_m_welcomeLabel.gridx = 0;
		gbc_m_welcomeLabel.gridy = 0;
		getContentPane().add(m_welcomeLabel, gbc_m_welcomeLabel);

		m_usernameLabel = new JLabel();
		Resources.setString(m_usernameLabel, ID_USERNAME);
		m_usernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_m_usernameLabel = new GridBagConstraints();
		gbc_m_usernameLabel.insets = new Insets(15, 30, 5, 0);
		gbc_m_usernameLabel.anchor = GridBagConstraints.WEST;
		gbc_m_usernameLabel.gridx = 0;
		gbc_m_usernameLabel.gridy = 1;
		getContentPane().add(m_usernameLabel, gbc_m_usernameLabel);

		m_usernameTextField = new JTextField();
		m_usernameTextField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_m_usernameTextField = new GridBagConstraints();
		gbc_m_usernameTextField.insets = new Insets(0, 30, 5, 30);
		gbc_m_usernameTextField.fill = GridBagConstraints.BOTH;
		gbc_m_usernameTextField.gridx = 0;
		gbc_m_usernameTextField.gridy = 2;
		getContentPane().add(m_usernameTextField, gbc_m_usernameTextField);

		m_passwordLabel = new JLabel();
		Resources.setString(m_passwordLabel, ID_PASSWORD);
		m_passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		GridBagConstraints gbc_m_passwordLabel = new GridBagConstraints();
		gbc_m_passwordLabel.insets = new Insets(10, 30, 5, 0);
		gbc_m_passwordLabel.anchor = GridBagConstraints.WEST;
		gbc_m_passwordLabel.gridx = 0;
		gbc_m_passwordLabel.gridy = 3;
		getContentPane().add(m_passwordLabel, gbc_m_passwordLabel);

		m_passwordField = new JPasswordField();
		m_passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.insets = new Insets(0, 30, 5, 30);
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.gridx = 0;
		gbc_passwordField.gridy = 4;
		getContentPane().add(m_passwordField, gbc_passwordField);

		m_buttonsPanel = new JPanel();
		m_buttonsPanel.setBackground(Color.WHITE);
		GridBagConstraints gbc_m_buttonsPanel = new GridBagConstraints();
		gbc_m_buttonsPanel.insets = new Insets(10, 50, 10, 50);
		gbc_m_buttonsPanel.anchor = GridBagConstraints.NORTH;
		gbc_m_buttonsPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_m_buttonsPanel.gridx = 0;
		gbc_m_buttonsPanel.gridy = 5;
		getContentPane().add(m_buttonsPanel, gbc_m_buttonsPanel);
		m_buttonsPanel.setLayout(new GridLayout(0, 2, 10, 0));

		m_connectButton = new JButton();
		Resources.setString(m_connectButton, ID_CONNECT);
		m_buttonsPanel.add(m_connectButton);

		m_cancelButton = new JButton();
		Resources.setString(m_cancelButton, ID_CANCEL);
		m_buttonsPanel.add(m_cancelButton);
	}
}