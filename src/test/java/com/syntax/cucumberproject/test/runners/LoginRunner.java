package com.syntax.cucumberproject.test.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"C:\\Users\\MKHAN\\eclipse-workspace\\CucumberProject\\src\\test\\resources\\features\\Login.feature"}
				,glue= {"C:\\Users\\MKHAN\\eclipse-workspace\\CucumberProject\\src\\test\\java\\com\\syntax\\cucumberproject\\test\\stepDefinitions\\LoginSteps.java"}
				,monochrome=true
				,plugin= {"html:test-output"}
				,dryRun=false)

public class LoginRunner {
	
}
