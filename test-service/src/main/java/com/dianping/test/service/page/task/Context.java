package com.dianping.test.service.page.task;

import com.dianping.test.service.ServiceContext;

public class Context extends ServiceContext<Payload> {

	private String m_token;

	public String getToken() {
		return m_token;
	}

	public void setToken(String token) {
		m_token = token;
	}
}
