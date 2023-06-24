package com.spotify.propertyLoaders;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
public class AuthProperties
{
    static Properties authProperties;

    public static Properties getAuthProperties()
    {
        authProperties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"/src/test/java/properties/authProperty.properties"));
            authProperties.load(fis);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        return authProperties;

    }

}
