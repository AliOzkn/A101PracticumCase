package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        features = {"src/test/java/A101Practicum.feature"},
        glue = {"stepDefinition"},
        plugin = {"pretty",
                "html:target/cucumber-reports/A101-PracticumCase-Report.html"},
        dryRun = false,
        monochrome = true
)


public class Runner extends AbstractTestNGCucumberTests {
}
