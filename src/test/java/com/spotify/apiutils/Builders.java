package com.spotify.apiutils;

import com.spotify.propertyLoaders.AuthProperties;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import tech.grasshopper.filter.ExtentRestAssuredFilter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static authenticaion.AccessCodeGenerator.getAccessToken;
import static com.spotify.apiutils.AuthFormFeatures.*;
import static com.spotify.apiutils.Headers.AUTHORIZATION;
import static com.spotify.apiutils.Route.*;
import static com.spotify.propertyLoaders.AuthProperties.getAuthProperties;
import static com.spotify.propertyLoaders.RequestParametersLoader.getParamProperties;

public class Builders {

    private static RequestSpecification authRequestSpecification;
    private static RequestSpecification requestSpecification;
    private static ResponseSpecification playlistResponseSpecification;

    private static PrintStream printStream;


    public static ResponseSpecification getPlaylistResponseSpecification() throws FileNotFoundException {
        printStream = new PrintStream(new FileOutputStream(System.getProperty("user.dir")+"/apiLogs/request_responselogs.log"));
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectStatusCode(200);
//                        .expectContentType(APPLICATION_JSON);


        playlistResponseSpecification = responseSpecBuilder.build();

        return playlistResponseSpecification;

    }

    public static RequestSpecification getRequestSpecification() throws FileNotFoundException
    {
        printStream = new PrintStream(new FileOutputStream(System.getProperty("user.dir")+"/apiLogs/request_responselogs.log"));
        System.out.println(BASE_URL+BASE_PATH);
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(BASE_URL)
                .setBasePath(BASE_PATH)
                .addHeader(AUTHORIZATION, getAccessToken())
                .addFilter(RequestLoggingFilter.logRequestTo(printStream))
                .addFilter(new ExtentRestAssuredFilter());
//                .addFilter(ResponseLoggingFilter.logResponseTo(printStream));
        requestSpecification = requestSpecBuilder.build();
        return requestSpecification;
    }
    public static RequestSpecification getAccessTokenRequestSpecification() throws FileNotFoundException {
        printStream = new PrintStream(new FileOutputStream(System.getProperty("user.dir")+"/apiLogs/request_responselogs.log"));
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(AUTH_BASE_URL)
                .setBasePath(AUTH_TOKEN_PATH)
                .setContentType(ContentType.URLENC)
                .addFormParams(getForm())
                .addFilter(RequestLoggingFilter.logRequestTo(printStream));


        authRequestSpecification = requestSpecBuilder.build();
        return authRequestSpecification;
    }

    private static Map<String, String> getForm()
    {
        Map<String, String> form = new HashMap<>();

        form.put(CLIENT_ID, getAuthProperties().getProperty("client_id"));
        form.put(CLIENT_SECRET, getAuthProperties().getProperty("client_secret"));
        form.put(GRANT_TYPE, getAuthProperties().getProperty("grant_type"));
        form.put(REFRESH_TOKEN, getAuthProperties().getProperty("refresh_token"));

        return form;
    }
}
