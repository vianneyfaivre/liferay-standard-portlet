<%@ include file="/html/init.jsp"%>

<portlet:renderURL var="defaultRenderURL" />

Random double: <c:out value="${randomDataBean.randomDouble}" />

<br />

Today: <fmt:formatDate value="${randomDataBean.today}" dateStyle="LONG" />

<br />

<c:if test="${not empty mySampleFormBean}">
	Form: <c:out value="${mySampleFormBean.myField}" />
</c:if>

<br />

PI: <c:out value="${PI}" />

<br />

Portlet configuration : <c:out value="${myConfigFieldPortletPreference}" />

<br />

<a href="<%=defaultRenderURL%>">Reset data & go back</a>