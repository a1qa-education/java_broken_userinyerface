package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.WelcomePage;

public class TimerTest extends BaseTest {
    private static final String EXPECTED_TIMER_VALUE = "00:00:00";

    @Test
    public void checkTimerInitialValue() {
        WelcomePage welcomePage = new WelcomePage();
        Assert.assertTrue(welcomePage.state().waitForDisplayed(), "Welcome page should be displayed");

        welcomePage.clickHereToGoLink();
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main page should be displayed");

        Assert.assertEquals(mainPage.getTimerValue(), EXPECTED_TIMER_VALUE,
                "Timer should have initial value right after the main page is opened");
    }
}
