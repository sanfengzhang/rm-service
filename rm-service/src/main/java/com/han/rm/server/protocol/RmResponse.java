package com.han.rm.server.protocol;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.han.rm.proto.ResponseProto.Response;

import io.netty.buffer.ByteBuf;

public class RmResponse
{

	private MessageLite messageLite;

	public void writeBuffer(ByteBuf out)
	{
		byte[] arr = messageLite.toByteArray();
		int bodyLen = arr.length;

		out.writeInt(bodyLen);
		out.writeBytes(arr);

	}

	public static Response readBuffer(ByteBuf in)
	{

		in.markReaderIndex();

		int length = in.readInt();

		final byte[] array;
		if (in.readableBytes() < length)
		{
			in.resetReaderIndex();
			return null;
		}
		if (in.hasArray())
		{
			array = in.array();
		} else
		{

			// note 不能使用 msg.getBytes(msg.readerIndex(), array, 0, length);这种写法
			// 因为在netty 的coder中它在上层重新创建了一个buffer的
			array = new byte[length];
			in.readBytes(array);
		}

		try
		{
			Response response = Response.parseFrom(array);

			return response;
		} catch (InvalidProtocolBufferException e)
		{

			e.printStackTrace();
		}

		return null;

	}

	public MessageLite getMessageLite()
	{
		return messageLite;
	}

	public void setMessageLite(MessageLite messageLite)
	{
		this.messageLite = messageLite;
	}

	@Override
	public String toString()
	{
		return "RmResponse [messageLite=" + messageLite + "]";
	}

}
