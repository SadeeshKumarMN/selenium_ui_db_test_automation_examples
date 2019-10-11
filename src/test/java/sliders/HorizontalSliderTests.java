package sliders;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class HorizontalSliderTests extends BaseTests {

    @Test
    public void testHorizontalSliderMovement() {
        var horizontalSliderPage = homePage.clickHorizontalSlider();
        horizontalSliderPage.moveHorizontalSlider("5");
        assertEquals(horizontalSliderPage.getFocusScore(), "6", "Incorrect Movement");
    }
}
