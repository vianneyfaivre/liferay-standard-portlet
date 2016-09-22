<%@ include file="/html/init.jsp"%>

<%-- Without passing any parameters, this RENDER URL will call the default render method : SpringPortletMvcController#defaultHandler --%>
<portlet:renderURL var="defaultRenderURL" />

<%-- Calling RandomDataBean#getRandomDouble --%>
Random double: <c:out value="${randomDataBean.randomDouble}" />

<br />

<%-- Calling RandomDataBean#getToday --%>
Today: <fmt:formatDate value="${randomDataBean.today}" dateStyle="LONG" />

<br />

<%-- Calls the method SampleFormBean#getMyField if the bean called "mySampleFormBean" has been put in Spring Model during RENDER phase --%>
<c:if test="${not empty mySampleFormBean}">
	Form: <c:out value="${mySampleFormBean.myField}" />
</c:if>

<br />

<%-- Displays the value set in the model thanks to the method SpringPortletMvcController#getPI --%>
PI: <c:out value="${PI}" />

<br />

<%-- Displays the value set in the model thanks to the method SpringPortletMvcController#getPortletPreference --%>
Portlet configuration : <c:out value="${myConfigFieldPortletPreference}" />

<br />

<a href="<%=defaultRenderURL%>">Reset data & go back</a>