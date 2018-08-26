package com.qandoo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

/**
 * Page, containing user avatars which can be hovered
 */
public class HoversPage extends BasePage {

    private final static String HOVER_PAGE_URL = "/hovers";

    private final static String FIGURE_DIV = "figure";

    private final static String FIGCAPTION_DIV = "figcaption";

    @FindBy(className = FIGURE_DIV)
    private List<WebElement> avatars;

    @FindBy(className = FIGCAPTION_DIV)
    private List<WebElement> figcaptions;

    private List<String> userinfo;

    private List<Boolean> displayValues;


    public HoversPage() {
        userinfo = new ArrayList<>();
        displayValues = new ArrayList<>();
    }

    @Override
    String getSelfUrl() {
        return HOVER_PAGE_URL;
    }


    /**
     * Checks if the captions of all images on the page are not visible
     */
    public void assertAllFigureCaptionsAreNotVisible(){
        assertTrue("Figcaptures are displayed before hovering",figcaptions.stream().noneMatch(WebElement::isDisplayed));
    }

    /**
     * Makes the browser hover over given number of user avatars (starting from the DOM's first avatar)
     * @param usersNumber number of avatars to hover
     */
    public void hoverOverUserAvatar(int usersNumber){
        List<WebElement> listOfAvatars = getUsers(usersNumber);
        String pattern = "name: (.*)\n.*";
        for (WebElement avatar: listOfAvatars){
            WebElement figcapture = avatar.findElement(By.className(FIGCAPTION_DIV));
            new Actions(driver).moveToElement(avatar).build().perform();
            userinfo.add(figcapture.getText().replaceAll(pattern, "$1"));
            displayValues.add(figcapture.isDisplayed());
        }
    }

    /**
     * Checks whether figure captions of the users identified by the provided names are visible
     * @param userNames names of the users whose figure captions are checked
     */
    public void assertFigureCaptionsAreVisible(List<String> userNames){
        Boolean allDisplayed = displayValues.stream().allMatch(b -> b);
        assertTrue(String.format("Not all usernames are Displayed %s", displayValues.toString()), allDisplayed);
        assertArrayEquals("Not all user names are matched", userNames.toArray(), userinfo.toArray());
    }

    private List<WebElement> getUsers(int usersNumber){
        if (usersNumber <= avatars.size()){
            return avatars.subList(0, usersNumber);
        } else {
            throw new IllegalArgumentException("Too few users");
        }
    }

}
