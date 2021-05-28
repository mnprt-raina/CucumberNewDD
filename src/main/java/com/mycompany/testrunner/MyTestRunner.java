package com.mycompany.testrunner;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"features"}
		,glue = {"StepDefinitions"},
				dryRun = true
		)

public class MyTestRunner 
{
	
}