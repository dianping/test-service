package com.dianping.test.service;

import com.site.web.mvc.AbstractModule;
import com.site.web.mvc.annotation.ModuleMeta;
import com.site.web.mvc.annotation.ModulePagesMeta;

@ModuleMeta(name = "service", defaultInboundAction = "home", defaultTransition = "default", defaultErrorAction = "default")
@ModulePagesMeta({

com.dianping.test.service.page.home.Handler.class,

com.dianping.test.service.page.task.Handler.class
})
public class ServiceModule extends AbstractModule {

}
