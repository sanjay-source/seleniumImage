package resources;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/feature",
glue = { "stepDefinitions" },
tags = { "@Test" },
monochrome=true,
strict=false,
plugin = { "pretty" })

public class TestRunner extends AbstractTestNGCucumberTests {

}
