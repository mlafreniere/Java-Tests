package com.me.factories;

import com.me.factories.types.ObjectType;

public interface IFactory<T>
{
	// --------------------------------------------------
	// Abstract Methods
	// --------------------------------------------------
	T create(ObjectType objectType);
}
