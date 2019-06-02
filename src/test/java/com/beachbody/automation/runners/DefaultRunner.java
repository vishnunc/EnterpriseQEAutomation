package com.beachbody.automation.runners;




import cucumber.api.CucumberOptions;


@CucumberOptions(glue = {"com.beachbody.automation.stepdefs","com.beachbody.automation.hooks"}, plugin = {"json:target/json-cucumber-reports/cukejson.json",
		"testng:target/testng-cucumber-reports/cuketestng.xml",
		"html:target/reports/htmlreport","json:target/cucumber.json","html:target/site/cucumber-pretty"}, features = "src/test/resources/features/e2e/TCID_C6209824.feature")


public class DefaultRunner extends AbstractTestNGCucumberParallelTests {

	
	
}
