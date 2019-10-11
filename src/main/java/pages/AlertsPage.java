package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {

    private WebDriver driver;
    private By btn_JSTriggeralert = By.xpath(".//button[text()='Click for JS Alert']");
    private By btn_JSConfirmalert = By.xpath(".//button[text()='Click for JS Confirm']");
    private By btn_JSPromptalert = By.xpath(".//button[text()='Click for JS Prompt']");
    private By warningMessageInAlertPage = By.id("result");

    AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void alert_clickJSTriggerAlert() {
        driver.findElement(btn_JSTriggeralert).click();
    }

    public void acceptJSTriggeredAlertpopUp() {
        driver.switchTo().alert().accept();
    }

    public String getAlertsPageWarning() {
        return driver.findElement(warningMessageInAlertPage).getText();
    }

    public void alert_clickJSConfirmAlert() {
        driver.findElement(btn_JSConfirmalert).click();
    }

    public String dismissJSTriggeredAlertpopUp() {
        String text = driver.switchTo().alert().getText();
        driver.switchTo().alert().dismiss();
        return text;
        //I am a JS Confirm
    }

    public void alert_clickJSPromptAlert() {
        driver.findElement(btn_JSPromptalert).click();
    }

    public void setTextInAlertInputBoxAndAccept(String input) {
        driver.switchTo().alert().sendKeys(input);
        driver.switchTo().alert().accept();

    }


}
