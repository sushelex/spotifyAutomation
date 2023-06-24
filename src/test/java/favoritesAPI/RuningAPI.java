package favoritesAPI;

import ancestry.Playlists;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RuningAPI {
    @Test
    public void test()
    {
        Response response = given()
                .baseUri("https://3789d66d-4b9c-4a7e-9eeb-b0f56b926e62.mock.pstmn.io/favoritesFinal")
                .when()
                .get()
                .then()
                .log().body()
                .extract().response();
        FavoriteAPI p = response.as(FavoriteAPI.class);
    }
}
