package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = { "src/test/resources/features" },
        glue = "step_definitions",
        tags = "@Checkers"/*,
        plugin = {"json:target/cucumber.json", "pretty", "html:target/cucumber-checkers-report.html"},
        publish = true*/

        // uncomment above to create Master Thought test reports
)
public class CheckersRunner /*extends AbstractTestNGCucumberTests*/ {
}
