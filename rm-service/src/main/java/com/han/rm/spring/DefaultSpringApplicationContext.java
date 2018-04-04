package com.han.rm.spring;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 *当前没有去考虑支持多个文件的配置，需要修改也很简单 
 *支持字节数组的方式去初始化context，这样配置中心可以多样化
 * @author HAN
 *
 */
public class DefaultSpringApplicationContext extends AbstractXmlApplicationContext
{

	private Resource[] configResources;

	public DefaultSpringApplicationContext(ApplicationContext parent)
	{

		super(parent);
	}

	public DefaultSpringApplicationContext(byte[] byteArray)
	{
		this(byteArray, null);
	}

	public DefaultSpringApplicationContext(byte[] byteArray, byte[] propsArray)
	{
		this(byteArray, propsArray, true, null);
	}

	public DefaultSpringApplicationContext(byte[] byteArray, byte[] propsArray, boolean refresh,
			ApplicationContext parent) throws BeansException
	{

		super(parent);

		initApplicationContext(propsArray);

		ByteArrayResource arrayResource = new ByteArrayResource(byteArray);
		configResources = new Resource[1];
		configResources[0] = arrayResource;

		if (refresh)
		{
			refresh();
		}
	}

	/**
	 * 可以自定义子类实现特定的功能初始化
	 * @param propsArray
	 */
	protected void initApplicationContext(byte[] propsArray)
	{

		PropertyPlaceholderConfigurer placeholderConfigurer = new PropertyPlaceholderConfigurer();
		Properties p = null;
		try
		{
			p = PropertiesLoaderUtils.loadProperties(new EncodedResource(new ByteArrayResource(propsArray), "UTF-8"));
		} catch (IOException e)
		{

			e.printStackTrace();
		}
		placeholderConfigurer.setProperties(p);
		this.addBeanFactoryPostProcessor(placeholderConfigurer);

	}

	@Override
	protected Resource[] getConfigResources()
	{
		return this.configResources;
	}

}
