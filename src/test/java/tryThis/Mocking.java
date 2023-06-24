package tryThis;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Mocking {


    @Test
    public void testFavorites()
    {
   //favorites
        Response response = given()
                .baseUri("https://3789d66d-4b9c-4a7e-9eeb-b0f56b926e62.mock.pstmn.io/favorites")
                .when()
                .get()
                .then()
                .log().body()
                .extract().response();

//        Favorites favorites = response.as(Favorites.class);
        Favorites favorites = response.as(Favorites.class);

    }
 //   @Test
    public void testMapList()
    {
        Response response = given()
                .baseUri("https://3789d66d-4b9c-4a7e-9eeb-b0f56b926e62.mock.pstmn.io/listMap")
                .when()
                .get()
                .then()
                .log().body()
                .extract().response();

        ListMap sts = response.as(ListMap.class);
    }
//    @Test
    public void testComplex()
    {
        Response response = given()
                .baseUri("https://3789d66d-4b9c-4a7e-9eeb-b0f56b926e62.mock.pstmn.io/listMap")
                .when()
                .get()
                .then()
                .log().body()
                .extract().response();

        Students sts = response.as(Students.class);
    }
}
