package com.dianping.test.service.page.task;

import java.util.List;

import com.dianping.test.service.ServicePage;
import com.site.web.mvc.ViewModel;

public class Model extends ViewModel<ServicePage, Action, Context> {
	private Task m_task;

	private String m_token;

	private List<Task> m_tasks;

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

	public List<Task> getTasks() {
		return m_tasks;
	}

	public String getToken() {
		return m_token;
	}

	public void setTask(Task task) {
		m_task = task;
	}

	public void setTasks(List<Task> tasks) {
		m_tasks = tasks;
	}

	public void setToken(String token) {
		m_token = token;
	}
}
