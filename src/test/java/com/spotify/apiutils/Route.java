package com.spotify.apiutils;

import com.spotify.propertyLoaders.RequestParametersLoader;

public class Route
{
    public static final  String AUTH_BASE_URL = "https://accounts.spotify.com";
    public static final  String AUTH_TOKEN_PATH = "/api/token";

    public static final String BASE_URL = RequestParametersLoader.getParamProperties().getProperty("BASE_URI");
    public static final String BASE_PATH = RequestParametersLoader.getParamProperties().getProperty("BASE_PATH");
    public static final String APPLICATION_JSON = "application/json";

    public static final String PLAYLISTS = RequestParametersLoader.getParamProperties().getProperty("PLAYLISTS");
    public static final String ME = RequestParametersLoader.getParamProperties().getProperty("ME");
    //BROWSE API
    public static final String BROWSE = RequestParametersLoader.getParamProperties().getProperty("BROWSE");
    public static final String CATEGORIES = RequestParametersLoader.getParamProperties().getProperty("CATEGORIES");

    public static final String GIVEN = RequestParametersLoader.getParamProperties().getProperty("GIVEN");
    public static final String WHEN =RequestParametersLoader.getParamProperties().getProperty("WHEN");
    public static final String THEN =RequestParametersLoader.getParamProperties().getProperty("THEN");
    public static final String AND =RequestParametersLoader.getParamProperties().getProperty("AND");
    public static final String PASS =RequestParametersLoader.getParamProperties().getProperty("PASS");
    public static final String FAIL =RequestParametersLoader.getParamProperties().getProperty("FAIL");
    public static final String SKIP =RequestParametersLoader.getParamProperties().getProperty("SKIP");



    //BROWSE API

}
