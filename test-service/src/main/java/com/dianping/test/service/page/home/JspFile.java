package com.dianping.test.service.page.home;

public enum JspFile {
	VIEW("/jsp/service/home.jsp"),

	;

	private String m_path;

	private JspFile(String path) {
		m_path = path;
	}

	public String getPath() {
		return m_path;
	}
}
