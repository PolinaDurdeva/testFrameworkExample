package com.qandoo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Contains the web driver singleton used in all tests.
 */
public class DriverHolder {

    private static WebDriver driver;

    /**
     * Gets the current driver
     * @return current driver instance
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Replaces current driver with new driver instance
     */
    public static void initializeDriver() {
        driver = new ChromeDriver();
    }

    /**
     * Closes the current driver
     */
    public static void closeDriver(){
        driver.close();
    }
}
