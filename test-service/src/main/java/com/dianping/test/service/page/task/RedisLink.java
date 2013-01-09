package com.dianping.test.service.page.task;

import redis.clients.jedis.Jedis;

public class RedisLink {
	static private Jedis jedis = new Jedis("192.168.5.142", 6379);
	
	static public Jedis getJeis() {
		return jedis;
	}
}
