package com.han.rm.server;

import com.han.rm.bus.BusRequestDispatcher;
import com.han.rm.server.protocol.RmRequest;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class RmChannelHandler extends ChannelInboundHandlerAdapter
{

	private BusRequestDispatcher dispatcher;

	public RmChannelHandler(BusRequestDispatcher dispatcher)
	{
		super();
		this.dispatcher = dispatcher;
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception
	{

		// 可以自己按业务对channel进行分组
		ChannelGroupService.addDefaultChannelGroup(ctx.channel());
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
	{

		if (msg instanceof RmRequest)
		{
			dispatcher.dispatch(ctx.channel(), (RmRequest) msg);

		} else
		{
			// ingore
			super.channelRead(ctx, msg);
		}

	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
	{

		super.exceptionCaught(ctx, cause);
	}

}
