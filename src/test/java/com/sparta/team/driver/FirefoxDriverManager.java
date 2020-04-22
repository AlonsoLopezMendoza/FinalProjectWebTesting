package com.sparta.team.driver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;

public class FirefoxDriverManager extends DriverManager {

    private GeckoDriverService gkService;

    @Override
    public void startService() {
        if (null == gkService) {
            try {
                gkService = new GeckoDriverService.Builder()
                        .usingDriverExecutable(new File("geckodriver.exe"))
                        .usingAnyFreePort()
                        .build();
                gkService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stopService() {
        if (null != gkService && gkService.isRunning())
            gkService.stop();
    }

    @Override
    public void createDriver() {
        //DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        FirefoxOptions options = new FirefoxOptions();
        //options.addArguments("test-type");
        //capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        driver = new FirefoxDriver(gkService, new FirefoxOptions());


    }
}