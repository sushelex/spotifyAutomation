package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import loggingProcess.LogOperations;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import pojos.Playlists;

import java.io.FileNotFoundException;
import java.lang.reflect.Method;

import static com.spotify.apiutils.Route.PLAYLISTS;
import static extentSetup.Extent.extentUtil;
import static httpMethods.PlaylistHttpMethods.GET;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class GetPlaylistsSteps {

    private static Response response;
    private Playlists playlists;

    LogOperations log = new LogOperations();;
    @BeforeClass
    public void reportSetup()
    {
        System.setProperty("org.uncommons.reportng.escape-output", "false");
//        log = new LogOperations();
    }
    @Given("When user send the get request to playlists")
    public void when_user_send_the_get_request_to_playlists() throws FileNotFoundException, NoSuchMethodException {
        response = GET(PLAYLISTS,"/1eDOHIh63vwCqdi6X7LHUI");
        playlists = response.as(Playlists.class);
//        Reporter.log(this.getClass().getName()+" "+this.getClass().getEnclosingMethod().getName());
        Reporter.log("Class name "+this.getClass().getName());
//        Reporter.log("Class name "+this.getClass().getEnclosingMethod().getName());
        Reporter.log("stack trace class name "+Thread.currentThread().getStackTrace()[1].getClassName());
        Reporter.log("stack trace method name "+Thread.currentThread().getStackTrace()[1].getMethodName());
        Reporter.log("PLAYLISTS "+PLAYLISTS);
        Reporter.log(response.asString());
        log.logInfoFile(response.asString());
    }
    @Then("response should be received with status code200")
    public void response_should_be_received_with_status_code200() {
        Reporter.log("stack trace class name "+Thread.currentThread().getStackTrace()[1].getClassName());
        Reporter.log("stack trace method name "+Thread.currentThread().getStackTrace()[1].getMethodName());
        Reporter.log(String.valueOf(response.getStatusCode()));
        assertThat(response.getStatusCode(), equalTo(200));
        log.logInfoFile(String.valueOf(response.getStatusCode()));
    }
    @Then("playlist name should be boom...boom....boom")
    public void playlist_name_should_be_boom_boom_boom()
    {
        Reporter.log("stack trace class name "+Thread.currentThread().getStackTrace()[1].getClassName());
        Reporter.log("stack trace method name "+Thread.currentThread().getStackTrace()[1].getMethodName());
        Reporter.log("playlists name "+playlists.getName());

        assertThat(playlists.getName(), equalTo("boom_boom_boom"));

    }
}
