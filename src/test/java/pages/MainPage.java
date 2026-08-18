package pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {
    private final ILabel timerLabel = getElementFactory().getLabel(By.cssSelector("div.timer--gray"), "Timer");

    private SignUpForm signUpForm;
    private InterestsForm interestsForm;
    private PersonalDetailsForm personalDetailsForm;
    private HelpForm helpForm;
    private CookieForm cookieForm;

    public MainPage() {
        super(By.className("bagaar-link__image"), "Main page");
    }

    public String getTimerValue() {
        return timerLabel.getText();
    }

    public SignUpForm getSignUpForm() {
        if (signUpForm == null) {
            signUpForm = new SignUpForm();
        }
        return signUpForm;
    }

    public InterestsForm getInterestsForm() {
        if (interestsForm == null) {
            interestsForm = new InterestsForm();
        }
        return interestsForm;
    }

    public PersonalDetailsForm getPersonalDetailsForm() {
        if (personalDetailsForm == null) {
            personalDetailsForm = new PersonalDetailsForm();
        }
        return personalDetailsForm;
    }

    public HelpForm getHelpForm() {
        if (helpForm == null) {
            helpForm = new HelpForm();
        }
        return helpForm;
    }

    public CookieForm getCookieForm() {
        if (cookieForm == null) {
            cookieForm = new CookieForm();
        }
        return cookieForm;
    }
}
