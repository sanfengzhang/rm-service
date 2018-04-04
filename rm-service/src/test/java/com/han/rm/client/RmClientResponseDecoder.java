package com.han.rm.client;

import java.util.List;

import com.han.rm.proto.ResponseProto.Response;
import com.han.rm.server.protocol.RmResponse;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class RmClientResponseDecoder extends ByteToMessageDecoder
{

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception
	{
		if (in.readableBytes() < 4)
		{
			return;
		}
		System.out.println("RmClientResponseDecoder..." + in.toString() + Thread.currentThread().getId());
		Response response = RmResponse.readBuffer(in);
		if (null != response)
		{
			out.add(response);
		}

	}

}
