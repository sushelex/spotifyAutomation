package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",
        glue = "stepDefinations"
        , plugin = { "pretty", "html:target/cucumber-reports", "listener.StepListener"}
        , tags = "@win"
)

public class JenkinRunner extends AbstractTestNGCucumberTests {


}
