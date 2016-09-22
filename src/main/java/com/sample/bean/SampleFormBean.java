package com.sample.bean;

import java.io.Serializable;

/**
 * Bean used for displaying data in view-form.jsp
 *
 * @author Vianney FAIVRE
 */
public class SampleFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String myField = "";

	public SampleFormBean() {
	}

	public SampleFormBean(String myField) {
		this.myField = myField;
	}

	public String getMyField() {
		return myField;
	}

	public void setMyField(String myField) {
		this.myField = myField;
	}

	@Override
	public String toString() {
		return "SampleFormBean [myField=" + myField + "]";
	}
}