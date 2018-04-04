package com.han.rm.server;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.DefaultEventExecutor;

public class ChannelGroupService
{
	private static Map<String, ChannelGroup> channelGroups = new ConcurrentHashMap<String, ChannelGroup>();

	static
	{
		channelGroups.put("defGroup", new DefaultChannelGroup("defGroup", new DefaultEventExecutor()));
	}

	public static void create(String groupName)
	{
		ChannelGroup channelGroup = new DefaultChannelGroup(groupName, null);

		channelGroups.put(groupName, channelGroup);
	}

	public static ChannelGroup getChannelGroup(String groupName)
	{

		return channelGroups.get(groupName);
	}

	public static void addDefaultChannelGroup(Channel ch)
	{
		channelGroups.get("defGroup").add(ch);

	}

}
