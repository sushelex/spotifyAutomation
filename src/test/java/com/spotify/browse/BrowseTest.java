package com.spotify.browse;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.browse.Browse;

import java.io.FileNotFoundException;

import static com.spotify.apiutils.Route.BROWSE;
import static com.spotify.apiutils.Route.CATEGORIES;
import static httpMethods.PlaylistHttpMethods.GET;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class BrowseTest
{
    @Test(enabled = false)
    public void testGetCategories() throws FileNotFoundException {
        Response response = GET(BROWSE, CATEGORIES);
        Browse browse = response.as(Browse.class);
        assertThat(response.getStatusCode(), equalTo(200));
        assertThat(browse.getCategories().getItems().get(0).getId(), equalTo("toplists"));
        assertThat(browse.getCategories().getItems().get(19).getName(), equalTo("Netflix"));
    }

    @Test
    public void testGetCategories_id() throws FileNotFoundException {
        Response response = GET(CATEGORIES, "/0JQ5DAqbMKFGvOw3O4nLAf");
        System.out.println(response.asString());
        assertThat(response.getStatusCode(), equalTo(200));

    }
}
