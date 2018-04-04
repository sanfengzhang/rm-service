package com.han.rm.bus.service;

import com.han.rm.bus.RmMessage;

public interface BusHandler
{
	public void handle(RmMessage message);

	public int getCommadId();

}
