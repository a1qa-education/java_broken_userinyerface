package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import constants.Domains;
import org.openqa.selenium.By;

public class SignUpForm extends Form {
    private static final By PASSWORD_FIELD_LOC = By.xpath("//div[contains(@class,'login-form')]/input");
    private static final String DOMAIN_ITEM_LOC_TEMPLATE = "//div[contains(@class,'dropdown__list-item') and normalize-space(text())='%s']";
    private final ITextBox passwordField = getElementFactory().getTextBox(PASSWORD_FIELD_LOC, "Password field");
    private final ITextBox emailField = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'email')]"), "Email field");
    private final ITextBox domainField = getElementFactory().getTextBox(By.xpath("//input[contains(@placeholder,'Domain')]"), "Domain field");
    private final IButton domainDropdown = getElementFactory().getButton(By.xpath("//div[contains(@class,'login-form')]//div[contains(@class,'opener')]"), "Domain dropdown");
    private final IButton nextBtn = getElementFactory().getButton(By.xpath("//div[contains(@class,'login-form')]//a[text()='Next']"), "Next");

    SignUpForm() {
        super(PASSWORD_FIELD_LOC, "Sign Up form");
    }

    public void typePassword(String password) {
        passwordField.clearAndType(password);
    }

    public void typeEmail(String email) {
        emailField.clearAndType(email);
    }

    public void typeDomain(String domain) {
        domainField.clearAndType(domain);
    }

    public void selectDomain(Domains domain) {
        domainDropdown.click();
        getDomainDropdownItem(domain).click();
    }

    public void clickNextBtn() {
        nextBtn.click();
    }

    private IButton getDomainDropdownItem(Domains domain) {
        return getElementFactory().getButton(By.xpath(DOMAIN_ITEM_LOC_TEMPLATE.formatted(domain.getDomain())),
                "%s domain dropdown item".formatted(domain.getDomain()));
    }
}
