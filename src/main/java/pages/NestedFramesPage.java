package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {
    private WebDriver driver;
    private String leftFrame = "frame-left";
    private String bottomFrame = "frame-bottom";
    private String topFrame = "frame-top";
    private By leftFrameContent = By.xpath(".//body[contains(text(),'LEFT')]");
    private By bottomFrameContent = By.xpath(".//body[contains(text(),'BOTTOM')]");

    NestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public String moveToLeftIFrame() {
        moveToTopIFrame();
        driver.switchTo().frame(leftFrame);
        String leftIFrameText = getIFrameText(leftFrameContent);
        moveToParentPage();
        return leftIFrameText;

    }

    public String moveToBottomIFrame() {
        driver.switchTo().frame(bottomFrame);
        String bottomIFrameText = getIFrameText(bottomFrameContent);
        moveToParentPage();
        return bottomIFrameText;
    }

    private void moveToParentPage() {
        driver.switchTo().defaultContent();
    }

    private void moveToTopIFrame() {
        driver.switchTo().frame(topFrame);
    }

    private String getIFrameText(By identifier) {
        return driver.findElement(identifier).getText();

    }
}
