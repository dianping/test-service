package com.dianping.test.service.page.task;

import com.dianping.test.service.ServicePage;
import com.site.web.mvc.ActionContext;
import com.site.web.mvc.ActionPayload;
import com.site.web.mvc.payload.annotation.FieldMeta;

public class Payload implements ActionPayload<ServicePage, Action> {
	private ServicePage m_page;

	@FieldMeta("op")
	private Action m_action;

	@FieldMeta("host")
	private String m_host;

	@FieldMeta("port")
	private int m_port = 80;

	@FieldMeta("feature")
	private String m_feature;

	@FieldMeta("env")
	private String m_env;

	@FieldMeta("token")
	private String m_token;

	public void setAction(String action) {
		m_action = Action.getByName(action, Action.LIST_TASKS);
	}

	@Override
	public Action getAction() {
		return m_action;
	}

	@Override
	public ServicePage getPage() {
		return m_page;
	}

	public String getHost() {
		return m_host;
	}

	public void setHost(String host) {
		m_host = host;
	}

	public int getPort() {
		return m_port;
	}

	public void setPort(int port) {
		m_port = port;
	}

	public String getFeature() {
		return m_feature;
	}

	public void setFeature(String feature) {
		m_feature = feature;
	}

	public String getEnv() {
		return m_env;
	}

	public void setEnv(String env) {
		m_env = env;
	}

	public String getToken() {
		return m_token;
	}

	public void setToken(String token) {
		m_token = token;
	}

	@Override
	public void setPage(String page) {
		m_page = ServicePage.getByName(page, ServicePage.TASK);
	}

	@Override
	public void validate(ActionContext<?> ctx) {
		if (m_action == null) {
			m_action = Action.LIST_TASKS;
		}
	}
}
