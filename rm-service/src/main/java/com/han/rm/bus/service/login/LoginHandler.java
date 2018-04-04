package com.han.rm.bus.service.login;

import org.springframework.stereotype.Service;

import com.google.protobuf.InvalidProtocolBufferException;
import com.han.rm.bus.RmMessage;
import com.han.rm.bus.service.AbstractBusHandler;
import com.han.rm.proto.LoginProto.LoginRequest;
import com.han.rm.proto.ResponseProto.Response;
import com.han.rm.proto.ResponseProto.Response.Builder;
import com.han.rm.server.protocol.RmResponse;

@Service
public class LoginHandler extends AbstractBusHandler
{
	public static final int LOGIN_CMD_ID = 1001;

	@Override
	public RmResponse doHandle(RmMessage message) throws InvalidProtocolBufferException
	{
		byte[] data = message.getMessageLite().toByteArray();
		LoginRequest request = LoginRequest.parseFrom(data);
		String userName = request.getUserName();
		String password = request.getPassword();
		System.out.println("name=" + userName + ",passwd=" + password);
		Builder builder = Response.newBuilder();
		builder.setResponseCode(101);
		RmResponse response = new RmResponse();
		response.setMessageLite(builder.build());

		return response;
	}

	public int getCommadId()
	{

		return LOGIN_CMD_ID;
	}

}
