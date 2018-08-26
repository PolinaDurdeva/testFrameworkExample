package com.qandoo;


import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {
                "pretty",
                "html:target/cucumber-html",
                "json:target/cucumber-report.json"
        },
        features = {"src/test/resources"}
)
public class TestRunner {
}
