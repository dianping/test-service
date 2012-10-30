package com.dianping.test.service.page.task;

import com.dianping.test.service.ServicePage;
import com.site.web.mvc.ViewModel;

public class Model extends ViewModel<ServicePage, Action, Context> {
	public Model(Context ctx) {
		super(ctx);
	}

	@Override
	public Action getDefaultAction() {
		return Action.VIEW;
	}
}
