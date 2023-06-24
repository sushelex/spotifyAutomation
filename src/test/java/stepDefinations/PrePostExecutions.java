package stepDefinations;

import APICommonFunctios.APIRootBehavior;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import tech.grasshopper.pdf.section.scenario.ScenarioDisplay;


import static extentSetup.Extent.extentUtil;
import static extentSetup.Extent.scenario;

public class PrePostExecutions
{
    @Before
    public void preExecutions(Scenario scenario)
    {
        APIRootBehavior.scenario = scenario;
        System.out.println("inside @Before");
        //extentUtil(scenario.getName());
        System.out.println("scenario.getId()>>>"+scenario.getId());
        System.out.println("scenario.getUri()>>>"+scenario.getUri());
        System.out.println("scenario.getName()>>>"+scenario.getName());


    }

    @AfterStep
    public void afterStepsTest(Scenario scenario)
    {
//        String str = "<h1>"+scenario.getName()+"</h1>";
//        scenario.log(str);

    }

    @BeforeStep
    public static void getScenario(Scenario scenario)
    {
        APIRootBehavior.scenario = scenario;
    }


    public static void testScenario(Scenario scenario, String response)
    {
        scenario.log("this response is from <p color:red;>"+response+"</p>");
        scenario.log("<p color:blue;>"+response+"</p>");
        scenario.log("<h1>"+response+"</h1>");
        scenario.log("<body>"+response+"</body>");
        scenario.log("<h1>"+response+"</h1>");
    }

    public static void reportApiResponse(String response)
    {
       // System.out.println(response.split("\n"));
        String[] ss = response.split("\n");
        String s = "";
        for(String s1:ss)
            s = s+s1;
//        APIRootBehavior.scenario.log("<textarea style=\"color:gold>"+s+"</textarea>");
        APIRootBehavior.scenario.log(s);
        APIRootBehavior.scenario.log("with body tag and response");
        APIRootBehavior.scenario.log("<body>"+response+"</body>");
        APIRootBehavior.scenario.log("with body tag and s");
        APIRootBehavior.scenario.log("<body>"+s+"</body>");
    }

    public static void REPORT_API_RESPONSE(String response)
    {
        ExtentCucumberAdapter.addTestStepLog("this is from ExtentCucumberAdapter");
        //ExtentCucumberAdapter.getCurrentStep().generateLog(scenario.getStatus(), "ExtentCucumberAdapter.getCurrentStep().generateLog");
        ExtentCucumberAdapter.addTestStepLog(response);
        //<button id="data" onclick="fun()">try this</button>

//        APIRootBehavior.scenario.log("<p id=\"response1\" style=\"background-color:Green;\">this is response</p>");

//        APIRootBehavior.scenario.log("<pre \"background-color:MediumSeaGreen;\">"+response+"</pre>");

    }

    public static void REPORT_API_HEADERS(String header)
    {
        APIRootBehavior.scenario.log("<pre>"+header+"</pre>");
    }

    public static void REPORT_LOG(String log)
    {
        APIRootBehavior.scenario.log("<pre>"+log+"</pre>");
    }

}
