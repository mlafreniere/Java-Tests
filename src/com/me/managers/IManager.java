package com.me.managers;

import com.me.factories.types.ManagerType;

public interface IManager
{
	// --------------------------------------------------
	// Abstract Methods
	// --------------------------------------------------
	public void initialize();

	public void dispose();

	public ManagerType getType();
}
