package com.dianping.test.build;

import java.util.ArrayList;
import java.util.List;

import com.dianping.test.service.ServiceModule;

import com.site.lookup.configuration.Component;
import com.site.web.configuration.AbstractWebComponentsConfigurator;

class WebComponentConfigurator extends AbstractWebComponentsConfigurator {
	@SuppressWarnings("unchecked")
	@Override
	public List<Component> defineComponents() {
		List<Component> all = new ArrayList<Component>();

		defineModuleRegistry(all, ServiceModule.class, ServiceModule.class);

		return all;
	}
}
