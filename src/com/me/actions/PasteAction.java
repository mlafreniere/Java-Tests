package com.me.actions;

import com.me.annotations.MenuPath;

@MenuPath(Path = "Edit")
public class PasteAction extends javax.swing.text.DefaultEditorKit.PasteAction
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
	public PasteAction()
	{
		putValue(NAME, "Paste");
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
}
