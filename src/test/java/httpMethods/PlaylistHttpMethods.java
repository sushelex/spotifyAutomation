package httpMethods;

import io.restassured.response.Response;

import java.io.FileNotFoundException;

import static com.spotify.apiutils.Builders.getPlaylistResponseSpecification;
import static com.spotify.apiutils.Builders.getRequestSpecification;
import static io.restassured.RestAssured.given;

public class PlaylistHttpMethods {

    public static void POST()
    {

    }

    public static Response GET(String reqString1, String reqString2) throws FileNotFoundException {
        System.out.println(reqString1+reqString2);
        return given().spec(getRequestSpecification())
                .when()
                .get(reqString1+reqString2)
                .then()
                .spec(getPlaylistResponseSpecification())
                .log().all()
                .extract()
                .response();
    }

    public static Response GET(String endpoint) throws FileNotFoundException {

        return given().spec(getRequestSpecification())
                .when()
                .get(endpoint)
                .then()
                .spec(getPlaylistResponseSpecification())
                .log().all()
                .extract()
                .response();
    }
}
