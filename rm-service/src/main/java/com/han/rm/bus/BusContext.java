package com.han.rm.bus;

import org.springframework.beans.BeansException;
import org.springframework.context.support.AbstractApplicationContext;

import com.han.rm.config.AbstractConfig;
import com.han.rm.spring.DefaultSpringApplicationContext;

/**
 * BusContext主要是初始化业务上下文,衔接netty main server和后端spring application context的作用
 * 
 * @author HAN
 *
 */
public class BusContext
{

	private AbstractApplicationContext applicationContext;

	private AbstractConfig config;

	public BusContext(AbstractConfig config)
	{

		this.config = config;
		applicationContext = new DefaultSpringApplicationContext(config.getBytes("spring-beans"),
				config.getBytes("spring-config"));
	}

	public <T> T getBean(Class<T> requiredType) throws BeansException
	{
		return applicationContext.getBean(requiredType);
	}

	public void close()
	{
		if (null != applicationContext)
		{
			applicationContext.close();
		}

	}

	public AbstractApplicationContext getApplicationContext()
	{
		return applicationContext;
	}

	public void setApplicationContext(AbstractApplicationContext applicationContext)
	{
		this.applicationContext = applicationContext;
	}

	public AbstractConfig getConfig()
	{
		return config;
	}

	public void setConfig(AbstractConfig config)
	{
		this.config = config;
	}

}
