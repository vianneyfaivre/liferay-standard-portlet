<%@ include file="/html/init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>" method="post" name="fm">
    <aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
    
    <aui:input type="text" name="preferences--myConfigField--" value="${myConfigField}" />
    
    <aui:button-row>
       <aui:button type="submit" />
    </aui:button-row>
</aui:form>