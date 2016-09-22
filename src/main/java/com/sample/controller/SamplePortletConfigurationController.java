package com.sample.controller;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;

/**
 * Class that handles the configuration mode of the portlet. 
 * 
 * Have a look to its superclass to understand how the preferences are stored in Liferay DB.
 *
 * @author Vianney FAIVRE
 */
public class SamplePortletConfigurationController extends DefaultConfigurationAction {

	/**
	 * This method is called when portlet-configuration.jsp is displayed
	 */
	@Override
	public String render(PortletConfig portletConfig, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {

		PortletPreferences portletPreferences = renderRequest.getPreferences();

		// Get the actual configuration
		String myConfigField = portletPreferences.getValue("myConfigField", "");

		// Set variables into the request
		renderRequest.setAttribute("myConfigField", myConfigField);

		return super.render(portletConfig, renderRequest, renderResponse);
	}

	/**
	 * It's not necessary to override this method if you use the specific naming convention proposed by Liferay.
	 * 
	 * Have a look to portlet-configuration.jsp to know what is this naming convention.
	 */
	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
}
