package com.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target/rerun.txt",glue={"step.definitions"}, 
plugin = {"pretty", "html:target/cucumber-reports.html"})

public class FailedTestRunner {

}