package com.dianping.test.service.page.task;

import java.io.IOException;

import javax.servlet.ServletException;

import com.dianping.test.service.ServicePage;
import com.site.lookup.annotation.Inject;
import com.site.web.mvc.PageHandler;
import com.site.web.mvc.annotation.InboundActionMeta;
import com.site.web.mvc.annotation.OutboundActionMeta;
import com.site.web.mvc.annotation.PayloadMeta;

public class Handler implements PageHandler<Context> {
	@Inject
	private JspViewer m_jspViewer;

	@Inject
	private TaskManager m_manager;

	@Override
	@PayloadMeta(Payload.class)
	@InboundActionMeta(name = "task")
	public void handleInbound(Context ctx) throws ServletException, IOException {
		Payload payload = ctx.getPayload();
		Action action = payload.getAction();

		if (action == Action.SUBMIT_TASK) {
			Task task = new Task(payload.getHost(), payload.getPort(), payload.getFeature(), payload.getEnv());

			if (m_manager.submitTask(task)) {
				ctx.setId(task.getId());
			}
		}
	}

	@Override
	@OutboundActionMeta(name = "task")
	public void handleOutbound(Context ctx) throws ServletException, IOException {
		Model model = new Model(ctx);
		Payload payload = ctx.getPayload();
		Action action = payload.getAction();

		switch (action) {
		case SUBMIT_TASK:
			model.setToken(ctx.getId());
			break;
		case GET_TASK_STATUS:
			Task task = m_manager.getTask(payload.getId());
			if(task != null)
				task.setStatus(m_manager.getStatus(payload.getId(), task.getJobNum()));

			model.setTask(task);
			break;
		case LIST_TASKS:
			model.setTasks(m_manager.listActiveTasks());
			break;
		}

		model.setAction(action);
		model.setPage(ServicePage.TASK);
		m_jspViewer.view(ctx, model);
	}
}
