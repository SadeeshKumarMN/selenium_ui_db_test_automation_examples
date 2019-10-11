package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AlertTests extends BaseTests {

    @Test
    public void testForJSAlertAccept() {
        var alertPage = homePage.clickKeyAlerts();
        alertPage.alert_clickJSTriggerAlert();
        alertPage.acceptJSTriggeredAlertpopUp();
        assertEquals(alertPage.getAlertsPageWarning(), "You successfuly clicked an alert", "Incorrect Accept Warning");
    }

    @Test
    public void testForJSAlertConfirm() {
        var alertPage = homePage.clickKeyAlerts();
        alertPage.alert_clickJSConfirmAlert();
        String MessageInPopUp = alertPage.dismissJSTriggeredAlertpopUp();
        assertEquals(MessageInPopUp, "I am a JS Confirm", "Incorrect Message thrown inside the Pop-up");
        assertEquals(alertPage.getAlertsPageWarning(), "You clicked: Cancel", "Incorrect Cancel Warning");
    }

    @Test
    public void testForJSAlertPrompt() {
        var alertPage = homePage.clickKeyAlerts();
        String inputMessage = "TAU really rocks!";
        alertPage.alert_clickJSPromptAlert();
        alertPage.setTextInAlertInputBoxAndAccept(inputMessage);
        assertEquals(alertPage.getAlertsPageWarning(), "You entered: " + inputMessage, "Incorrect Prompt Warning");

    }
}
