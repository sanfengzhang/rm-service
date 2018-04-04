package com.han.rm.bus;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.han.rm.bus.service.BusHandler;
import com.han.rm.server.protocol.RmRequest;

import io.netty.channel.Channel;

/**
 * 对不同的消息进行分发到不同的处理器,在实际使用中一般是单例的。
 * 
 * @author HAN
 *
 */
@Service
public class BusRequestDispatcher implements ApplicationContextAware, ApplicationListener<ContextRefreshedEvent>
{

	private Map<Integer, BusHandler> handlers = new HashMap<Integer, BusHandler>();

	private ApplicationContext applicationContext;

	public BusRequestDispatcher()
	{

	}

	public void dispatch(Channel ch, RmRequest request)
	{
		int msgType = request.getMsgType();
		BusExecutor executor = getExector(msgType);
		BusHandler handler = handlers.get(msgType);

		RmMessage message = new RmMessage(request.getMessageLite(), ch, handler);
		executor.submit(message);

	}

	public BusExecutor getExector(int msgType)
	{
		if (msgType > 1000)
		{
			return applicationContext.getBean(DefaultBusExecutor.class);
		}

		return null;
	}

	public void onApplicationEvent(ContextRefreshedEvent event)
	{
		ApplicationContext applicationContext = event.getApplicationContext();

		if (applicationContext != null)
		{
			Map<String, BusHandler> beansMap = applicationContext.getBeansOfType(BusHandler.class);
			Iterator<Entry<String, BusHandler>> it = beansMap.entrySet().iterator();

			while (it.hasNext())
			{
				Entry<String, BusHandler> en = it.next();
				BusHandler handler = en.getValue();
				handlers.put(handler.getCommadId(), handler);

			}

		}

	}

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
	{
		this.applicationContext = applicationContext;

	}

}
