package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage {

    private By horizontalSlider = By.cssSelector(".sliderContainer input");
    private By focusScore = By.id("range");

    private WebDriver driver;

    HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void moveHorizontalSlider(String expectedCount) {
        while (!getFocusScore().equals(expectedCount)) {
            driver.findElement(horizontalSlider).sendKeys(Keys.chord(Keys.ARROW_RIGHT));
        }
    }

    public String getFocusScore() {
        return driver.findElement(focusScore).getText();

    }
}
