package com.han.rm.server.protocol;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.han.rm.proto.LoginProto.LoginRequest;

import io.netty.buffer.ByteBuf;

public class RmRequest
{
	// 消息类型,example：login、logout
	private int msgType = 0;

	private int mark;

	private MessageLite messageLite;

	public RmRequest()
	{

	}

	public RmRequest(int msgType, MessageLite messageLite)
	{
		super();
		this.msgType = msgType;
		this.messageLite = messageLite;
	}

	/**
	 * 将该协议对象写入到byteBuffer中去
	 * 
	 * @return
	 */
	public void writeBuffer(ByteBuf out)
	{

		byte[] arr = messageLite.toByteArray();
		int bodyLen = arr.length;

		out.writeInt(msgType);
		out.writeInt(bodyLen);
		out.writeBytes(arr);

	}

	public static RmRequest readBuffer(ByteBuf in)
	{
		in.markReaderIndex();
		int type = in.readInt();
		int length = in.readInt();

		final byte[] array;
		final int offset;

		if (in.readableBytes() < length)
		{
			in.resetReaderIndex();
			return null;
		}
		if (in.hasArray())
		{
			array = in.array();
			offset = in.arrayOffset() + in.readerIndex();
		} else
		{

			// note 不能使用 msg.getBytes(msg.readerIndex(), array, 0, length);这种写法
			// 因为在netty 的coder中它在上层重新创建了一个buffer的
			array = new byte[length];
			in.readBytes(array);
			offset = 0;
		}

		MessageLite messageLite = null;
		try
		{
			messageLite = getMessageLiteByType(type, array, offset, length);
		} catch (InvalidProtocolBufferException e)
		{

			e.printStackTrace();
		}

		final RmRequest request = new RmRequest();
		request.messageLite = messageLite;
		request.msgType = type;

		return request;

	}

	public static MessageLite getMessageLiteByType(int type, byte[] array, int offset, int length)
			throws InvalidProtocolBufferException
	{
		switch (type)
		{
		case 1001:

			return LoginRequest.getDefaultInstance().getParserForType().parseFrom(array, offset, length);

		default:
			throw new IllegalArgumentException("can not find message type by command=[" + type + "]");
		}

	}

	public int getMsgType()
	{
		return msgType;
	}

	public void setMsgType(int msgType)
	{
		this.msgType = msgType;
	}

	public int getMark()
	{
		return mark;
	}

	public void setMark(int mark)
	{
		this.mark = mark;
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
		return "RmRequest [msgType=" + msgType + ", mark=" + mark + ", messageLite=" + messageLite + "]";
	}

}
