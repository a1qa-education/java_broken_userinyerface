package tests;

import aquality.selenium.browser.AqualityServices;
import constants.Domains;
import models.EmailData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.TestDataReader;

import java.util.Arrays;
import java.util.List;

public class CardOneCredentialsTests extends BaseTest {
    private static final String FIRST_CARD_PAGE_INDICATOR_TEXT = "1 / 4";
    private static final String SECOND_CARD_PAGE_INDICATOR_TEXT = "2 / 4";
    private final SignUpForm signUpForm = new MainPage().getSignUpForm();
    private final InterestsForm interestsForm = new MainPage().getInterestsForm();
    private final EmailData emailTestData = TestDataReader.getEmailData();

    @Test
    public void checkPasswordPolicyCompliance() {
        Domains domain = Domains.valueOf(emailTestData.getEmailExtension().toUpperCase());

        Assert.assertTrue(signUpForm.state().waitForDisplayed(), "Sign Up card should be displayed");
        Assert.assertEquals(signUpForm.getPageIndicatorText(), FIRST_CARD_PAGE_INDICATOR_TEXT, "Page Indicator should be the same as expected");

        fillCredentials(domain, emailTestData.getFirstPassword());
        signUpForm.clickNextBtn();

        Assert.assertTrue(interestsForm.state().waitForDisplayed(), "Interests card should be displayed");
        Assert.assertEquals(interestsForm.getPageIndicatorText(), SECOND_CARD_PAGE_INDICATOR_TEXT, "Page Indicator should be the same as expected");
    }

    @Test
    public void checkEmailDomainExtensions() {
        List<Domains> emailExtensions = Arrays.stream(Domains.values()).toList();

        Assert.assertTrue(signUpForm.state().waitForDisplayed(), "Sign Up card should be displayed");
        Assert.assertEquals(signUpForm.getPageIndicatorText(), FIRST_CARD_PAGE_INDICATOR_TEXT, "Page Indicator should be the same as expected");

        emailExtensions.forEach(emailExtension -> {
            fillCredentials(emailExtension, emailTestData.getSecondPassword());
            signUpForm.clickNextBtn();
            Assert.assertTrue(interestsForm.state().waitForDisplayed(), "Interests card should be displayed");
            Assert.assertEquals(interestsForm.getPageIndicatorText(), SECOND_CARD_PAGE_INDICATOR_TEXT, "Page Indicator should be the same as expected");
            AqualityServices.getBrowser().refresh();
        });
    }

    private void fillCredentials(Domains domain, String password) {
        signUpForm.typePassword(password);
        signUpForm.typeEmail(emailTestData.getEmailName());
        signUpForm.typeDomain(emailTestData.getEmailDomain());
        signUpForm.selectDomain(domain);
        signUpForm.acceptTermsConditions();
    }
}
