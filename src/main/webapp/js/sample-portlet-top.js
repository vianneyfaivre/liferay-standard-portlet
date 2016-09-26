var MyNamespace = MyNamespace || {};

MyNamespace.SamplePortlet = MyNamespace.SamplePortlet || {
	
	/**
	 * This function makes an ajax GET call to the provided endpoint.
	 * 
	 * @param endpointURL : URL of the endpoint to call
	 */
	testAjax: function MyNamespace_SamplePortlet_testAjax(endpointURL) {
		var r = new XMLHttpRequest();
		r.open("GET", endpointURL, true);
		r.onreadystatechange = function() {
			if(this.status == 200 && this.readyState == XMLHttpRequest.DONE) {
				alert("AJAX Response = "+r.responseText);
			}
		};
		r.send();
	}
};

console.log('sample-portlet-top.js loaded');