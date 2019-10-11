package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailConfirmationPage {
    private WebDriver driver;
    private By EmailConfirmationMessage = By.id("content");


    EmailConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getEmailConfirmationMessage() {
        return driver.findElement(EmailConfirmationMessage).getText();
    }
}
