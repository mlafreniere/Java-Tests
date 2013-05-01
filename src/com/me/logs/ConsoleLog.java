package com.me.logs;

public class ConsoleLog implements ILog
{
	// --------------------------------------------------
	// Constants
	// --------------------------------------------------

	// --------------------------------------------------
	// Private Members
	// --------------------------------------------------

	// --------------------------------------------------
	// Constructors
	// --------------------------------------------------

	// --------------------------------------------------
	// Overridden Methods
	// --------------------------------------------------
	@Override
	public void error(String message)
	{
		System.out.println("Error: " + message);
	}

	@Override
	public void information(String message)
	{
		System.out.println("Info: " + message);
	}

	@Override
	public void warning(String message)
	{
		System.out.println("Warning: " + message);
	}
	// --------------------------------------------------
	// Public Methods
	// --------------------------------------------------

	// --------------------------------------------------
	// Private Methods
	// --------------------------------------------------
}
