package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java",
        glue = {"steps", "helper", "Models", "pages", "context", "api_Steps"},
        plugin = {"pretty", "html:target/CucumberHtmlReport.html", "json:target/cucumber.json"},
        monochrome = true,
        tags = "@two" 
        )// Run only the scenario with this tag
        
public class TestRunner {
}