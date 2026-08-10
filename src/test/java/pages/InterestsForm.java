package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.RandomUtils;
import utils.RobotUtils;

import java.util.List;

public class InterestsForm extends Form {
    private final IButton uploadBtn = getElementFactory().getButton(By.xpath("//a[contains(@class,'upload-button')]"), "Upload");
    private final IButton nextBtn = getElementFactory().getButton(By.xpath("//button[@name='button' and text()='Next']"), "Next");
    private final By interestsCheckboxesLoc = By.xpath("//label[contains(@for,'interest')]");

    InterestsForm() {
        super(By.xpath("//a[contains(@class,'avatar-and-interests')]"), "Interests form");
    }

    public void clickRandomInterests(int number) {
        List<ICheckBox> allInterests = getAllInterests();
        int counter = 0;
        while (counter < number) {
            int randomIndex = RandomUtils.getRandomInt(allInterests.size());
            allInterests.get(randomIndex).click();
            counter++;
        }
    }

    public void clickNextBtn() {
        nextBtn.click();
    }

    public void uploadAvatar(String fileName) {
        uploadBtn.click();
        RobotUtils.uploadFileFromUploadsFolder(fileName);
    }

    private List<ICheckBox> getAllInterests() {
        AqualityServices.getConditionalWait().waitFor(() -> !getElementFactory().findElements(interestsCheckboxesLoc, ICheckBox.class).isEmpty());
        return getElementFactory().findElements(interestsCheckboxesLoc, ICheckBox.class);
    }
}
