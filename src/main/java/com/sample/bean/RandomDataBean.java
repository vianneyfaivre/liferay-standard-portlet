package com.sample.bean;

import java.io.Serializable;
import java.util.Date;

public class RandomDataBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private double randomDouble;
	private Date today;

	public RandomDataBean(double randomDouble, Date today) {
		this.randomDouble = randomDouble;
		this.today = today;
	}

	public double getRandomDouble() {
		return randomDouble;
	}

	public Date getToday() {
		return today;
	}

	@Override
	public String toString() {
		return "RandomDataBean [randomDouble=" + randomDouble + ", today=" + today + "]";
	}
}
