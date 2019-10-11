package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {

    private WebDriver driver;
    private String iFrameLink = "iFrame";
    private String nestedFramesLink = "Nested Frames";

    FramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public IFramePage clickIFrame() {
        clickLink(iFrameLink);
        return new IFramePage(driver);
    }

    public NestedFramesPage clickNestedFrame() {
        clickLink(nestedFramesLink);
        return new NestedFramesPage(driver);
    }

    private void clickLink(String linkTest) {
        driver.findElement(By.linkText(linkTest)).click();
    }
}
