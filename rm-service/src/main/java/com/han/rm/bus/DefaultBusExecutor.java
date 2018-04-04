package com.han.rm.bus;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.han.rm.bus.service.BusHandler;
import com.han.rm.util.EscafThreadFactory;

@Service
public class DefaultBusExecutor implements BusExecutor, InitializingBean, DisposableBean
{
	private BlockingQueue<RmMessage> queue = null;

	private ExecutorService executorService = null;

	public DefaultBusExecutor()
	{
		queue = new LinkedBlockingDeque<RmMessage>(50000);
		executorService = Executors.newSingleThreadExecutor(new EscafThreadFactory("default exexutor"));
	}

	public DefaultBusExecutor(BlockingQueue<RmMessage> queue, EscafThreadFactory escafThreadFactory)
	{
		this.queue = queue;
		executorService = Executors.newSingleThreadExecutor(escafThreadFactory);
	}

	public void submit(RmMessage message)
	{

		queue.offer(message);
	}

	private final class ExecuteRunnable implements Runnable
	{

		public void run()
		{
			while (true)
			{
				RmMessage message = null;
				try
				{
					message = queue.take();
				} catch (InterruptedException e)
				{

					e.printStackTrace();
				}
				BusHandler handler = message.getHandler();
				if (null == handler)
				{
					throw new NullPointerException("faile to get handler");
				}

				handler.handle(message);
			}
		}

	}

	public void destroy() throws Exception
	{
		if (null != executorService)
		{
			executorService.shutdown();
		}

	}

	public void afterPropertiesSet() throws Exception
	{
		executorService.submit(new ExecuteRunnable());

	}

}
