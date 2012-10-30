package com.dianping.test.service.page.task;

import com.dianping.test.service.ServicePage;
import com.site.web.mvc.view.BaseJspViewer;

public class JspViewer extends BaseJspViewer<ServicePage, Action, Context, Model> {
	@Override
	protected String getJspFilePath(Context ctx, Model model) {
		Action action = model.getAction();

		switch (action) {
		case LIST_TASKS:
		case SUBMIT_TASK:
		case GET_TASK_STATUS:
			return JspFile.VIEW.getPath();
		}

		throw new RuntimeException("Unknown action: " + action);
	}
}
