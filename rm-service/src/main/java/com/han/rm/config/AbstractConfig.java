package com.han.rm.config;

public abstract class AbstractConfig
{

	public abstract String getString(String key);

	public String getDefaultString(String key, String value)
	{
		String getValue = getString(key);
		if (null == getValue || "".equals(getValue.trim()))
		{
			getValue = value;
		}

		return getValue;

	}

	public int getInt(String key)
	{
		String string = getString(key);
		return Integer.parseInt(string);
	}

	public int getDefaultInt(String key, int value)
	{
		String getValue = getString(key);
		if (null == getValue || "".equals(getValue.trim()))
		{
			getValue = value + "";
		}

		return Integer.parseInt(getValue);
	}
	
	public abstract byte[] getBytes(String key);
}
