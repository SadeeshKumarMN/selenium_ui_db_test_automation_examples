package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeAndDeepDomPage {
    private WebDriver driver;
    private By tableIdentifier = By.id("large-table");
    private By finalElementInTable = By.xpath("//td[text()='50.50']");

    LargeAndDeepDomPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToVerticalBarEnd() {
        WebElement tableElement = driver.findElement(tableIdentifier);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor) driver).executeScript(script, tableElement);

    }

    public void scrollToHorizontalBarEnd() {
        WebElement tableFinalElement = driver.findElement(finalElementInTable);
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor) driver).executeScript(script, tableFinalElement);
    }


}
