package com.sample.controller;

import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Random;

import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.sample.bean.RandomDataBean;
import com.sample.bean.SampleFormBean;

/**
 * Spring Portlet MVC controller with samples of Action, Render & Resource phases. 
 * 
 * @author Vianney FAIVRE
 */
@Controller
@RequestMapping("VIEW")
public class SpringPortletMvcController {

	private static final Log LOGGER = LogFactoryUtil.getLog(SpringPortletMvcController.class);

	/**
	 * RENDER phase called by default, redirects to view-form.jsp
	 */
	@RenderMapping
	public String defaultHandler(Model m, PortletRequest portletRequest, PortletResponse portletResponse) {
		LOGGER.debug("default called");

		m.addAttribute("mySampleFormBean", new SampleFormBean("default value"));

		return "sample-portlet/view-form";
	}

	/**
	 * ACTION phase called when sending the form from view-form.jsp
	 * 
	 * Next RENDER phase is displaying view-random-data.jsp
	 */
	@ActionMapping(params = { "action=actionSample" })
	public void doActionSample(Model m, PortletRequest portletRequest, ActionResponse actionResponse, @ModelAttribute SampleFormBean mySampleFormBean,
			BindingResult result) {
		LOGGER.debug("actionSample called " + mySampleFormBean);

		m.addAttribute("mySampleFormBean", mySampleFormBean);

		actionResponse.setRenderParameter("render", "renderSample");
	}

	/**
	 * RENDER phase that displays view-random-data.jsp
	 */
	@RenderMapping(params = { "render=renderSample" })
	public String doRenderActionSample(Model m, PortletRequest portletRequest, PortletResponse portletResponse) {
		LOGGER.debug("renderSample called");

		m.addAttribute("randomDataBean", new RandomDataBean(new Random().nextDouble(), new Date()));

		return "sample-portlet/view-random-data";
	}

	/**
	 * RESOURCE phase that can be called from view-form.jsp
	 */
	@ResourceMapping("ajaxTest")
	public void doResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		LOGGER.debug("doResource called");

		JSONObject json = JSONFactoryUtil.createJSONObject();
		json.put("ajaxCallRes", "SUCCESS");

		OutputStream out = null;
		try {
			resourceResponse.setContentType("application/json");
			out = resourceResponse.getPortletOutputStream();
			StreamUtil.transfer(new ByteArrayInputStream(json.toString().getBytes("utf-8")), out);
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			try {
				if (out != null) {
					out.close();
				}
			} catch (Exception e) {
				LOGGER.error(e);
			}
		}
	}

	/**
	 * Let Math.PI be available in all JSP as variable "PI"
	 */
	@ModelAttribute("PI")
	public double getPI() {
		return Math.PI;
	}

	/**
	 * Let a portlet preference "myConfigField" be available in all JSP as variable "myConfigFieldPortletPreference"
	 */
	@ModelAttribute("myConfigFieldPortletPreference")
	public String getPortletPreference(RenderRequest renderRequest) {
		PortletPreferences portletPreferences = renderRequest.getPreferences();

		return portletPreferences.getValue("myConfigField", "Not set");
	}
}
