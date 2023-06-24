package httpMethods;

import io.restassured.response.Response;

import java.io.FileNotFoundException;

import static com.spotify.apiutils.Builders.getRequestSpecification;
import static com.spotify.apiutils.Route.BROWSE;
import static com.spotify.apiutils.Route.CATEGORIES;
import static io.restassured.RestAssured.given;

public class BrowseHttpMethods
{
    public static Response browseAllCategoriesGET() throws FileNotFoundException {
        return given().spec(getRequestSpecification())
                .when()
                .get(BROWSE+CATEGORIES)
                .then()
                .extract()
                .response();
    }
}
