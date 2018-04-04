# rm-service
消息接受处理系统

基于netty spring开发的消息接受处理系统，将I/O线程和业务线程进行分离，以达到提高业务处理效率;传输协议默认使用protobuffer。
开发人员只要关注业务层对不同消息的业务处理即可。
使用也很简单：
代码中有个简单的Login demo,继承AbstractBusHandler即可，在doHandle方法中处理对对应的消息业务、并返回结果给client

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

