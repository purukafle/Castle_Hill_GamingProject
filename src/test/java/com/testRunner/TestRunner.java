package com.testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"com.stepDefinitions"},
		monochrome = true,
		plugin = {"pretty",
				"html:target/htmlReports",
				"json:target/jsonReports/jsonReport-json",
				"junit:target/junitReports/junitReport-xml"
			}
)
public class TestRunner {
	
	
	public static void generateExtentReport() {
		System.out.println("print result....");
		
	}
}