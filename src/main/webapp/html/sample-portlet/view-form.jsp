<%@ include file="/html/init.jsp"%>

<portlet:actionURL var="sendFormURL">
	<portlet:param name="action" value="actionSample"/>
</portlet:actionURL>

<portlet:renderURL var="renderRandomDataURL">
	<portlet:param name="render" value="renderSample"/>
</portlet:renderURL>

<portlet:resourceURL var="ajaxEndpointURL" id="ajaxTest" />

<h1>Sample portlet : form</h1>

<form:form action="<%=sendFormURL %>" modelAttribute="mySampleFormBean">
	<form:input type="text" path="myField" title="My Field" />
	
	<input type="submit" />
</form:form> 

<br />

<a href="<%=renderRandomDataURL%>">Go to random data page</a>

<br />

<button onClick="ajaxGet()">Ajax Test</button>

<br />

PI: <c:out value="${PI}" />

<br />

Portlet configuration : <c:out value="${myConfigFieldPortletPreference}" />
 
<script type="text/javascript">
/*<![CDATA[*/
	function ajaxGet() {
		var url = '${ajaxEndpointURL}';
		var r = new XMLHttpRequest();
		r.open("GET", url, true);
		r.onreadystatechange = function() {
			if(this.status == 200 && this.readyState == XMLHttpRequest.DONE) {
				alert("AJAX Response = "+r.responseText);
			}
		};
		r.send();
	}
/*]]>*/
</script>
