package com.spotify.playlists;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.Playlists;

import java.io.FileNotFoundException;
import java.io.IOException;

import static com.spotify.apiutils.Builders.getPlaylistResponseSpecification;
import static com.spotify.apiutils.Builders.getRequestSpecification;
import static com.spotify.apiutils.Route.ME;
import static com.spotify.apiutils.Route.PLAYLISTS;
import static com.spotify.propertyLoaders.RequestParametersLoader.getParamProperties;
import static httpMethods.PlaylistHttpMethods.GET;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

//import static org.hamcrest.MatcherAssert.assertThat;
public class ValidatePlaylists
{
    @Test
    public void testGetPlaylists() throws FileNotFoundException {
        Response response = given().spec(getRequestSpecification())
                .when()
                .get(getParamProperties().getProperty("PLAYLISTS")+"/"+"1eDOHIh63vwCqdi6X7LHUI")
                .then().log().all()
                .spec(getPlaylistResponseSpecification())
                .extract().response();

        Playlists playlists = response.as(Playlists.class);
        System.out.println(playlists.getName());
        assertThat(playlists.getName(), equalTo("boom_boom_boom"));

    }

    @Test
    public void testPlaylists_id() throws IOException
    {
        GET(PLAYLISTS,"/1eDOHIh63vwCqdi6X7LHUI");
    }

    @Test
    public void testGetPlaylistsAll() throws IOException
    {
        GET(ME, PLAYLISTS);
    }

}
