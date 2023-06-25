package runners;

import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterSuite;

import static extentSetup.Extent.extentFlush;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = "stepDefinations", plugin = { "pretty", "html:target/cucumber-reports", "listener.StepListener"},
        monochrome = true, tags = "@win"

)
//@CucumberOptions(features = "src/test/java/features", glue = "stepDefinations", plugin = { "pretty", "html:target/cucumber-reports", "listener.StepListener", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class RunTest extends AbstractTestNGCucumberTests{
@AfterSuite
    public void teardown()
{
    extentFlush();
}
}
