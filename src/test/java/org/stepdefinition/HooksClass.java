package org.stepdefinition;


import org.adactin.utilities.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksClass extends BaseClass {
	
	@Before
	public void beforeScenario() {
		System.out.println("before scenario");
	}
	
	@After
	public void afterScenario() {
		System.out.println("After scenario");
		driver.close();
	}

}
