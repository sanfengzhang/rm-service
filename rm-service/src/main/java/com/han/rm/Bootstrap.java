package com.han.rm;

import com.han.rm.config.DefaultLocalConfig;
import com.han.rm.server.MainServer;

import io.netty.util.internal.logging.InternalLoggerFactory;
import io.netty.util.internal.logging.Slf4JLoggerFactory;

public class Bootstrap
{

	public static void main(String[] args)
	{

		InternalLoggerFactory.setDefaultFactory(Slf4JLoggerFactory.INSTANCE);
		MainServer server = new MainServer(new DefaultLocalConfig());
		server.start();
	}

}
