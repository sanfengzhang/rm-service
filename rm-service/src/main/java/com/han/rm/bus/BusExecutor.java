package com.han.rm.bus;

/**
 * 业务消息处理逻辑、可以根据不同的消息类型选择不同的处理器去执行
 * 
 * @author HAN
 *
 */
public interface BusExecutor
{
	public void submit(RmMessage message);

}
