<%@ page contentType="text/html; charset=utf-8" %>
<jsp:useBean id="ctx" type="com.dianping.test.service.page.home.Context" scope="request"/>
<jsp:useBean id="payload" type="com.dianping.test.service.page.home.Payload" scope="request"/>
<jsp:useBean id="model" type="com.dianping.test.service.page.home.Model" scope="request"/>

Test Service Home Page

<br><br>
<a href="${model.moduleUri}/task">Task List</a>
<br><br>
<a href="${model.moduleUri}/task?op=submitTask">Submit Task</a>