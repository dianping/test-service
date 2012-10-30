package com.dianping.test.service.page.task;

public enum JspFile {
	VIEW("/jsp/service/task.jsp"),

	;

	private String m_path;

	private JspFile(String path) {
		m_path = path;
	}

	public String getPath() {
		return m_path;
	}
}
