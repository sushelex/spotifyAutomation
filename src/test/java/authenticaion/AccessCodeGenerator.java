package authenticaion;

import com.spotify.apiutils.Builders;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AccessCodeGenerator
{


    private static Response accessCodeGenerator() throws FileNotFoundException {
        return given(Builders.getAccessTokenRequestSpecification())
                .post()
                .then()
                .extract().response();

    }


    public static String getAccessToken() throws FileNotFoundException {
        String token =  accessCodeGenerator().path("access_token");
        System.out.println("token is>>"+token);
        return "Bearer "+token;
    }

}
