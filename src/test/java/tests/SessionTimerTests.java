package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import utils.WaitUtils;

public class SessionTimerTests extends BaseTest {
    private static final String EXPECTED_TIMER_VALUE = "00:00:00";
    private static final long TIMER_DISPLAY_TIMEOUT_MS = 850;

    @Test
    public void checkTimerInitialValue() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main page should be displayed");

        WaitUtils.sleep(TIMER_DISPLAY_TIMEOUT_MS);
        Assert.assertEquals(mainPage.getTimerValue(), EXPECTED_TIMER_VALUE,
                "Timer should have initial value right after the main page is opened");
    }
}
