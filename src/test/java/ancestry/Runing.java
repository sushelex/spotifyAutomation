package ancestry;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Runing {
    @Test
    public void test()
    {
        Response response = given()
                .baseUri("https://3789d66d-4b9c-4a7e-9eeb-b0f56b926e62.mock.pstmn.io/favorites")
                .when()
                .get()
                .then()
                .log().body()
                .extract().response();
        Playlists p = response.as(Playlists.class);
    }
}
