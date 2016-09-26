<%@ include file="/html/init.jsp"%>

<%-- ACTION URL that points to method SpringPortletMvcController#doActionSample --%>
<portlet:actionURL var="sendFormURL">
	<portlet:param name="action" value="actionSample"/>
</portlet:actionURL>

<%-- RENDER URL that points to method SpringPortletMvcController#doRenderActionSample --%>
<portlet:renderURL var="renderRandomDataURL">
	<portlet:param name="render" value="renderSample"/>
</portlet:renderURL>

<%-- RESOURCE URL that points to method SpringPortletMvcController#doResource --%>
<portlet:resourceURL var="ajaxEndpointURL" id="ajaxTest" />

<h1>Sample portlet : form</h1>

<%--
Here we are using Spring JSTL "form", the important attribute to notice here is "modelAttribute".

It's a java object, instantiated in the RENDER phase when displaying this JSP, this java object
is put in the Spring Model and available as "mySampleFormBean"
 --%>
<form:form action="<%=sendFormURL %>" modelAttribute="mySampleFormBean">
	
	<%-- 
	Once you set a modelAttribute in the parent form:form, you can access all fields of the bean.
	
	Here we are calling the getter SampleFormBean#getMyField	
	  --%>
	<form:input type="text" path="myField" title="My Field" />
	
	<%--
	When you send the form, it will go to the ACTION phase SpringPortletMvcController#doActionSample.
	
	Spring will automatically bind all fields of this form to a SampleFormBean object, have a look 
	to parameters of the method SpringPortletMvcController#doActionSample.
	 --%>
	<input type="submit" />
</form:form> 

<br />

<a href="<%=renderRandomDataURL%>">Go to random data page</a>

<br />

<button onClick="MyNamespace.SamplePortlet.testAjax('${ajaxEndpointURL}')">Ajax Test</button>

<br />

<%-- Displays the value set in the model thanks to the method SpringPortletMvcController#getPI --%>
PI: <c:out value="${PI}" />

<br />

<%-- Displays the value set in the model thanks to the method SpringPortletMvcController#getPortletPreference --%>
Portlet configuration : <c:out value="${myConfigFieldPortletPreference}" />
