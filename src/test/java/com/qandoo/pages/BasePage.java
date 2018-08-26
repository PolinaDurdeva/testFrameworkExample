package com.qandoo.pages;
import com.qandoo.DriverHolder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Represents a page which can perform
 * some actions common for all other application pages using web driver
 */
public abstract class BasePage {

    protected final static String BASE_URL = "http://the-internet.herokuapp.com";

    protected WebDriver driver;

    BasePage() {
        this.driver = DriverHolder.getDriver();
        PageFactory.initElements(driver, this);
    }

    abstract String getSelfUrl();

    /**
     * Makes the current page opened in the browser
     */
    public void openPage(){
        driver.get(BASE_URL + getSelfUrl());
    }

}
