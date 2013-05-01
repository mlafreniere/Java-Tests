package com.me.actions;

import com.me.annotations.MenuPath;

@MenuPath(Path = "Edit")
public class CutAction extends javax.swing.text.DefaultEditorKit.CutAction
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
	public CutAction()
	{
		putValue(NAME, "Cut");
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
