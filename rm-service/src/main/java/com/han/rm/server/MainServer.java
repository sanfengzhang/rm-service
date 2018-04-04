package com.han.rm.server;

import com.han.rm.bus.BusContext;
import com.han.rm.bus.BusRequestDispatcher;
import com.han.rm.config.AbstractConfig;
import com.han.rm.server.protocol.RmProtobufDecoder;
import com.han.rm.server.protocol.RmProtobufEncoder;
import com.han.rm.util.EscafThreadFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class MainServer
{
	private NioEventLoopGroup bossGrop = null;

	private NioEventLoopGroup workGroup = null;

	private ServerBootstrap serverBootstrap = null;

	private static final int SERVER_PORT = 6278;

	private static final String HOST_IP = "127.0.0.1";

	private AbstractConfig config = null;

	private BusContext busContext = null;

	public MainServer()
	{
	}

	public MainServer(AbstractConfig config)
	{
		super();
		this.config = config;
	}

	//这里结合spring来做业务处理，其实在channleHandler中持有一个BusContext对象实例即可
	public void start()
	{
		try
		{

			busContext = new BusContext(config);
			bossGrop = new NioEventLoopGroup(config.getDefaultInt("netty_boss_num_threads", 1),
					new EscafThreadFactory("netty_boss_threadFactory"));
			workGroup = new NioEventLoopGroup(config.getDefaultInt("netty_work_num_threads", 1),
					new EscafThreadFactory("netty_work_threadFactory"));

			serverBootstrap = new ServerBootstrap();

			serverBootstrap.group(bossGrop, workGroup).channel(NioServerSocketChannel.class)
					.childHandler(new RmChannelInitializer());

			serverBootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
			serverBootstrap.childOption(ChannelOption.TCP_NODELAY, true);

			ChannelFuture futuer = serverBootstrap.bind(config.getDefaultString("netty_bind_host", HOST_IP),
					config.getDefaultInt("netty_bind_port", SERVER_PORT));

			futuer.channel().closeFuture().sync();
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			if (null != workGroup)
			{
				workGroup.shutdownGracefully();
			}
			if (null != bossGrop)
			{
				bossGrop.shutdownGracefully();
			}

			if (null != busContext)
			{
				busContext.close();
			}

		}

	}

	public AbstractConfig getConfig()
	{
		return config;
	}

	private final class RmChannelInitializer extends ChannelInitializer<Channel>
	{

		@Override
		protected void initChannel(Channel ch) throws Exception
		{

			ChannelPipeline pipeline = ch.pipeline();

			pipeline.addLast("logging", new LoggingHandler(LogLevel.DEBUG));

			// ----Protobuf处理器，这里的配置是关键----
			// 用于decode前解决半包和粘包问题（利用包头中的包含数组长度来识别半包粘包）
			pipeline.addLast("frameDecoder", new LengthFieldBasedFrameDecoder(1048576, 4, 4, 0, 0));
			// 配置Protobuf解码处理器，消息接收到了就会自动解码，ProtobufDecoder是netty自带的，Message是自己定义的Protobuf类
			pipeline.addLast("protobufDecoder", new RmProtobufDecoder());

			// 配置Protobuf编码器，发送的消息会先经过编码
			pipeline.addLast("protobufEncoder", new RmProtobufEncoder());

			pipeline.addLast("rmBusinessHandler", new RmChannelHandler(busContext.getBean(BusRequestDispatcher.class)));

		}
	}

}
