package com.sparta.team.driverManager;

import com.sparta.team.driver.ChromeDriverManager;
import com.sparta.team.driver.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public DriverFactory() {
    }

    public static WebDriver getWebDriver(String driverType){
        WebDriver newWebDriver;
        switch (driverType) {
            case "CHROME":
                newWebDriver = new ChromeDriver();
                break;
            case "FIREFOX":
                newWebDriver = new FirefoxDriver();
                break;
            default:
                System.out.println("Defaulted to chrome");
                newWebDriver = new ChromeDriver();
                break;
        }


        return newWebDriver;
    }
}
