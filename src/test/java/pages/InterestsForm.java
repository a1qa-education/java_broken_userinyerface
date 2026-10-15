package pages;


import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class InterestsForm extends Form {
    private final ILabel pageIndicatorLabel = getElementFactory().getLabel(By.cssSelector("div.page-indicator"), "Page Indicator");

    InterestsForm() {
        super(By.xpath("//a[contains(@class,'avatar-and-interests')]"), "Interests form");
    }

    public String getPageIndicatorText() {
        return pageIndicatorLabel.getText();
    }
}
