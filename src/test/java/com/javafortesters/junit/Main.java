package com.javafortesters.junit;

import sun.rmi.runtime.Log;

/**
 * Created by Kristof on 19/01/2017.
 */
public class Main {
    public static void main(String[] args)
    {
        /*MyFirstTest sut = new MyFirstTest();
        sut.WebDriverTest();
        sut.ChromeDriverTest();*/
        LoginTest t = new LoginTest();
        t.testLogin();
    }

}
