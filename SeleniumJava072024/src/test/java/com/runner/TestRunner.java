package com.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",glue={"step.definitions"}, 
plugin = {"pretty", "html:target/cucumber-reports.html", "rerun:target/rerun.txt" },tags = "@dryrun and not @smoke")

public class TestRunner {

}