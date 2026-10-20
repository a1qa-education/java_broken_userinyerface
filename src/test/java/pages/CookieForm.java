package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CookieForm extends Form {
    private final IButton acceptCookiesBtn = getElementFactory().getButton(By.xpath("//button[text()='Not really,no']"), "Accept Cookies");

    CookieForm() {
        super(By.className("cookies"), "Cookie form");
    }

    public void clickAcceptCookiesBtn() {
        acceptCookiesBtn.clickAndWait();
    }
}
