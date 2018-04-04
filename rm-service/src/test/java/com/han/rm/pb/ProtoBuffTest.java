package com.han.rm.pb;

import org.junit.Test;

import com.google.protobuf.InvalidProtocolBufferException;

public class ProtoBuffTest
{

	@Test
	public void testPb() throws InvalidProtocolBufferException
	{
/**		LoginRequest.Builder builder = LoginRequest.newBuilder();
		builder.setRequestType();
		builder.setUserName("zhangsan");
		builder.setPassword("123456");
		builder.mergeRequestType(RmRequest.newBuilder().setMsgType(1000).build());
		LoginRequest loginRequest = builder.build();
		System.out.println(loginRequest.toByteArray());

		byte[] data = loginRequest.toByteArray();
		
		RmRequest rmRequest = RmRequest.parseFrom(data)	;
	
		int msgType = rmRequest.getMsgCommand();
		System.out.println(rmRequest.getMsgCommand());
		System.out.println(msgType);
		if (1000 == msgType)
		{
			LoginRequest request = LoginRequest.parseFrom(data);
			System.out.println(request.getUserName());

		}
		
		System.out.println(LoginRequest.parseFrom(data).getRequestType().getMsgType());**/
	}

}
