package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import utils.WaitUtils;


public class SessionTimerTests extends BaseTest {
    private static final String EXPECTED_TIMER_VALUE = "00:00:00";
    private static final int TIMER_INTERVAL = 3;

    @Test
    public void checkTimerInitialValue() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main page should be displayed");

        Assert.assertEquals(mainPage.getTimerValue(), EXPECTED_TIMER_VALUE,
                "Timer should have initial value right after the main page is opened");

        int initialValue = convertToSeconds(mainPage.getTimerValue());
        WaitUtils.sleep(TIMER_INTERVAL);
        int actualValue = convertToSeconds(mainPage.getTimerValue());

        Assert.assertEquals(actualValue, initialValue + TIMER_INTERVAL,
                "Timer should increase by 1 second every second");
    }

    private int convertToSeconds(String timer) {
        String[] parts = timer.split(":");

        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);

        return hours * 3600 + minutes * 60 + seconds;
    }
}
