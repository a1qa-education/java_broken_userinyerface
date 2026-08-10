package tests;

import aquality.selenium.browser.AqualityServices;
import config.EnvConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod
    public void setup() {
        AqualityServices.getBrowser().maximize();
        AqualityServices.getBrowser().goTo(EnvConfigReader.getEnvData().getHost());
    }

    @AfterMethod
    public void teardown() {
        if (AqualityServices.isBrowserStarted()) {
            AqualityServices.getBrowser().quit();
        }
    }
}
