package com.beachbody.automation.runners;

import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;


import com.beachbody.automation.utilities.ExamplesBuilder;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import gherkin.events.PickleEvent;
import gherkin.pickles.Pickle;
import gherkin.pickles.PickleTable;


public abstract class AbstractTestNGCucumberParallelTests extends AbstractTestNGCucumberTests{
	
	private static long duration;
	
	@BeforeClass
	public void before() {
		
		duration = System.currentTimeMillis();
		System.out.println("Thread Id  | Scenario Num       | Step Count");
		
	}
	
	@AfterClass
	public void after() {
		duration = System.currentTimeMillis() - duration;
		System.out.println("DURATION - "+ duration);
		
	}
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		
		return super.scenarios();
	}
	@Override
	@Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
	public void runScenario(PickleEventWrapper pickleWrapper, CucumberFeatureWrapper featureWrapper) throws Throwable{
		//System.out.println("this is something"+pickleWrapper.getPickleEvent().pickle.getSteps().get(0).getText());
		PickleEvent pEvent = pickleWrapper.getPickleEvent();
		ExamplesBuilder example = new ExamplesBuilder(pEvent);
		List<PickleEvent> pEvents = example.createPickle();
		for(PickleEvent pE:pEvents){
			PickleEventWrapper yo = new ExamplesBuilder(pE);
			super.runScenario(yo, featureWrapper);
		}
		
		
		
	}
	
	
	
}