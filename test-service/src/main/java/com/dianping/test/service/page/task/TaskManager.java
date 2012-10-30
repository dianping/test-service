package com.dianping.test.service.page.task;

import java.util.UUID;

import com.dianping.test.service.page.task.Task.TaskStatus;

public class TaskManager {
	public boolean submitTask(Task task) {
		// TODO do real job here
		task.setId(UUID.randomUUID().toString());

		return true;
	}

	public Task getTask(String id) {
		// TODO do real job here
		Task task = new Task();

		task.setId(id);
		task.setStatus(TaskStatus.DONE);
		return task;
	}
}
