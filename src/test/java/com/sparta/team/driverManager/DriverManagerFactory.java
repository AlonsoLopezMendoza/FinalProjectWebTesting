package com.sparta.team.driverManager;


import com.sparta.team.driver.ChromeDriverManager;
import com.sparta.team.driver.DriverManager;
import com.sparta.team.driver.FirefoxDriverManager;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type) {

        DriverManager driverManager;

        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;
    }
}
