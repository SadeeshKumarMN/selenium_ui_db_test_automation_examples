package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropDownPage {

    private WebDriver driver;
    private By dropdown = By.id("dropdown");
    private String jsdropdown = "arguments[0].setAttribute('multiple', '')";

    DropDownPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectOption(String option) {
        dropdownElement(dropdown).selectByVisibleText(option);
    }

    public boolean isMultiple() {
        return dropdownElement(dropdown).isMultiple();
    }

    public void makeMultiSelectionDropDown() {
        String script = jsdropdown;
        ((JavascriptExecutor) driver).executeScript(script, dropdownElement(dropdown));
    }


    private Select dropdownElement(By identifier) {
        return new Select(driver.findElement(identifier));
    }

    public List<String> getSelectedOptions() {
        List<WebElement> selectedElements = dropdownElement(dropdown).getAllSelectedOptions();
        return selectedElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
