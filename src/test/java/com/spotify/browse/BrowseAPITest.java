package com.spotify.browse;

import io.restassured.response.Response;

import java.io.FileNotFoundException;

import static httpMethods.BrowseHttpMethods.browseAllCategoriesGET;

public class BrowseAPITest
{
    public static Response testBrowseCategories() throws FileNotFoundException {
        Response response = browseAllCategoriesGET();
        return response;

    }
}
