package com.dianping.test.service.page.task;

import com.dianping.test.service.ServicePage;
import com.site.web.mvc.ActionContext;
import com.site.web.mvc.ActionPayload;
import com.site.web.mvc.payload.annotation.FieldMeta;

public class Payload implements ActionPayload<ServicePage, Action> {
	private ServicePage m_page;

	@FieldMeta("op")
	private Action m_action;

	public void setAction(Action action) {
		m_action = action;
	}

	@Override
	public Action getAction() {
		return m_action;
	}

	@Override
	public ServicePage getPage() {
		return m_page;
	}

	@Override
	public void setPage(String page) {
		m_page = ServicePage.getByName(page, ServicePage.TASK);
	}

	@Override
	public void validate(ActionContext<?> ctx) {
	}
}
