package com.han.rm.client;

import com.han.rm.proto.LoginProto.LoginRequest;
import com.han.rm.server.protocol.RmRequest;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class NetClientHandler extends ChannelInboundHandlerAdapter
{

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception
	{

		RmRequest msg = new RmRequest();
		LoginRequest.Builder builder = LoginRequest.newBuilder();
		builder.setUserName("zhangsan");
		builder.setPassword("123456");
		LoginRequest request = builder.build();
		msg.setMessageLite(request);
		msg.setMsgType(1001);
		ctx.writeAndFlush(msg);

	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception
	{
		System.out.println("client recieve:" + msg);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception
	{

		cause.printStackTrace();
	}

}