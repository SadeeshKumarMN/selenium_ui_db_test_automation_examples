package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {
    private WebDriver driver;
    private By hotSpotBox = By.id("hot-spot");


    ContextMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickHotSpotBox() {
        WebElement box = driver.findElement(hotSpotBox);
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();
    }

    public String getAlertPopUpText() {
        String alertMessage = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return alertMessage;
    }
}
