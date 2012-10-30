package com.dianping.test.service.page.task;

import com.dianping.test.service.ServicePage;
import com.site.web.mvc.ViewModel;

public class Model extends ViewModel<ServicePage, Action, Context> {
	private Task m_task;

	private String m_token;

	public Model(Context ctx) {
		super(ctx);
	}

	@Override
	public Action getDefaultAction() {
		return Action.LIST_TASKS;
	}

	public Task getTask() {
		return m_task;
	}

	public String getToken() {
		return m_token;
	}

	public void setTask(Task task) {
		m_task = task;
	}

	public void setToken(String token) {
		m_token = token;
	}
}
