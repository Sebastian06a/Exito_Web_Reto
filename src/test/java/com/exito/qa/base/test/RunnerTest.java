package com.exito.qa.base.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",      // donde están tus .feature
        glue = "StepDefinitions",                      // paquete de steps
        plugin = {
                "pretty",
                "html:target/cucumber-reports/index.html"
        },
        tags = "@ExitoTest",                          // tag para identificar pruebas del Éxito
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true
)


public class RunnerTest {
        // La clase puede estar vacía, solo necesitamos las anotaciones
}
