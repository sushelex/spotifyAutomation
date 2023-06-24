package stepDefinations;

import com.spotify.apiutils.Route;
import static APICommonFunctios.APIRootBehavior.scenario;
import com.spotify.statuscode.StatusCode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Reporter;

import java.io.FileNotFoundException;

import static com.spotify.apiutils.Route.*;
import static com.spotify.browse.BrowseAPITest.testBrowseCategories;
import static extentSetup.Extent.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static stepDefinations.PrePostExecutions.*;

public class BrowseSteps {
    private static Response response;

    @Given("when environment is up and working")
    public void when_environment_is_up_and_working()
    {
 //       featureScenario("test feature", "test scenario");
//        extentUtil(Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getMethodName(), "inside the env setup method");
//        INFO("INFO::inside setup environment");
//        EXTENT_NODE(GIVEN,Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " "), PASS);
        Reporter.log(Thread.currentThread().getStackTrace()[1].getMethodName());
//        testScenario(scenario, "from when_environment_is_up_and_working");



    }
    @When("user send the get request to get browse end point")
    public void user_send_the_get_request_to_get_browse_end_point() throws FileNotFoundException {
        response = testBrowseCategories();
 //       extentUtil(Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getMethodName(), response.asString());
//        INFO("INFO::"+response.asString());
//        EXTENT_NODE(WHEN,Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " "), PASS);
//        Reporter.log(Thread.currentThread().getStackTrace()[1].getMethodName());
        Reporter.log(response.asString());

    }
    @Then("user should receive the response code {int}.")
    public void user_should_receive_the_response_code(Integer int1) {
 //      extentUtil(Thread.currentThread().getStackTrace()[1].getMethodName(), Thread.currentThread().getStackTrace()[1].getMethodName(), response.getStatusCode()+"");
 //      INFO("status code is::"+response.getStatusCode());
        Reporter.log(Thread.currentThread().getStackTrace()[1].getMethodName());
        Reporter.log(response.getStatusCode()+"");
//        reportApiResponse(response.asString());
//        REPORT_API_HEADERS(response.headers().get("-control-allow-headers").getName());
        REPORT_API_RESPONSE(response.asString());
//        System.out.println(1/0);
//        assertThat(response.getStatusCode(), equalTo(int1));
        try{
            assertThat(String.valueOf(response.getStatusCode()), equalTo(String.valueOf(int1)));
            assertThat(response.getStatusCode(), equalTo(int1));
//            EXTENT_NODE(Route.THEN,Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " "), PASS);
        }
        catch(Throwable t)
        {
//            INFOFAIL(t.getMessage());
//            EXTENT_NODE(Route.THEN,Thread.currentThread().getStackTrace()[1].getMethodName().replace("_", " "), FAIL);
            throw new RuntimeException(t.getMessage());
        }

    }

    @Then("print the response")
    public void printTheResponse() {
        System.out.println(response.asString());
    }
}
