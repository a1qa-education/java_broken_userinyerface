package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HelpForm extends Form {
    private final IButton sendToBottomBtn = getElementFactory().getButton(By.xpath("//button[contains(@class,'send-to-bottom')]"), "Send to bottom");

    HelpForm() {
        super(By.className("help-form"), "Help form");
    }

    public void clickSendToBottomBtn() {
        sendToBottomBtn.clickAndWait();
    }
}
