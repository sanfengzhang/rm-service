package com.han.rm.client;

import com.han.rm.server.protocol.RmRequest;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class RmClientRquestEncoder extends MessageToByteEncoder<RmRequest>
{

	@Override
	protected void encode(ChannelHandlerContext ctx, RmRequest msg, ByteBuf out) throws Exception
	{
		msg.writeBuffer(out);
	}

}
