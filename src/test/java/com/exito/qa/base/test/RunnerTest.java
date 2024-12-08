package com.exito.qa.base.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "StepDefinitions",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/index.html"
        },
        tags = "@ExitoTest",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true
)
public class RunnerTest {
}