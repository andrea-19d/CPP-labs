package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {
                "src/test/resources/features/signup.feature",
                "src/test/resources/features/signin.feature",
                "src/test/resources/features/topbar.feature",
                "src/test/resources/features/cart.feature"
        },
        glue = {"steps", "support"},
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = true
)
public class Runner extends AbstractTestNGCucumberTests {

}
