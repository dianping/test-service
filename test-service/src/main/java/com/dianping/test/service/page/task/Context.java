package com.dianping.test.service.page.task;

import com.dianping.test.service.ServiceContext;

public class Context extends ServiceContext<Payload> {
	private String m_id;

	public String getId() {
		return m_id;
	}

	public void setId(String id) {
		m_id = id;
	}
}
