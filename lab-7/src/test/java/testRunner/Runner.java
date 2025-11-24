package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/google.feature",
        glue = {"steps", "support"},
        name = {"La cautarea \"Google converter services\" apare converterul sus"},
        plugin = {
                "pretty",
                "html:target/cucumber-report.html"
        },
        monochrome = true
)
public class Runner extends AbstractTestNGCucumberTests {
}
