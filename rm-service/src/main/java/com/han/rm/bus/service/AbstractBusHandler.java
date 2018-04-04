package com.han.rm.bus.service;

import com.han.rm.bus.RmMessage;
import com.han.rm.server.protocol.RmResponse;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

/**
 * 
 * @author HAN
 *
 */
public abstract class AbstractBusHandler implements BusHandler
{

	public void handle(RmMessage message)
	{
		RmResponse response = null;
		try
		{
			response = doHandle(message);
			Channel ch = message.getChannel();

			ChannelFuture future = ch.writeAndFlush(response);

			future.get();
		} catch (Exception e)
		{

			e.printStackTrace();
		}

	}

	public abstract RmResponse doHandle(RmMessage message) throws Exception;

}
