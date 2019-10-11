package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {
    private WebDriver driver;
    private By hoverOverElement = By.className("figure");
    private By hoveredContent = By.className("figcaption");


    HoversPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * @param index starts with 1
     */

    public CaptionBox mouseHoverOverElement(int index) {
        WebElement hoveredElement = driver.findElements(hoverOverElement).get(index - 1);
        Actions actions = new Actions(driver);
        actions.moveToElement(hoveredElement).perform();
        return new CaptionBox(hoveredElement.findElement(hoveredContent));
    }

    //Descriptive Programming
    public class CaptionBox {

        WebElement caption;
        private By header = By.tagName("h5");
        private By link = By.tagName("a");

        CaptionBox(WebElement caption) {
            this.caption = caption;
        }

        public boolean isHoveredContentDisplayed() {
            return caption.isDisplayed();
        }


        public String getHoveredHeaderText() {
            return caption.findElement(header).getText();
        }

        public String getHoveredLinkText() {
            return caption.findElement(link).getText();

        }

        public String getHoveredLink() {
            return caption.findElement(link).getAttribute("href");
        }

    }

}
