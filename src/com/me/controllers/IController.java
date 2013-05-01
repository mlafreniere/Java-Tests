package com.me.controllers;

import com.me.frames.IFrame;

public interface IController
{
	// --------------------------------------------------
	// Abstract Methods
	// --------------------------------------------------
	void bind(IFrame frame);

	void unbind();
}
