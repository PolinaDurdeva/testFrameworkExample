package com.qandoo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    private static final String LOGIN_PAGE_URL = "/login";

    private static final String ID_USERNAME_INPUT = "username";

    private static final String ID_PASSWORD_INPUT = "password";

    private static final String LOGIN_BUTTON_SELECTOR = "#login button[type=\"submit\"]";

    @FindBy(id = ID_USERNAME_INPUT)
    private WebElement usernameInput;

    @FindBy(id = ID_PASSWORD_INPUT)
    private WebElement passwordInput;

    @FindBy(css = LOGIN_BUTTON_SELECTOR)
    private WebElement loginButton;

    public LoginPage() {
    }

    @Override
    String getSelfUrl() {
        return LOGIN_PAGE_URL;
    }

    /**
     * Makes the current page active in the browser
     */

    public void fillLoginCredentials(String username, String password){
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }
    public void pressLoginButton(){
        loginButton.click();
    }

}
