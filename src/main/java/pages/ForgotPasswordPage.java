package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;
    private By emailInputField = By.id("email");
    private By retrievePasswordButton = By.id("form_submit");

    ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmailInputField(String email) {
        driver.findElement(emailInputField).sendKeys(email);
    }

    public EmailConfirmationPage clickretrievePasswordButton() {
        driver.findElement(retrievePasswordButton).click();
        return new EmailConfirmationPage(driver);
    }
}
