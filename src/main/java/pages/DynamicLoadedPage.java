package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicLoadedPage {

    private WebDriver driver;
    private By startButton = By.cssSelector("#start button");
    private By loadingElement = By.id("loading");
    private By messageAfterLoaded = By.id("finish");

    DynamicLoadedPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickDynamicLoadedExample1() {

        clickButton(startButton);
        WebDriverWait explicitWait = new WebDriverWait(driver, 5);
        explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(loadingElement));
    }

    public void clickDynamicLoadedExample2() {
        clickButton(startButton);
        FluentWait<WebDriver> fluentWait = new FluentWait<>(driver);
        fluentWait.withTimeout(Duration.ofSeconds(7));
        fluentWait.pollingEvery(Duration.ofSeconds(1));
        fluentWait.ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.presenceOfElementLocated(messageAfterLoaded));
    }

    public boolean isStartButtonEnabled() {
        return driver.findElement(startButton).isEnabled();
    }

    public String getMessageAfterLoaded() {
        return driver.findElement(messageAfterLoaded).getText();
    }

    private void clickButton(By startButton) {
        driver.findElement(startButton).click();
    }

}
