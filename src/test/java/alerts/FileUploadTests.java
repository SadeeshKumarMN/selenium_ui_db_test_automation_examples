package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload() {
        var fileUploadPage = homePage.clickFileUpload();
        fileUploadPage.clickChooseFileButton("F:\\Workspace\\resources\\chromedriver.exe");
        fileUploadPage.clickuploadButton();
        assertEquals(fileUploadPage.getUploadedFileMessage(), "chromedriver.exe", "Incorrect File uploaded/File is not Uploaded");
    }
}
