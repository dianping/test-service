package com.dianping.test.service.page.task;

public enum Action implements com.site.web.mvc.Action {
	LIST_TASKS("listTasks"),

	SUBMIT_TASK("submitTask"),

	GET_TASK_STATUS("getTaskStatus");

	private String m_name;

	private Action(String name) {
		m_name = name;
	}

	public static Action getByName(String name, Action defaultAction) {
		for (Action action : Action.values()) {
			if (action.getName().equals(name)) {
				return action;
			}
		}

		return defaultAction;
	}

	@Override
	public String getName() {
		return m_name;
	}
}
