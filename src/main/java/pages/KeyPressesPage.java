package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyPressesPage {
    private WebDriver driver;
    private By keyPressInputBox = By.id("target");
    private By resultMessage = By.id("result");

    KeyPressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setkeyPressInputBox(String inputText) {
        driver.findElement(keyPressInputBox).sendKeys(inputText);
    }

    public void setPiValue() {
        Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_NUM_LOCK, true);
        setkeyPressInputBox(Keys.chord(Keys.LEFT_ALT, Keys.ADD, Keys.NUMPAD2, Keys.NUMPAD2, Keys.NUMPAD7, Keys.LEFT_ALT) + "=3.14");
        Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_NUM_LOCK, false);

    }

    public String getResultMessage() {
        return driver.findElement(resultMessage).getText();
    }

}
