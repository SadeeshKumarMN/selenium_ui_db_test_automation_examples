package forgotPassword;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testForgotPassword() {
        var forgotPasswordPage = homePage.clickForgotPassword();
        forgotPasswordPage.setEmailInputField("tau@example.com");
        var emailConfirmationPage = forgotPasswordPage.clickretrievePasswordButton();
        var emailSuccessMessage = emailConfirmationPage.getEmailConfirmationMessage();
        assertTrue(emailSuccessMessage.contains("Your e-mail's been sent!"), "Incorrect Success Message");
    }
}
