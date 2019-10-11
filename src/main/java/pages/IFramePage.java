package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IFramePage {

    private WebDriver driver;
    private String iFrameInputBoxArea = "mce_0_ifr";
    private By iFrameInputText = By.id("tinymce");
    private By increaseIndentButton = By.id("mceu_12");

    IFramePage(WebDriver driver) {
        this.driver = driver;

    }

    private void moveToiFrameInputBoxArea() {
        driver.switchTo().frame(iFrameInputBoxArea);
    }

    public void clearContentFromInputBox() {
        moveToiFrameInputBoxArea();
        driver.findElement(iFrameInputText).clear();
        moveToParentFrame();
    }

    public void clickIncreaseIndent() {
        driver.findElement(increaseIndentButton).click();

    }

    private void moveToParentFrame() {
        driver.switchTo().parentFrame();

    }

    public String getIframeInputText() {
        moveToiFrameInputBoxArea();
        String outputMessage = driver.findElement(iFrameInputText).getText();
        moveToParentFrame();
        return outputMessage;

    }

    public void setIframeInputText(String text) {
        moveToiFrameInputBoxArea();
        driver.findElement(iFrameInputText).sendKeys(text);
        moveToParentFrame();

    }


}
