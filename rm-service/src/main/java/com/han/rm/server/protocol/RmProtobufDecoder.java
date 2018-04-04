package com.han.rm.server.protocol;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class RmProtobufDecoder extends ByteToMessageDecoder
{

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception
	{
		if (in.readableBytes() < 8)
		{
			return;
		}

		RmRequest request = RmRequest.readBuffer(in);
		if (null != request)
		{
			out.add(request);
		}

	}

}
