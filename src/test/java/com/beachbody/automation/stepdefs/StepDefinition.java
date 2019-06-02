package com.beachbody.automation.stepdefs;



import org.testng.Reporter;

import com.beachbody.automation.common.World;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.And;

public class StepDefinition{
	
	private String scenDesc;
	private World world;
	
	public StepDefinition(World world){
		this.world=world;
	}
	
	@And("this is {string} step")
	public void step(String stepNum) {
		
		System.out.format("Thread %2d -> %18s - %-6s STEP\n", Thread.currentThread().getId(), scenDesc, stepNum);
	}
	
	@And("this is {string} step and {string} step")
	public void this_is_step_and_step(String stepSum, String stepNum) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.format("Thread %2d -> %18s - %-6s STEP %-6s\n", Thread.currentThread().getId(), scenDesc, stepNum,stepSum);
	}
	
	
}