package com.spotify.propertyLoaders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class RequestParametersLoader
{
    static Properties paramProperties;

    public static Properties getParamProperties()
    {
        paramProperties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"/src/test/java/properties/requestParameters.properties"));
            paramProperties.load(fis);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        return paramProperties;

    }
}
