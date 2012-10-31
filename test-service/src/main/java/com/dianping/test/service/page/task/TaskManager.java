package com.dianping.test.service.page.task;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.dianping.test.service.page.task.Task.TaskStatus;

public class TaskManager {
	private List<Task> m_tasks = new ArrayList<Task>();

	public boolean submitTask(Task task) {
		// TODO do real job here
		task.setId(UUID.randomUUID().toString());

		if (m_tasks.size() % 2 == 0) {
			task.setStatus(TaskStatus.DONE);
		} else {
			task.setStatus(TaskStatus.PENDING);
		}

		m_tasks.add(task);
		return true;
	}

	public Task getTask(String id) {
		for (Task task : m_tasks) {
			if (task.getId().equals(id)) {
				return task;
			}
		}

		return null;
	}

	public List<Task> listActiveTasks() {
		return m_tasks;
	}
}
