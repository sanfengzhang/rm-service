package com.han.rm.server.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 
 * 使用Protobuffer协议的时候自定义一个消息结构 在原有的基础上增加一个消息类型字段和预留字段，消息类型字段主要是在使用protobuf解码的时候
 * 能够知道消息具体的解码对象 length Example:
 * 
 * <pre>
 * BEFORE ENCODE (300 bytes)       AFTER ENCODE (304 bytes)
 * +---------------+               +--------+---------+---------+-----------------+
 * | Protobuf Data |-------------->| Type   |  Length |  Protobuf Data  |
 * |  (300 bytes)  |               | 0xAC02 |  0xAC02 |  (306 bytes)    |
 * +---------------+               +--------+---------+---------+-----------------+
 * </pre>
 * 
 * *
 *
 *
 */
public class RmProtobufEncoder extends MessageToByteEncoder<RmResponse>
{

	public RmProtobufEncoder()
	{

	}

	public RmProtobufEncoder(Class<RmResponse> class1)
	{
		super(class1);
	}

	@Override
	protected void encode(ChannelHandlerContext ctx, RmResponse msg, ByteBuf out) throws Exception
	{
		msg.writeBuffer(out);

	}

}
