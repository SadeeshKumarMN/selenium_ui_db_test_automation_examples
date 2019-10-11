package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IFrameTests extends BaseTests {

    @Test
    public void testIFrames() {
        var framesPage = homePage.clickFrames();
        var iFramePage = framesPage.clickIFrame();
        iFramePage.clearContentFromInputBox();
        iFramePage.setIframeInputText("Hello");
        iFramePage.clickIncreaseIndent();
        iFramePage.setIframeInputText(" World");
        assertEquals(iFramePage.getIframeInputText(), "Hello World", "Incorrect Content from EditArea");
    }

    @Test
    public void testNestedFrames() {
        var framesPage = homePage.clickFrames();
        var nestedFramePage = framesPage.clickNestedFrame();
        String leftIFrameContent = nestedFramePage.moveToLeftIFrame();
        assertEquals(leftIFrameContent, "LEFT", "Incorrect left IFrame Content");
        String bottomIFrameContent = nestedFramePage.moveToBottomIFrame();
        assertEquals(bottomIFrameContent, "BOTTOM", "Incorrect bottom IFrame Content");
    }

}
