package com.javafortesters.junit;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Kristof on 19/01/2017.
 */
public class connectionTest {
    public static void main(String[] args)
    {
        try {
            String resp = isLinkBroken();
            System.out.println(resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Boolean online()
    {
        try {
            if (isLinkBroken() == "OK") return true;
            else {
                return false;
            }
        }
        catch (Exception ex) {}
        return true;
    }
    public static String isLinkBroken() throws Exception
    {
        URL url = new URL("http://172.16.62.26/");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try
        {
            connection.connect();

            String response = connection.getResponseMessage();

            connection.disconnect();

            return response;

        }
        catch(Exception exp)
        {
            return exp.getMessage();
        }
    }

}
