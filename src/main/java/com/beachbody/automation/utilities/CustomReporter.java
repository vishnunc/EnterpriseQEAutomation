package com.beachbody.automation.utilities;

import java.util.List;

import cucumber.api.event.ConcurrentEventListener;
import cucumber.api.event.EmbedEvent;
import cucumber.api.event.EventHandler;
import cucumber.api.event.EventPublisher;
import cucumber.api.event.TestCaseFinished;
import cucumber.api.event.TestCaseStarted;
import cucumber.api.event.TestRunFinished;
import cucumber.api.event.TestRunStarted;
import cucumber.api.event.TestSourceRead;
import cucumber.api.event.TestStepFinished;
import cucumber.api.event.TestStepStarted;
import cucumber.api.event.WriteEvent;


public class CustomReporter implements ConcurrentEventListener{

	@Override
	public void setEventPublisher(EventPublisher publisher) {
		publisher.registerHandlerFor(TestRunStarted.class, getTestRunStartedHandler());
        publisher.registerHandlerFor(TestSourceRead.class, getTestSourceReadHandler());
        publisher.registerHandlerFor(TestCaseStarted.class, getTestCaseStartedHandler());
        publisher.registerHandlerFor(TestStepStarted.class, getTestStepStartedHandler());
        publisher.registerHandlerFor(TestStepFinished.class, getTestStepFinishedHandler());
        publisher.registerHandlerFor(TestCaseFinished.class, getTestCaseFinishedHandler());
        publisher.registerHandlerFor(TestRunFinished.class, getTestRunFinishedHandler());
        publisher.registerHandlerFor(EmbedEvent.class, getEmbedEventHandler());
        publisher.registerHandlerFor(WriteEvent.class, getWriteEventHandler());

	}

	private EventHandler<WriteEvent> getWriteEventHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	private EventHandler<EmbedEvent> getEmbedEventHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	private EventHandler<TestRunFinished> getTestRunFinishedHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	private EventHandler<TestCaseFinished> getTestCaseFinishedHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	private EventHandler<TestStepFinished> getTestStepFinishedHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	private EventHandler<TestStepStarted> getTestStepStartedHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	private EventHandler<TestCaseStarted> getTestCaseStartedHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	private EventHandler<TestRunStarted> getTestRunStartedHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	private EventHandler<TestSourceRead> getTestSourceReadHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
