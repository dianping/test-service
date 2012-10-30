package com.dianping.test.service.page.task;

public class Task {
	private String m_id;

	private String m_host;

	private int m_port;

	private String m_feature;

	private String m_env;

	private String m_token;

	private TaskStatus m_status;

	public Task() {
	}

	public Task(String host, int port, String feature, String env) {
		m_host = host;
		m_port = port;
		m_feature = feature;
		m_env = env;
	}

	public String getEnv() {
		return m_env;
	}

	public String getFeature() {
		return m_feature;
	}

	public String getHost() {
		return m_host;
	}

	public String getId() {
		return m_id;
	}

	public int getPort() {
		return m_port;
	}

	public TaskStatus getStatus() {
		return m_status;
	}

	public String getToken() {
		return m_token;
	}

	public void setId(String id) {
		m_id = id;
	}

	public void setStatus(TaskStatus status) {
		m_status = status;
	}

	public void setToken(String token) {
		m_token = token;
	}

	public static enum TaskStatus {
		PENDING,

		RUNNING,

		DONE,

		ABORTED;

		public String getName() {
			return name();
		}
	}
}
