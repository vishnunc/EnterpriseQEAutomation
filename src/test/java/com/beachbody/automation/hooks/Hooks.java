package com.beachbody.automation.hooks;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.beachbody.automation.common.World;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.And;

public class Hooks{
	
	private String scenDesc;
	private World world;
	
	public Hooks(World world){
		this.world=world;
	}
	@Before
	public void before(Scenario scenario) {
		this.scenDesc = scenario.getName();
		world.setBrowser(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser"));
		world.setLocale(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("locale"));
		world.setDriverType(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("driverType"));
		world.getDriver();
		 
	}
	
	@BeforeStep
	public void beforeStep() throws InterruptedException {
		Thread.sleep(2000);
	}
	
	@AfterStep
	public void afterStep() throws InterruptedException {
		Thread.sleep(2000);
	}
	@After
	public void after(Scenario scenario){
		this.scenDesc=scenario.getName();
		System.out.println("im coming out of scenario "+this.scenDesc+world.getBrowser()+world.getLocale());
		
		//&&&&&&&&&&&&&&&&&&&&&&&
		embedScreenshot(scenario);
		//&&&&&&&&&&&&&&&&&&&&&&&
		
		  try { 
			  System.out.println("Closing browser"); 
			  if(this.world.driver!= null){
		  
				  System.out.println("Into If Closing browser");
		  
		  
				  //this.world.driver.quit(); System.out.println("Into If Closing browser");
		  } }catch(Throwable e) { System.out.println("Unable to quit the driver");
		  e.printStackTrace(); }
		 
		
	}
	
	public void embedScreenshot(Scenario scenario)  {
	    if (scenario.isFailed()) {
	    	
				
			try {
				final byte[] screenshot = ((TakesScreenshot) this.world.driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			}
			catch(Exception e) {
				System.out.println("Exception thrown while attaching screenshot");
				}
	        
	    }
	}  
	

}