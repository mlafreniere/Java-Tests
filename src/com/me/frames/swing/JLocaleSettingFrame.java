package com.me.frames.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.me.controllers.IController;
import com.me.frames.IFrame;
import com.me.utils.Resources;

public class JLocaleSettingFrame extends JDialog implements IFrame
{
	// --------------------------------------------------
	// Constants
	// --------------------------------------------------
	private static final long serialVersionUID = 1L;

	// --------------------------------------------------
	// String IDs
	// --------------------------------------------------
	private final String ID_LANGUAGE = getClass().getName() + ".label.language";

	private final String ID_OK = getClass().getName() + ".button.ok";
	private final String ID_CANCEL = getClass().getName() + ".button.cancel";

	private final String ID_TITLE = getClass().getName() + ".window.title";

	// --------------------------------------------------
	// Private Members
	// --------------------------------------------------
	private IController m_controller;

	private JLabel m_languageLabel;

	private JComboBox<LocaleComboBoxItem> m_localeComboBox;

	private JPanel m_buttonPanel;

	private JButton m_confimButton;
	private JButton m_cancelButton;

	// --------------------------------------------------
	// Constructors
	// --------------------------------------------------
	public JLocaleSettingFrame()
	{
		initializeComponents();

		fillComboBox();
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

	// --------------------------------------------------
	// Private Methods
	// --------------------------------------------------
	private void fillComboBox()
	{
		Locale[] locales = { Locale.ENGLISH, Locale.FRENCH };

		locales[0] = Locale.ENGLISH;
		locales[1] = Locale.FRENCH;

		for (Locale locale : locales)
		{
			m_localeComboBox.addItem(new LocaleComboBoxItem(locale));
		}
	}

	private void initializeComponents()
	{
		setModal(true);

		Resources.setString(this, ID_TITLE);

		Dimension frameSize = new Dimension(350, 195);
		setSize(frameSize);
		setMinimumSize(frameSize);

		getContentPane().setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 306, 0 };
		gridBagLayout.rowHeights = new int[] { 37, 35, 20, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		m_languageLabel = new JLabel();
		Resources.setString(m_languageLabel, ID_LANGUAGE);
		m_languageLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GridBagConstraints gbc_m_languageLabel = new GridBagConstraints();
		gbc_m_languageLabel.anchor = GridBagConstraints.NORTH;
		gbc_m_languageLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_m_languageLabel.insets = new Insets(10, 20, 5, 0);
		gbc_m_languageLabel.gridx = 0;
		gbc_m_languageLabel.gridy = 0;
		getContentPane().add(m_languageLabel, gbc_m_languageLabel);

		m_localeComboBox = new JComboBox<LocaleComboBoxItem>();
		GridBagConstraints gbc_m_languageComboBox = new GridBagConstraints();
		gbc_m_languageComboBox.insets = new Insets(15, 30, 5, 30);
		gbc_m_languageComboBox.fill = GridBagConstraints.BOTH;
		gbc_m_languageComboBox.gridx = 0;
		gbc_m_languageComboBox.gridy = 1;
		getContentPane().add(m_localeComboBox, gbc_m_languageComboBox);

		m_buttonPanel = new JPanel();
		m_buttonPanel.setBackground(Color.WHITE);
		GridBagConstraints gbc_m_buttonPanel = new GridBagConstraints();
		gbc_m_buttonPanel.insets = new Insets(10, 35, 10, 35);
		gbc_m_buttonPanel.fill = GridBagConstraints.BOTH;
		gbc_m_buttonPanel.gridx = 0;
		gbc_m_buttonPanel.gridy = 2;
		getContentPane().add(m_buttonPanel, gbc_m_buttonPanel);
		m_buttonPanel.setLayout(new GridLayout(1, 0, 10, 0));

		m_confimButton = new JButton();
		Resources.setString(m_confimButton, ID_OK);
		m_buttonPanel.add(m_confimButton);

		m_cancelButton = new JButton();
		Resources.setString(m_cancelButton, ID_CANCEL);
		m_buttonPanel.add(m_cancelButton);
	}

	// --------------------------------------------------
	// Internal Classes
	// --------------------------------------------------
	public class LocaleComboBoxItem
	{
		private Locale m_item;

		public LocaleComboBoxItem(Locale locale)
		{
			m_item = locale;
		}

		@Override
		public String toString()
		{
			return m_item.getDisplayName();
		}

		public Locale getLocale()
		{
			return m_item;
		}
	}
}
