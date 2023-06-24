package extentSetup;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Given;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//import io.cucumber.java.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Date;

public class Extent {

    private static ExtentReports extent;
    static ExtentHtmlReporter htmlReporter;

    public static ExtentTest test;

    public static ExtentTest feature = null;
    public static ExtentTest scenario = null;

    public static void featureScenario(String featureText, String scenarioText)
    {
        feature = getExtent().createTest(Feature.class, featureText);
        scenario = feature.createNode(Scenario.class, scenarioText);
    }

    private  static Class c;
    public static void EXTENT_NODE(String gherkin, String scenario_msg, String status)
    {

        if(gherkin.equals("GIVEN"))
            c = Given.class;
        if(gherkin.equals("WHEN"))
            c = When.class;
        if(gherkin.equals("THEN"))
            c = Then.class;
        if(gherkin.equals("AND"))
            c = And.class;

        if (status.equals("PASS"))
            scenario.createNode(c, scenario_msg).pass("PASS");
        else if(status.equals("FAIL"))
            scenario.createNode(c, scenario_msg).pass("FAIL");
        else if(status.equals("SKIP"))
            scenario.createNode(c, scenario_msg).pass("SKIP");
    }
    public ExtentTest feature1 = extent.createTest(Feature.class, "Refund item");
    public ExtentTest scenario1 = feature1.createNode(Scenario.class, "Jeff returns a faulty microwave");

//    scenario1.createNode(Given.class, "Jeff has bought a microwave for $100").pass("pass");
    private static ExtentReports getExtent()
    {
        if(htmlReporter == null)
        {
            String extentReportPath = System.getProperty("user.dir")+"/test-output/extentReport/"
                    +new Date().toString().replace(" ", "_")+".html";
            htmlReporter = new ExtentHtmlReporter(extentReportPath);
            htmlReporter.config().setReportName("sushil");
            htmlReporter.config().setReportName("spotify report api testing");
            htmlReporter.config().setTheme(Theme.STANDARD);
   //         htmlReporter.config().setChartVisibilityOnOpen(true);
        }
        if(extent == null)
        {
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("environment", "L3");
            extent.setReportUsesManualConfiguration(true);
            extent.setSystemInfo("OS", System.getProperty("os.name"));
        }

        return extent;
    }

    public static void extentUtil(String... data)
    {
        test = getExtent().createTest(data[0], data[1]);
        test.log(Status.PASS, data[2]);


    }

    public static void extentUtil(String testName)
    {
        test = getExtent().createTest(testName);
        //test.log(Status.INFO, info);
        //test.log(Status.FAIL)

    }

    public static void INFO(String info)
    {
        test.log(Status.INFO, info);
    }

    public static void INFOFAIL(String info)
    {
        test.log(Status.FAIL, info);
    }

    public static void INFOPASS(String info)
    {
        test.log(Status.PASS, info);
    }
    public static void extentFlush()
    {
        extent.flush();
    }

}
