package com.me.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import com.me.annotations.MenuPath;
import com.me.factories.types.FrameType;
import com.me.utils.Frames;

@MenuPath(Path = "Settings")
public class OpenLocaleSettingAction extends AbstractAction
{
	// --------------------------------------------------
	// Constants
	// --------------------------------------------------
	private static final long serialVersionUID = 1L;

	// --------------------------------------------------
	// Private Members
	// --------------------------------------------------

	// --------------------------------------------------
	// Constructors
	// --------------------------------------------------
	public OpenLocaleSettingAction()
	{
		super("Locale Settings");

		putValue(SHORT_DESCRIPTION, "Open the Locale Settings window.");
		putValue(MNEMONIC_KEY, new Integer(KeyEvent.VK_F10));

		setEnabled(false);
	}

	// --------------------------------------------------
	// Overridden Methods
	// --------------------------------------------------
	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		Frames.open(FrameType.LocaleSettingFrame);
	}

	// --------------------------------------------------
	// Public Methods
	// --------------------------------------------------

	// --------------------------------------------------
	// Private Methods
	// --------------------------------------------------






}
