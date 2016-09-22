package com.sample.controller;

import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;

public class SamplePortletConfigurationController extends DefaultConfigurationAction {

	@Override
	public String render(PortletConfig portletConfig, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {

		PortletPreferences portletPreferences = renderRequest.getPreferences();

		// Get the actual configuration
		String myConfigField = portletPreferences.getValue("myConfigField", "");

		// Set variables into the request
		renderRequest.setAttribute("myConfigField", myConfigField);

		return super.render(portletConfig, renderRequest, renderResponse);
	}
}
