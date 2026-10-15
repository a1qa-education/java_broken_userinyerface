package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CookiesPolicyTests extends BaseTest {

    @Test
    public void dismissCookiesBanner() {
        CookieForm cookieForm = new MainPage().getCookieForm();
        cookieForm.clickAcceptCookiesBtn();
        Assert.assertTrue(cookieForm.state().waitForNotDisplayed(), "Cookies form should be hidden");
    }
}
