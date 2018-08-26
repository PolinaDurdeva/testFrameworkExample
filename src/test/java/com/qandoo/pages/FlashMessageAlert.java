package com.qandoo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static org.junit.Assert.assertTrue;

/**
 * Represents a flash alert appearing at the top of a page when some notification is displayed to the user
 */
public class FlashMessageAlert extends BasePage {

    private final static String ID_FLASH = "flash";

    @FindBy(id = ID_FLASH)
    private WebElement alert;

    /**
     * Check that appeared message is equal to the provided one
     * @param message text value to compare the alert with
     */
    public void assertAlertMessageIsEqualTo(String message){
        assertTrue(alert.getText().trim().contains(message));
    }

    @Override
    String getSelfUrl() {
        throw new UnsupportedOperationException("Cannot open the auxiliary page: no url for alert element");
    }
}
