package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploaderPage {

    private WebDriver driver;
    private By chooseFileButton = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedFileMessage = By.id("uploaded-files");


    FileUploaderPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * @param absolutePathFile - Specify the absolute path of the upload file
     */

    public void clickChooseFileButton(String absolutePathFile) {
        driver.findElement(chooseFileButton).sendKeys(absolutePathFile);
    }

    public void clickuploadButton() {
        driver.findElement(uploadButton).click();
    }

    public String getUploadedFileMessage() {
        return driver.findElement(uploadedFileMessage).getText();
    }

}
