package com.han.rm.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class Client
{

	public static void main(String[] args) throws Exception
	{

		// Configure the client.
		EventLoopGroup group = new NioEventLoopGroup();
		try
		{
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
					.handler(new ChannelInitializer<SocketChannel>()
					{
						@Override
						public void initChannel(SocketChannel ch) throws Exception
						{

							ChannelPipeline pipeline = ch.pipeline();

							// pipeline.addLast("logging", new LoggingHandler(LogLevel.DEBUG));
							pipeline.addLast("frameDecoder", new LengthFieldBasedFrameDecoder(1048576, 0, 4, 0, 0));// 用于decode前解决半包和粘包问题（利用包头中的包含数组长度来识别半包粘包）
							// 配置Protobuf解码处理器，消息接收到了就会自动解码，ProtobufDecoder是netty自带的，Message是自己定义的Protobuf类
							pipeline.addLast("protobufDecoder", new RmClientResponseDecoder());

							// 配置Protobuf编码器，发送的消息会先经过编码
							pipeline.addLast("protobufEncoder", new RmClientRquestEncoder());

							ch.pipeline().addLast(new NetClientHandler());
						}
					});

			ChannelFuture future = b.connect("127.0.0.1", 6278).sync();
			future.channel().closeFuture().sync();
		} finally
		{
			group.shutdownGracefully();
		}
	}

}
