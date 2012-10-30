<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="ctx" type="com.dianping.test.service.page.task.Context" scope="request" />
<jsp:useBean id="payload" type="com.dianping.test.service.page.task.Payload" scope="request" />
<jsp:useBean id="model" type="com.dianping.test.service.page.task.Model" scope="request" />

<c:choose>
	<c:when test="${model.action.name eq 'submitTask' }">
		<c:if test="${empty model.token}">
		{"status": "submit failed"}
		</c:if>
		<c:if test="${not empty model.token}">
		{"token": "${model.token}"}
		</c:if>
	</c:when>
	<c:when test="${model.action.name eq 'getTaskStatus' }">
		<c:if test="${empty model.task}">
		{"status": "not found"}
		</c:if>
		<c:if test="${not empty model.task}">
		{"status": "${model.task.status.name}"}
		</c:if>
	</c:when>
</c:choose>