package utils;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class WebDriverManager {

    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WebDriverManager(WebDriver driver) {
        this.driver = driver;
        this.navigate = driver.navigate();

    }

    public void goBack() {
        navigate.back();
    }

    public void goForward() {
        navigate.forward();
    }

    public void refreshPage() {
        navigate.refresh();
    }

    public void to(String url) {
        navigate.to(url);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void moveToNewTab() {
        Set<String> windowHandles = driver.getWindowHandles();
        windowHandles.forEach(driver.switchTo()::window);
    }

    public void moveToRightTab(String titlePage) {
        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println("The number of windows currently available in the browser " + windowHandles.size());

        System.out.println("Here is the windows ids");

        windowHandles.forEach(System.out::println);

        for (String window : windowHandles) {
            System.out.println("Switch to window " + window);
            driver.switchTo().window(titlePage);
            if (getTitle().equals(titlePage)) {
                break;
            }
        }
    }

    public void moveToFirstTab() {
        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println("The number of windows currently available in the browser " + windowHandles.size());

        System.out.println("Here is the windows ids");

        windowHandles.forEach(System.out::println);

        for (String window : windowHandles) {
            System.out.println("Switch to window " + window);
            driver.switchTo().window(window);
            break;
        }
    }
}

