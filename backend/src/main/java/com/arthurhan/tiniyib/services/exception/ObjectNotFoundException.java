package com.arthurhan.tiniyib.services.exception;

public class ObjectNotFoundException extends RuntimeException
{
	private static final long serialVersionUID = -3556257183705231907L;

	public ObjectNotFoundException(String msg)
	{
		super(msg);
	}
}
