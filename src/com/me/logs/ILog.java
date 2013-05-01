package com.me.logs;

public interface ILog
{
	// --------------------------------------------------
	// Abstract Methods
	// --------------------------------------------------
	public void error(String message);

	public void information(String message);

	public void warning(String message);
}
