package com.nuna.testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions (
		
		features = "@target/failedscenarios/failed.txt",
		glue = "com.nuna.steps"
		
		
		)

public class FailedTestRunner {
	
}
