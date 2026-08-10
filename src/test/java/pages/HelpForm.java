package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HelpForm extends Form {
    private static final String HEIGHT_CSS_PROPERTY = "height";
    private static final String PIXELS_SUFFIX = "px";
    private final IButton sendToBottomBtn = getElementFactory().getButton(By.xpath("//button[contains(@class,'send-to-bottom')]"), "Send to bottom");

    HelpForm() {
        super(By.className("help-form"), "Help form");
    }

    public void clickSendToBottomBtn() {
        sendToBottomBtn.clickAndWait();
    }

    /**
     * Returns the currently rendered height of the help form in pixels.
     *
     * @return height of the form in pixels
     */
    public double getHeight() {
        String height = getFormLabel().getCssValue(HEIGHT_CSS_PROPERTY);
        return Double.parseDouble(height.replace(PIXELS_SUFFIX, ""));
    }
}
