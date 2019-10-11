package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class DynamicLoadingPage {

    private WebDriver driver;
    private String link_Text = ".//a[contains(text(),'%s')]";
    private By dynamicElement1Identifier = By.xpath(String.format(link_Text, "Example 1"));
    private By dynamicElement2Identifier = By.xpath(String.format(link_Text, "Example 2"));

    DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public DynamicLoadedPage clickDynamicElement1() {
        clickLink(dynamicElement1Identifier);
        return new DynamicLoadedPage(driver);
    }

    public DynamicLoadedPage clickDynamicElement2() {
        clickLink(dynamicElement2Identifier);
        return new DynamicLoadedPage(driver);

    }

    public DynamicLoadedPage contextClickDynamicElement2() {
        contextClick();
        return new DynamicLoadedPage(driver);

    }

    private void clickLink(By linkTest) {
        driver.findElement(linkTest).click();
    }

    private void contextClick() {
        driver.findElement(dynamicElement2Identifier).sendKeys(Keys.CONTROL, Keys.RETURN);
    }
}
