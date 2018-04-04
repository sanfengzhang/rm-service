package com.han.rm.bus;

import com.google.protobuf.MessageLite;
import com.han.rm.bus.service.BusHandler;

import io.netty.channel.Channel;

public class RmMessage
{
	private MessageLite messageLite;

	private Channel channel;

	private BusHandler handler;

	public RmMessage(MessageLite messageLite, Channel channel, BusHandler handler)
	{
		super();
		this.messageLite = messageLite;
		this.channel = channel;
		this.handler = handler;
	}

	public MessageLite getMessageLite()
	{
		return messageLite;
	}

	public void setMessageLite(MessageLite messageLite)
	{
		this.messageLite = messageLite;
	}

	public Channel getChannel()
	{
		return channel;
	}

	public void setChannel(Channel channel)
	{
		this.channel = channel;
	}

	public BusHandler getHandler()
	{
		return handler;
	}

	public void setHandler(BusHandler handler)
	{
		this.handler = handler;
	}

}
