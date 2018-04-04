package com.han.rm.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class EscafThreadFactory implements ThreadFactory
{

	private String threadFactoryName;

	private AtomicInteger count = new AtomicInteger(0);

	public EscafThreadFactory(String threadFactoryName)
	{
		super();
		this.threadFactoryName = threadFactoryName;
	}

	public Thread newThread(Runnable r)
	{

		Thread t = new Thread(r);
		t.setName(threadFactoryName + "---" + count.getAndIncrement());
		t.setDaemon(true);
		return t;
	}

}
