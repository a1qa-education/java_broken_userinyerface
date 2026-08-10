package pages;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class WelcomePage extends Form {
    private final ILink clickHereToGoLink = getElementFactory().getLink(By.className("start__link"), "Click HERE to Go");

    public WelcomePage() {
        super(By.className("start__button"), "Welcome page");
    }

    public void clickHereToGoLink() {
        clickHereToGoLink.click();
    }
}
