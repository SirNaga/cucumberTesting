package TestRunner;


import io.cucumber.junit.*;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
        glue = "StepDefiniton",
        plugin = { "pretty", "html:target/cucumber-reports.html" })
public class CucumberRunner {
}
