package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowsPage {

    private WebDriver driver;
    private By clickHereLink = By.linkText("Click Here");

    MultipleWindowsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickForNewWindow() {
        driver.findElement(clickHereLink).click();
    }

}
