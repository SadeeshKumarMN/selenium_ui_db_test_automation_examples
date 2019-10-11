package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {
    private WebDriver driver;
    private By paragraphIdentifier = By.className("jscroll-added");

    InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * scrolls until the paragraph with index specifid is in view;
     *
     * @param index starts with 1
     */
    public void scrollToInfinite(int index) {
        String script = "window.scrollTo(0,document.body.scrollHeight)";
        var jscriptExecutor = (JavascriptExecutor) driver;
        while (getSizeOftheParagraphs() < index) {
            jscriptExecutor.executeScript(script);
        }
    }

    public int getSizeOftheParagraphs() {
        return driver.findElements(paragraphIdentifier).size();
    }

}
